package com.hasantuncay.mobsec.auditor.contract

import com.hasantuncay.mobsec.core.auditor.models.AuditVerdict
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode

/**
 * AuditorContract: app-auditor MVI Durum Makinesi Sözleşmesi.
 * LCE-O (Loading-Content-Empty-Error-Offline) mimarisini uygular.
 */
sealed interface AuditorUiState {
    data object Loading : AuditorUiState
    data class Question(val node: QuestionNode, val breadcrumbs: List<String>) : AuditorUiState
    data class Result(val node: ResultNode, val masweId: String, val verdict: AuditVerdict) : AuditorUiState
    data object Empty : AuditorUiState
    data class Error(val message: String, val canRetry: Boolean = true) : AuditorUiState
    data object Offline : AuditorUiState
}

/**
 * Kullanıcı ve sistem tarafından tetiklenen niyetler (Intent).
 */
sealed interface AuditorIntent {
    data class LoadTree(val masweId: String) : AuditorIntent
    data class SelectOption(val option: Option) : AuditorIntent
    data object PopBackStack : AuditorIntent
    data object ResetSession : AuditorIntent
    data object Retry : AuditorIntent
}

/**
 * Tek seferlik yan etkiler (Side Effect).
 */
sealed interface AuditorEffect {
    data object NavigateBack : AuditorEffect
    data class ShowToast(val message: String) : AuditorEffect
    data class SessionCompleted(val masweId: String, val verdict: AuditVerdict) : AuditorEffect
}
