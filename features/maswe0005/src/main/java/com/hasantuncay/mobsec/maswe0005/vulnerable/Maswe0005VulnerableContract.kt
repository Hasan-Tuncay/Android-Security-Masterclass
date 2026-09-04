package com.hasantuncay.mobsec.maswe0005.vulnerable

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector

data class Maswe0005VulnerableState(
    val selectedVector: Maswe0005Vector? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0005VulnerableIntent : UiIntentMarker {
    data class ExecuteVector(val vector: Maswe0005Vector) : Maswe0005VulnerableIntent
    data object Reset : Maswe0005VulnerableIntent
}

sealed interface Maswe0005VulnerableEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0005VulnerableEffect
    data class ExecutionFailed(val error: AppError) : Maswe0005VulnerableEffect
}
