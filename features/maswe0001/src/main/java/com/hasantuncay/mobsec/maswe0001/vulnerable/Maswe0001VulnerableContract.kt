package com.hasantuncay.mobsec.maswe0001.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Vector

data class Maswe0001VulnerableState(
    val selectedVector: Maswe0001Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0001VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0001Vector) : Maswe0001VulnerableIntent
    data object Reset : Maswe0001VulnerableIntent
}

sealed interface Maswe0001VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0001VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0001VulnerableEffect
}
