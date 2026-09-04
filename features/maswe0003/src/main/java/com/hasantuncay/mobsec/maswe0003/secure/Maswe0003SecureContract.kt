package com.hasantuncay.mobsec.maswe0003.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation

data class Maswe0003SecureState(
    val selectedMitigation: Maswe0003Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0003SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0003Mitigation) : Maswe0003SecureIntent
    data object Reset : Maswe0003SecureIntent
}

sealed interface Maswe0003SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0003SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0003SecureEffect
}
