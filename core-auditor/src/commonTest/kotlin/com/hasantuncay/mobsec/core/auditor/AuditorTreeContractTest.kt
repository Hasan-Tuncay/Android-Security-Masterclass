package com.hasantuncay.mobsec.core.auditor

import com.hasantuncay.mobsec.core.auditor.models.AuditorNode
import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Formel Sözleşme Testleri: C1 ve C3
 *
 * Referans Doküman: analysis_report.md
 * - C1: Pure State Reducer & DAG Traversal Sözleşmesi
 * - C3: Tree Structural Invariant & Catalog Integrity Sözleşmesi
 *
 * Bu test sınıfı, core-auditor içinde üretilecek olan AuditorReducer ve AuditorTreeValidator
 * sınıflarını doğrudan çağırarak sözleşme şartlarını ve yanlışlanabilirlik maddelerini doğrular.
 */
class AuditorTreeContractTest {

    // --- Test Ağaçları (Fixtures) ---

    private val validTree = AuditorTree(
        id = "maswe-0001",
        title = "Sensitive Data Stored Unencrypted in Private Storage",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Uygulama dahili depolamada veri saklıyor mu?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Saklanan veri hassas nitelikte mi?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Hassas veriler at-rest durumunda kriptolanıyor mu?",
                options = listOf(
                    Option("Hayır", "res_fail"),
                    Option("Evet", "res_pass")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    private val danglingTree = AuditorTree(
        id = "maswe-dangling",
        title = "Dangling Node Tree",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Kör referans testi",
                options = listOf(
                    Option("Bozuk Yol", "non_existent_node_id"),
                    Option("Normal Yol", "res_pass")
                )
            ),
            "res_pass" to ResultNode(status = "pass")
        )
    )

    private val cyclicTree = AuditorTree(
        id = "maswe-cycle",
        title = "Cyclic Tree",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Döngü 1",
                options = listOf(
                    Option("İlerle", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Döngü 2 (q1'e geri dönüyor)",
                options = listOf(
                    Option("Geri Dön", "q1")
                )
            )
        )
    )

    private val orphanedTree = AuditorTree(
        id = "maswe-orphan",
        title = "Tree with Unreachable Node",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Başlangıç",
                options = listOf(
                    Option("Bitir", "res_pass")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "orphan_q" to QuestionNode(
                text = "Ölü Soru (Erişilemez)",
                options = listOf(
                    Option("Kayıp", "res_pass")
                )
            )
        )
    )

    // =========================================================================
    // C1: Pure State Reducer & DAG Traversal Sözleşmesi
    // =========================================================================

    @Test
    fun test_C1_postcondition_valid_transition_advances_and_records_visited() {
        // Önkoşul: currentNodeId in tree.nodes.keys && option in currentNode.options
        val option = (validTree.nodes["q1"] as QuestionNode).options[1] // "Evet" -> "q2"
        val result = AuditorReducer.reduce(
            tree = validTree,
            currentNodeId = "q1",
            option = option,
            visitedNodes = emptyList()
        )

        // Sonkoşul: resultNodeId == option.next && visitedNodes' == visitedNodes + currentNodeId
        assertEquals("q2", result.nextNodeId)
        assertEquals(listOf("q1"), result.visitedNodes)
    }

    @Test
    fun test_C1_invariant_visited_nodes_never_contains_next_node_strict_dag() {
        // Değişmez: Strict DAG - Asla daha önce ziyaret edilen düğüme geri dönülmez (döngü engelleme)
        val visited = listOf("q1", "q2")
        val cyclicOption = Option("Geri Dön", "q1")
        assertFailsWith<IllegalStateException> {
            AuditorReducer.reduce(
                tree = cyclicTree,
                currentNodeId = "q2",
                option = cyclicOption,
                visitedNodes = visited
            )
        }
    }

    @Test
    fun test_C1_falsifiability_dangling_reference_target_node_rejected() {
        // Yanlışlanabilirlik: Var olmayan next-node-id (Dangling Reference) reddedilmeli
        val danglingOption = (danglingTree.nodes["q1"] as QuestionNode).options[0]
        assertFailsWith<IllegalArgumentException> {
            AuditorReducer.reduce(
                tree = danglingTree,
                currentNodeId = "q1",
                option = danglingOption,
                visitedNodes = emptyList()
            )
        }
    }

    @Test
    fun test_C1_falsifiability_option_selection_on_result_node_rejected() {
        // Yanlışlanabilirlik: QuestionNode dışındaki bir düğümden (ResultNode) option seçimi engellenmeli
        val fakeOption = Option("Yasa Dışı", "q1")
        assertFailsWith<IllegalStateException> {
            AuditorReducer.reduce(
                tree = validTree,
                currentNodeId = "res_pass",
                option = fakeOption,
                visitedNodes = listOf("q1", "q2", "q3")
            )
        }
    }

    // =========================================================================
    // C3: Tree Structural Invariant Sözleşmesi (Katalog Bütünlüğü)
    // =========================================================================

    @Test
    fun test_C3_postcondition_valid_tree_satisfies_all_invariants() {
        // Sonkoşul: Geçerli ağaçta hiçbir kural ihlali bulunmamalıdır
        val result = AuditorTreeValidator.validate(validTree)
        assertTrue(result.isValid, "Geçerli ağaç yapısal olarak doğrulanmalıdır")
        assertTrue(result.errors.isEmpty(), "Geçerli ağaçta hata listesi boş olmalıdır: ${result.errors}")
    }

    @Test
    fun test_C3_falsifiability_missing_start_node_fails_validation() {
        // Yanlışlanabilirlik: startNode haritada yoksa doğrulama başarısız olmalı
        val brokenTree = validTree.copy(startNode = "non_existent_start")
        val result = AuditorTreeValidator.validate(brokenTree)
        assertFalse(result.isValid, "Kök düğümü olmayan ağaç geçersiz sayılmalı")
        assertTrue(result.errors.any { it.contains("startNode", ignoreCase = true) })
    }

    @Test
    fun test_C3_falsifiability_dangling_next_node_fails_validation() {
        // Yanlışlanabilirlik: Seçeneklerde var olmayan düğüme referans veren ağaç reddedilmeli
        val result = AuditorTreeValidator.validate(danglingTree)
        assertFalse(result.isValid, "Kör referans içeren ağaç geçersiz sayılmalı")
        assertTrue(
            result.errors.any {
                it.contains("non_existent_node_id", ignoreCase = true) || it.contains("dangling", ignoreCase = true)
            }
        )
    }

    @Test
    fun test_C3_falsifiability_cyclic_graph_fails_validation() {
        // Yanlışlanabilirlik: Döngü içeren ağaç hasCycles/topolojik kontrolde reddedilmeli
        val result = AuditorTreeValidator.validate(cyclicTree)
        assertFalse(result.isValid, "Döngü içeren ağaç geçersiz sayılmalı")
        assertTrue(result.errors.any { it.contains("cycle", ignoreCase = true) })
    }

    @Test
    fun test_C3_falsifiability_unreachable_dead_code_node_fails_validation() {
        // Yanlışlanabilirlik: Kök düğümden erişilemeyen ölü düğümler (orphan) tespit edilmeli
        val result = AuditorTreeValidator.validate(orphanedTree)
        assertFalse(result.isValid, "Erişilemez düğüm içeren ağaç geçersiz sayılmalı")
        assertTrue(
            result.errors.any {
                it.contains("unreachable", ignoreCase = true) || it.contains("orphan", ignoreCase = true)
            }
        )
    }

    @Test
    fun test_C3_falsifiability_question_node_with_insufficient_options_fails_validation() {
        // Yanlışlanabilirlik: 2'den az seçeneği olan QuestionNode yapısal değişmez ihlali olarak reddedilmeli
        val singleOptionTree = AuditorTree(
            id = "single-opt",
            title = "Single Option Tree",
            startNode = "q1",
            nodes = mapOf(
                "q1" to QuestionNode(
                    text = "Tek seçenekli hatalı soru",
                    options = listOf(Option("Tek Yol", "res_pass"))
                ),
                "res_pass" to ResultNode(status = "pass")
            )
        )
        val result = AuditorTreeValidator.validate(singleOptionTree)
        assertFalse(result.isValid, "Tek seçenekli soru düğümü geçersiz sayılmalı")
        assertTrue(result.errors.any { it.contains("option", ignoreCase = true) })
    }
}
