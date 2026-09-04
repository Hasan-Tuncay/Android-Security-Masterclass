package com.hasantuncay.mobsec.maswe0004.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation

data class Maswe0004SecureState(
    val selectedMitigation: Maswe0004Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0004SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0004Mitigation) : Maswe0004SecureIntent
    data object Reset : Maswe0004SecureIntent
}

sealed interface Maswe0004SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0004SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0004SecureEffect
}
