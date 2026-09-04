package com.hasantuncay.mobsec.maswe0002.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Vector

data class Maswe0002VulnerableState(
    val selectedVector: Maswe0002Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0002VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0002Vector) : Maswe0002VulnerableIntent
    data object Reset : Maswe0002VulnerableIntent
}

sealed interface Maswe0002VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0002VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0002VulnerableEffect
}
