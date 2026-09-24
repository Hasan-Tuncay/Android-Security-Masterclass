package com.hasantuncay.mobsec.core.auditor.validator

import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode

data class ValidationResult(
    val isValid: Boolean,
    val errors: List<String> = emptyList()
)

object AuditorTreeValidator {

    /**
     * Tree Structural Invariant & Catalog Integrity Doğrulayıcısı (C3 Sözleşmesi).
     *
     * Kurallar:
     * 1. startNode varlığı: startNode ağaç düğümleri arasında mevcut olmalıdır.
     * 2. QuestionNode seçenek kuralı: Her QuestionNode en az 2 seçeneğe sahip olmalıdır.
     * 3. Dangling Reference kuralı: Tüm seçeneklerin hedef (next) düğümleri ağaçta mevcut olmalıdır.
     * 4. Çevrimsizlik (Acyclicity): Karar ağacı yönlendirilmiş çevrimsiz bir çizge (DAG) olmalı, döngü içermemelidir.
     * 5. Ulaşılabilirlik (Reachability): Kök düğümden (startNode) tüm düğümlere erişilebilmelidir (yetim/ölü düğüm olmamalıdır).
     *
     * @param tree Doğrulanacak AuditorTree nesnesi
     * @return ValidationResult (isValid ve tespit edilen hataların listesi)
     */
    fun validate(tree: AuditorTree): ValidationResult {
        val errors = mutableListOf<String>()

        // 1. Root / startNode doğrulaması
        if (!tree.nodes.containsKey(tree.startNode)) {
            errors.add("Invalid startNode: '${tree.startNode}' does not exist in nodes map")
        }

        // 2. Dangling referans ve seçenek sayısı kontrolleri
        var hasDangling = false
        for ((nodeId, node) in tree.nodes) {
            when (node) {
                is QuestionNode -> {
                    if (node.options.size < 2) {
                        errors.add("Question node '$nodeId' has insufficient options: expected at least 2, found ${node.options.size}")
                    }
                    for (option in node.options) {
                        if (!tree.nodes.containsKey(option.next)) {
                            hasDangling = true
                            errors.add("Dangling reference: option '${option.text}' in node '$nodeId' points to non_existent_node_id '${option.next}'")
                        }
                    }
                }
                is ResultNode -> {
                    // Terminal düğüm kontrolleri
                    val validStatuses = setOf("pass", "fail", "warning", "info")
                    if (node.status.lowercase() !in validStatuses) {
                        errors.add("Invalid result status '${node.status}' in node '$nodeId'")
                    }
                }
            }
        }

        // 3. Döngü (Cycle) Tespiti: Kahn Algoritması (In-degree hesaplama ve topolojik sıralama |L| == |V|)
        val hasCycle = detectCycleKahn(tree)
        if (hasCycle) {
            errors.add("Cycle detected in decision tree: graph must be a strict DAG (Kahn topological sort failed)")
        }

        // 4. Ulaşılabilirlik (Reachability / Orphan) Kontrolü
        // startNode mevcutsa traversal yapılır
        if (tree.nodes.containsKey(tree.startNode)) {
            val reachable = mutableSetOf<String>()
            val queue = ArrayDeque<String>()
            queue.add(tree.startNode)
            reachable.add(tree.startNode)

            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                val node = tree.nodes[current]
                if (node is QuestionNode) {
                    for (opt in node.options) {
                        if (tree.nodes.containsKey(opt.next) && reachable.add(opt.next)) {
                            queue.add(opt.next)
                        }
                    }
                }
            }

            for (nodeId in tree.nodes.keys) {
                if (nodeId !in reachable) {
                    errors.add("Unreachable / orphan node detected: node '$nodeId' cannot be reached from startNode '${tree.startNode}'")
                }
            }
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }

    /**
     * Kahn Algoritması ile graf genelinde yönlendirilmiş çevrim (cycle) tespiti.
     * 1. Tüm düğümlerin in-degree (gelen kenar) sayıları hesaplanır.
     * 2. In-degree = 0 olan düğümler kuyruğa alınır.
     * 3. Kuyruktan çıkan her düğüm için sıralı liste boyutu artırılır ve komşuların in-degree'si 1 azaltılır.
     * 4. Topolojik olarak işlenen düğüm sayısı toplam düğüm sayısından küçükse (|L| != |V|), döngü vardır.
     */
    fun detectCycleKahn(tree: AuditorTree): Boolean {
        if (tree.nodes.isEmpty()) return false

        val inDegree = mutableMapOf<String, Int>()
        val adj = mutableMapOf<String, MutableList<String>>()

        for (nodeId in tree.nodes.keys) {
            inDegree[nodeId] = 0
            adj[nodeId] = mutableListOf()
        }

        for ((nodeId, node) in tree.nodes) {
            if (node is QuestionNode) {
                for (option in node.options) {
                    val nextId = option.next
                    if (tree.nodes.containsKey(nextId)) {
                        adj[nodeId]?.add(nextId)
                        inDegree[nextId] = (inDegree[nextId] ?: 0) + 1
                    }
                }
            }
        }

        val queue = ArrayDeque<String>()
        for ((nodeId, degree) in inDegree) {
            if (degree == 0) {
                queue.add(nodeId)
            }
        }

        var visitedCount = 0
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            visitedCount++
            val neighbors = adj[current] ?: emptyList()
            for (neighbor in neighbors) {
                val updatedDegree = (inDegree[neighbor] ?: 0) - 1
                inDegree[neighbor] = updatedDegree
                if (updatedDegree == 0) {
                    queue.add(neighbor)
                }
            }
        }

        return visitedCount != tree.nodes.size
    }

    fun detectCycle(tree: AuditorTree): Boolean = detectCycleKahn(tree)
}
