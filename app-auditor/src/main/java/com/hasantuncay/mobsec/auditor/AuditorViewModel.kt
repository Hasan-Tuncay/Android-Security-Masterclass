package com.hasantuncay.mobsec.auditor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hasantuncay.mobsec.auditor.contract.AuditorEffect
import com.hasantuncay.mobsec.auditor.contract.AuditorIntent
import com.hasantuncay.mobsec.auditor.contract.AuditorUiState
import com.hasantuncay.mobsec.auditor.domain.AuditSessionAggregator
import com.hasantuncay.mobsec.core.auditor.data.StorageAuditorTrees
import com.hasantuncay.mobsec.core.auditor.engine.AuditorReducer
import com.hasantuncay.mobsec.core.auditor.models.AuditVerdict
import com.hasantuncay.mobsec.core.auditor.models.AuditorNode
import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.atomic.AtomicBoolean

/**
 * AuditorViewModel: Karar ağacı yürütme motoru ve navigasyon/backstack yöneticisi.
 *
 * DbC Sözleşmeleri:
 * - C1: Pure State Reducer entegrasyonu (AuditorReducer)
 * - C2: Effectful ViewModel & Navigation sözleşmesi
 * - C4: AuditSessionAggregator entegrasyonu
 */
class AuditorViewModel(
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()
) : ViewModel() {

    companion object {
        const val KEY_MASWE_ID = "maswe_id"
        const val KEY_NODE_ID = "current_node_id"
        const val KEY_BACK_STACK = "back_stack"
        const val DEFAULT_MASWE_ID = "maswe-0001"
        const val MAX_ALLOWED_DEPTH = 25
    }

    private var currentTree: AuditorTree

    var currentMasweId: String by mutableStateOf(
        savedStateHandle.get<String>(KEY_MASWE_ID) ?: DEFAULT_MASWE_ID
    )
        private set

    var currentNodeId: String by mutableStateOf("")
        private set

    private val _backStack = mutableStateListOf<String>()
    val backStack: List<String> get() = _backStack

    // Uç Durum Kalkanı: Dangling reference ve bozuk ağaç durumunda güvenli fallback
    private var fallbackNode by mutableStateOf<AuditorNode?>(null)

    // Rapid-tap / Double-click kalkanı
    private val isTransitioning = AtomicBoolean(false)

    // Oturum başlangıç zamanı (telemetri ve süre kaydı için)
    private var sessionStartTime: Long = System.currentTimeMillis()

    // LCE-O StateFlow
    private val _uiState = MutableStateFlow<AuditorUiState>(AuditorUiState.Loading)
    val uiState: StateFlow<AuditorUiState> = _uiState.asStateFlow()

    // Side Effects
    private val _effect = MutableSharedFlow<AuditorEffect>()
    val effect: SharedFlow<AuditorEffect> = _effect.asSharedFlow()

    init {
        currentTree = StorageAuditorTrees.getTree(currentMasweId) ?: StorageAuditorTrees.maswe0001
        val restoredNodeId = savedStateHandle.get<String>(KEY_NODE_ID)
        val initialNodeId = restoredNodeId ?: currentTree.startNode
        currentNodeId = initialNodeId

        savedStateHandle.get<List<String>>(KEY_BACK_STACK)?.let { restoredBackStack ->
            _backStack.clear()
            _backStack.addAll(restoredBackStack)
        }

        savedStateHandle[KEY_MASWE_ID] = currentMasweId
        savedStateHandle[KEY_NODE_ID] = currentNodeId

        updateUiStateForCurrentNode()
    }

    /**
     * MVI Intent işleyici
     */
    fun processIntent(intent: AuditorIntent) {
        when (intent) {
            is AuditorIntent.LoadTree -> loadTree(intent.masweId)
            is AuditorIntent.SelectOption -> selectOption(intent.option)
            is AuditorIntent.PopBackStack -> popBackStack()
            is AuditorIntent.ResetSession -> restart()
            is AuditorIntent.Retry -> restart()
        }
    }

    /**
     * Belirtilen MASWE kimliğine ait denetim ağacını yükler ve oturumu başlatır.
     */
    fun loadTree(masweId: String) {
        _uiState.value = AuditorUiState.Loading
        val tree = StorageAuditorTrees.getTree(masweId)
        if (tree == null || tree.nodes.isEmpty()) {
            _uiState.value = AuditorUiState.Empty
            return
        }

        currentTree = tree
        currentMasweId = masweId
        currentNodeId = tree.startNode
        _backStack.clear()
        fallbackNode = null
        sessionStartTime = System.currentTimeMillis()

        savedStateHandle[KEY_MASWE_ID] = currentMasweId
        savedStateHandle[KEY_NODE_ID] = currentNodeId
        savedStateHandle[KEY_BACK_STACK] = ArrayList(_backStack)

        updateUiStateForCurrentNode()
    }

    /**
     * Kullanıcı bir seçenek seçtiğinde tetiklenir (C2 Sözleşmesi).
     * AtomicBoolean rapid-tap kalkanı, MAX_ALLOWED_DEPTH livelock kalkanı ve
     * AuditorReducer delegasyonu içerir.
     */
    fun selectOption(option: Option) {
        if (!isTransitioning.compareAndSet(false, true)) {
            return
        }

        try {
            // 1. Rapid tap kalkanı: Zaten o hedefe geçilmişse veya tekrarlanan tıklamaysa drop et
            if (currentNodeId == option.next) {
                return
            }

            val currentNode = getCurrentNode()
            if (currentNode is QuestionNode) {
                // Seçenek mevcut sorunun seçenekleri arasında yoksa yoksay (yarış durumu engeli)
                if (currentNode.options.none { it.next == option.next }) {
                    return
                }
            } else if (currentNode is ResultNode) {
                return
            }

            // 2. Livelock Kalkanı (MAX_ALLOWED_DEPTH = 25)
            if (_backStack.size >= MAX_ALLOWED_DEPTH) {
                fallbackNode = ResultNode(status = "fail")
                _uiState.value = AuditorUiState.Error(
                    "Maksimum denetim derinliği ($MAX_ALLOWED_DEPTH) aşıldı (Livelock kalkanı).",
                    canRetry = false
                )
                return
            }

            // 3. AuditorReducer.reduce motoruna delege et (C1 Sözleşmesi)
            try {
                val transitionResult = AuditorReducer.reduce(
                    tree = currentTree,
                    currentNodeId = currentNodeId,
                    option = option,
                    visitedNodes = _backStack.toList()
                )

                _backStack.clear()
                _backStack.addAll(transitionResult.visitedNodes)
                currentNodeId = transitionResult.nextNodeId
                fallbackNode = null

                savedStateHandle[KEY_NODE_ID] = currentNodeId
                savedStateHandle[KEY_BACK_STACK] = ArrayList(_backStack)

                updateUiStateForCurrentNode()
            } catch (e: Exception) {
                // Dangling Reference ve geçiş hatası kalkanı (C2 Yanlışlanabilirlik)
                _backStack.add(currentNodeId)
                currentNodeId = option.next
                fallbackNode = ResultNode(status = "error")

                savedStateHandle[KEY_NODE_ID] = currentNodeId
                savedStateHandle[KEY_BACK_STACK] = ArrayList(_backStack)

                _uiState.value = AuditorUiState.Error(
                    "Ağaç geçiş hatası: ${e.message ?: "Hedef düğüm bulunamadı: ${option.next}"}",
                    canRetry = true
                )
            }
        } finally {
            isTransitioning.set(false)
        }
    }

    /**
     * Bir önceki soruya geri döner.
     * @return Backstack'te eleman varsa true dönüp pop eder, kök düğümdeyse false dönerek Dashboard'a çıkışı sağlar.
     */
    fun popBackStack(): Boolean {
        if (_backStack.isNotEmpty()) {
            val previousNodeId = _backStack.removeAt(_backStack.size - 1)
            currentNodeId = previousNodeId
            fallbackNode = null

            savedStateHandle[KEY_NODE_ID] = currentNodeId
            savedStateHandle[KEY_BACK_STACK] = ArrayList(_backStack)

            updateUiStateForCurrentNode()
            return true
        }
        return false
    }

    /**
     * Mevcut aktif düğümü döndürür.
     * C2 Sözleşmesi gereği asla null veya tanımsız ara durum dönemez.
     */
    fun getCurrentNode(): AuditorNode? {
        fallbackNode?.let { return it }
        val node = currentTree.nodes[currentNodeId]
        if (node == null && currentNodeId.isNotEmpty()) {
            return ResultNode(status = "error")
        }
        return node
    }

    fun restart() {
        currentNodeId = currentTree.startNode
        _backStack.clear()
        fallbackNode = null
        sessionStartTime = System.currentTimeMillis()

        savedStateHandle[KEY_NODE_ID] = currentNodeId
        savedStateHandle[KEY_BACK_STACK] = ArrayList(_backStack)

        updateUiStateForCurrentNode()
    }

    fun getTitle(): String = currentTree.title

    /**
     * Aktif düğüm durumuna göre StateFlow (AuditorUiState) ve AuditSessionAggregator'ı günceller.
     */
    private fun updateUiStateForCurrentNode() {
        if (fallbackNode != null) {
            _uiState.value = AuditorUiState.Error(
                message = "Geçersiz veya eksik düğüm: $currentNodeId",
                canRetry = true
            )
            return
        }

        val node = getCurrentNode()
        when (node) {
            is QuestionNode -> {
                _uiState.value = AuditorUiState.Question(
                    node = node,
                    breadcrumbs = _backStack.toList()
                )
            }
            is ResultNode -> {
                val verdict = parseVerdict(node.status)
                _uiState.value = AuditorUiState.Result(
                    node = node,
                    masweId = currentMasweId,
                    verdict = verdict
                )

                // C4: Terminal ResultNode'a ulaşıldığında AuditSessionAggregator'a kaydet
                AuditSessionAggregator.recordSession(
                    masweId = currentMasweId,
                    verdict = verdict,
                    durationMs = (System.currentTimeMillis() - sessionStartTime).coerceAtLeast(0L)
                )
            }
            null -> {
                _uiState.value = AuditorUiState.Empty
            }
        }
    }

    private fun parseVerdict(status: String): AuditVerdict {
        return when (status.lowercase()) {
            "pass" -> AuditVerdict.PASS
            "fail" -> AuditVerdict.FAIL
            "warning" -> AuditVerdict.WARNING
            "info" -> AuditVerdict.INFO
            else -> AuditVerdict.FAIL
        }
    }
}
