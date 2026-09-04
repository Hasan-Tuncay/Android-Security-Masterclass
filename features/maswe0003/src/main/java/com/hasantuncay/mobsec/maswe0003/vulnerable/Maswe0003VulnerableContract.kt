package com.hasantuncay.mobsec.maswe0003.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector

data class Maswe0003VulnerableState(
    val selectedVector: Maswe0003Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0003VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0003Vector) : Maswe0003VulnerableIntent
    data object Reset : Maswe0003VulnerableIntent
}

sealed interface Maswe0003VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0003VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0003VulnerableEffect
}
