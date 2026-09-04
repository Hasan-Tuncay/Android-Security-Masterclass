package com.hasantuncay.mobsec.maswe0001.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Mitigation

data class Maswe0001SecureState(
    val selectedMitigation: Maswe0001Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0001SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0001Mitigation) : Maswe0001SecureIntent
    data object Reset : Maswe0001SecureIntent
}

sealed interface Maswe0001SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0001SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0001SecureEffect
}
