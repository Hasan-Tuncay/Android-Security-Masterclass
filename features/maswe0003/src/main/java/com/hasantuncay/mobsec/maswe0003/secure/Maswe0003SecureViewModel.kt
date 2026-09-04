package com.hasantuncay.mobsec.maswe0003.secure

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0003SecureViewModel @Inject constructor(
    private val repository: Maswe0003SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0003SecureState, Maswe0003SecureIntent, Maswe0003SecureEffect>(
    Maswe0003SecureState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0003SecureIntent) {
        when (intent) {
            is Maswe0003SecureIntent.ExecuteMitigation -> executeMitigation(intent.mitigation)
            is Maswe0003SecureIntent.Reset -> updateState {
                it.copy(selectedMitigation = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeMitigation(mitigation: Maswe0003Mitigation) {
        viewModelScope.launch {
            updateState { it.copy(selectedMitigation = mitigation, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeMitigation(mitigation, appData)
            }
            result.fold(
                onSuccess = { path ->
                    updateState { it.copy(executionState = UiState.Success(path)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Mitigation execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0003SecureEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
