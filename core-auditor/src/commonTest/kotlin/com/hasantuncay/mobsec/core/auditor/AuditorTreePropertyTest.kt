package com.hasantuncay.mobsec.core.auditor

import com.hasantuncay.mobsec.core.auditor.data.StorageAuditorTrees
import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode
import com.hasantuncay.mobsec.core.auditor.validator.AuditorTreeValidator
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * AuditorTreePropertyTest: MASWE-0001..0006 Karar Ağaçlarının Formel Yapısal ve Kahn Değişmezleri Testi.
 *
 * Denetlenen Değişmezler:
 * 1. Kahn Algoritması Çevrimsizlik (|L| == |V| - Strict DAG).
 * 2. Kök düğümün varlığı ve QuestionNode olması.
 * 3. Her soru düğümünün en az 2 seçeneğe sahip olması (Hick Kanunu & Dallanma).
 * 4. Dangling Pointer olmaması: Tüm Option.next referanslarının nodes haritasında bulunması.
 * 5. Kökten %100 Ulaşılabilirlik (0 orphan/ölü düğüm).
 * 6. Her düğümden en az bir terminal ResultNode'a giden geçerli bir yolun bulunması (Dead-end olmaması).
 * 7. Tüm yaprak düğümlerin (out_degree == 0) ResultNode olması.
 */
class AuditorTreePropertyTest {

    private val allTrees: List<AuditorTree> = StorageAuditorTrees.allStorageTrees

    @Test
    fun test_catalog_contains_all_six_storage_trees() {
        assertEquals(6, allTrees.size, "MASVS-STORAGE kataloğunda tam 6 ağaç bulunmalıdır")
        val expectedIds = (1..6).map { "maswe-000$it" }.toSet()
        val actualIds = allTrees.map { it.id }.toSet()
        assertEquals(expectedIds, actualIds, "Katalog MASWE-0001'den MASWE-0006'ya kadar tüm ağaçları içermelidir")
    }

    @Test
    fun test_kahn_acyclicity_on_all_storage_trees() {
        for (tree in allTrees) {
            val hasCycle = AuditorTreeValidator.detectCycleKahn(tree)
            assertFalse(
                hasCycle,
                "Ağaç ${tree.id} Kahn topolojik sıralamasında döngü içermemelidir (|L| == |V| sağlanmalı)"
            )
        }
    }

    @Test
    fun test_auditor_validator_full_pass_on_all_storage_trees() {
        for (tree in allTrees) {
            val validation = AuditorTreeValidator.validate(tree)
            assertTrue(
                validation.isValid,
                "Ağaç ${tree.id} doğrulayıcıdan hatasız geçmelidir. Hatalar: ${validation.errors}"
            )
            assertTrue(validation.errors.isEmpty(), "Hata listesi boş olmalıdır")
        }
    }

    @Test
    fun test_root_node_invariant() {
        for (tree in allTrees) {
            assertTrue(tree.nodes.containsKey(tree.startNode), "${tree.id}: startNode haritada mevcut olmalı")
            val root = tree.nodes[tree.startNode]
            assertTrue(root is QuestionNode, "${tree.id}: startNode bir QuestionNode olmalı")
        }
    }

    @Test
    fun test_question_node_options_invariant() {
        for (tree in allTrees) {
            for ((nodeId, node) in tree.nodes) {
                if (node is QuestionNode) {
                    assertTrue(
                        node.options.size >= 2,
                        "${tree.id} / $nodeId: QuestionNode en az 2 seçeneğe sahip olmalıdır, mevcut: ${node.options.size}"
                    )
                    for (opt in node.options) {
                        assertTrue(
                            opt.text.isNotBlank(),
                            "${tree.id} / $nodeId: Seçenek metni boş olamaz"
                        )
                        assertTrue(
                            tree.nodes.containsKey(opt.next),
                            "${tree.id} / $nodeId: Seçenek hedefi '${opt.next}' ağaçta bulunmalıdır (Dangling Pointer)"
                        )
                    }
                }
            }
        }
    }

    @Test
    fun test_result_node_status_invariant() {
        val validStatuses = setOf("pass", "fail", "warning", "info")
        for (tree in allTrees) {
            val resultNodes = tree.nodes.filterValues { it is ResultNode }
            assertTrue(resultNodes.isNotEmpty(), "${tree.id}: En az bir ResultNode bulunmalıdır")

            for ((nodeId, node) in resultNodes) {
                val result = node as ResultNode
                assertTrue(
                    result.status.lowercase() in validStatuses,
                    "${tree.id} / $nodeId: Geçersiz sonuç durumu: '${result.status}'"
                )
            }
        }
    }

    @Test
    fun test_all_leaf_nodes_are_result_nodes() {
        for (tree in allTrees) {
            for ((nodeId, node) in tree.nodes) {
                when (node) {
                    is ResultNode -> {
                        // ResultNode yaprak olmalı
                    }
                    is QuestionNode -> {
                        assertTrue(
                            node.options.isNotEmpty(),
                            "${tree.id} / $nodeId: QuestionNode yaprak olamaz, seçenekleri bulunmalıdır"
                        )
                    }
                }
            }
        }
    }

    @Test
    fun test_terminal_reachability_every_question_leads_to_result() {
        for (tree in allTrees) {
            for (nodeId in tree.nodes.keys) {
                val leadsToTerminal = canReachTerminal(tree, nodeId)
                assertTrue(
                    leadsToTerminal,
                    "${tree.id}: '$nodeId' düğümünden herhangi bir terminal ResultNode'a ulaşılamıyor (Dead-end)"
                )
            }
        }
    }

    @Test
    fun test_max_path_depth_is_finite_and_bounded() {
        val maxAllowedDepth = 25
        for (tree in allTrees) {
            val maxDepth = computeMaxDepth(tree, tree.startNode, mutableSetOf())
            assertTrue(
                maxDepth <= maxAllowedDepth,
                "${tree.id}: Ağaç maksimum derinliği ($maxDepth) izin verilen limiti ($maxAllowedDepth) aşamaz"
            )
        }
    }

    // --- Yardımcı Doğrulama Fonksiyonları ---

    private fun canReachTerminal(tree: AuditorTree, startId: String): Boolean {
        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<String>()
        queue.add(startId)
        visited.add(startId)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val node = tree.nodes[current] ?: continue
            if (node is ResultNode) return true
            if (node is QuestionNode) {
                for (opt in node.options) {
                    if (visited.add(opt.next)) {
                        queue.add(opt.next)
                    }
                }
            }
        }
        return false
    }

    private fun computeMaxDepth(tree: AuditorTree, currentId: String, visitedInPath: MutableSet<String>): Int {
        val node = tree.nodes[currentId] ?: return 0
        if (node is ResultNode) return 1
        if (node is QuestionNode) {
            visitedInPath.add(currentId)
            var maxChildDepth = 0
            for (opt in node.options) {
                if (!visitedInPath.contains(opt.next)) {
                    val childDepth = computeMaxDepth(tree, opt.next, visitedInPath.toMutableSet())
                    if (childDepth > maxChildDepth) {
                        maxChildDepth = childDepth
                    }
                }
            }
            return 1 + maxChildDepth
        }
        return 0
    }
}
