package com.hasantuncay.mobsec.maswe0007.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector

data class Maswe0007VulnerableState(
    val selectedVector: Maswe0007Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0007VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0007Vector) : Maswe0007VulnerableIntent
    data object Reset : Maswe0007VulnerableIntent
}

sealed interface Maswe0007VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0007VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0007VulnerableEffect
}
