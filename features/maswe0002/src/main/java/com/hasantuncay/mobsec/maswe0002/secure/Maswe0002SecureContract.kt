package com.hasantuncay.mobsec.maswe0002.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation

data class Maswe0002SecureState(
    val selectedMitigation: Maswe0002Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0002SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0002Mitigation) : Maswe0002SecureIntent
    data object Reset : Maswe0002SecureIntent
}

sealed interface Maswe0002SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0002SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0002SecureEffect
}
