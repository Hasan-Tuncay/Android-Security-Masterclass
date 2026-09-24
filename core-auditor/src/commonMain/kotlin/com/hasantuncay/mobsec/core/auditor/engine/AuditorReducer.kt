package com.hasantuncay.mobsec.core.auditor.engine

import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode

data class TransitionResult(
    val nextNodeId: String,
    val visitedNodes: List<String>
)

object AuditorReducer {

    /**
     * Pure State Reducer & DAG Traversal Function (C1 Sözleşmesi).
     *
     * @param tree İncelenen karar ağacı
     * @param currentNodeId Mevcut soru düğüm kimliği
     * @param option Seçilen seçenek
     * @param visitedNodes Şu ana kadar ziyaret edilen düğüm kimlikleri listesi
     * @return Yeni durum geçiş sonucu (nextNodeId ve güncellenmiş visitedNodes)
     * @throws IllegalStateException Eğer mevcut düğüm QuestionNode değilse veya Strict DAG döngü ihlali varsa
     * @throws IllegalArgumentException Eğer seçilen hedef düğüm ağaçta yoksa (dangling reference) veya geçersizse
     */
    fun reduce(
        tree: AuditorTree,
        currentNodeId: String,
        option: Option,
        visitedNodes: List<String> = emptyList()
    ): TransitionResult {
        // 1. Mevcut düğümün varlığı kontrol edilir
        val currentNode = tree.nodes[currentNodeId]
            ?: throw IllegalArgumentException("Mevcut düğüm bulunamadı: $currentNodeId")

        // 2. Yalnızca QuestionNode üzerinden seçenek seçilebilir (C1 Yanlışlanabilirlik)
        if (currentNode !is QuestionNode) {
            throw IllegalStateException("Yalnızca QuestionNode üzerinden seçenek seçilebilir. Mevcut düğüm tipi: ${currentNode::class.simpleName}")
        }

        // 3. Seçeneğin mevcut düğüme ait olduğu teyit edilir
        require(currentNode.options.any { it.next == option.next }) {
            "Seçenek mevcut düğümün seçenekleri arasında bulunmuyor: ${option.text} -> ${option.next}"
        }

        val nextId = option.next

        // 4. Dangling Reference Kalkanı: Hedef düğümün ağaçta varlığı kontrol edilir
        if (!tree.nodes.containsKey(nextId)) {
            throw IllegalArgumentException("Dangling reference tespit edildi: Hedef düğüm ağaçta mevcut değil: $nextId")
        }

        // 5. Strict DAG Değişmezi: Asla daha önce ziyaret edilen düğüme geri dönülemez (Döngü kalkanı)
        if (visitedNodes.contains(nextId)) {
            throw IllegalStateException("Strict DAG döngü ihlali: Ziyaret edilmiş düğüme geri dönülemez: $nextId")
        }

        return TransitionResult(
            nextNodeId = nextId,
            visitedNodes = visitedNodes + currentNodeId
        )
    }
}
