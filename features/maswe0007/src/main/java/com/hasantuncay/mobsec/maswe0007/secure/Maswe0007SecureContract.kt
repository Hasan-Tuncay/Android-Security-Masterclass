package com.hasantuncay.mobsec.maswe0007.secure

import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.UiEffectMarker
import com.hasantuncay.mobsec.common.architecture.UiIntentMarker
import com.hasantuncay.mobsec.common.architecture.UiStateMarker
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Mitigation

data class Maswe0007SecureState(
    val selectedMitigation: Maswe0007Mitigation? = null,
    val executionState: UiState<String?> = UiState.Idle
) : UiStateMarker

sealed interface Maswe0007SecureIntent : UiIntentMarker {
    data class ExecuteMitigation(val mitigation: Maswe0007Mitigation) : Maswe0007SecureIntent
    data object Reset : Maswe0007SecureIntent
}

sealed interface Maswe0007SecureEffect : UiEffectMarker {
    data class ShowToast(val message: String) : Maswe0007SecureEffect
    data class ExecutionFailed(val error: AppError) : Maswe0007SecureEffect
}
