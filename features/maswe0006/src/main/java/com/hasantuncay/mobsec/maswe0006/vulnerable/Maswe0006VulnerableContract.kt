package com.hasantuncay.mobsec.maswe0006.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Vector

data class Maswe0006VulnerableState(
    val selectedVector: Maswe0006Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0006VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0006Vector) : Maswe0006VulnerableIntent
    data object Reset : Maswe0006VulnerableIntent
}

sealed interface Maswe0006VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0006VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0006VulnerableEffect
}
