package com.hasantuncay.mobsec.maswe0004.secure

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0004SecureViewModel @Inject constructor(
    private val repository: Maswe0004SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0004SecureState, Maswe0004SecureIntent, Maswe0004SecureEffect>(
    Maswe0004SecureState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0004SecureIntent) {
        when (intent) {
            is Maswe0004SecureIntent.ExecuteMitigation -> executeMitigation(intent.mitigation)
            is Maswe0004SecureIntent.Reset -> updateState {
                it.copy(selectedMitigation = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeMitigation(mitigation: Maswe0004Mitigation) {
        viewModelScope.launch {
            updateState { it.copy(selectedMitigation = mitigation, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeMitigation(mitigation, appData)
            }
            result.fold(
                onSuccess = { message ->
                    updateState { it.copy(executionState = UiState.Success(message)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Mitigation execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0004SecureEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
