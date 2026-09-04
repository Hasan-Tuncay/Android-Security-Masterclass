package com.hasantuncay.mobsec.maswe0005.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Mitigation

data class Maswe0005SecureState(
    val selectedMitigation: Maswe0005Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0005SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0005Mitigation) : Maswe0005SecureIntent
    data object Reset : Maswe0005SecureIntent
}

sealed interface Maswe0005SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0005SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0005SecureEffect
}
