package com.hasantuncay.mobsec.maswe0006.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation

data class Maswe0006SecureState(
    val selectedMitigation: Maswe0006Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0006SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0006Mitigation) : Maswe0006SecureIntent
    data object Reset : Maswe0006SecureIntent
}

sealed interface Maswe0006SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0006SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0006SecureEffect
}
