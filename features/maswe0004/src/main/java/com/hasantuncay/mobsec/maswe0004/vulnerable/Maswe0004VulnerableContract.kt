package com.hasantuncay.mobsec.maswe0004.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector

data class Maswe0004VulnerableState(
    val selectedVector: Maswe0004Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0004VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0004Vector) : Maswe0004VulnerableIntent
    data object Reset : Maswe0004VulnerableIntent
}

sealed interface Maswe0004VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0004VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0004VulnerableEffect
}
