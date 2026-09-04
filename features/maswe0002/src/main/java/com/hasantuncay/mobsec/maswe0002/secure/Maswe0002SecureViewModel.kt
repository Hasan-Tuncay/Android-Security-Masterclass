package com.hasantuncay.mobsec.maswe0002.secure

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0002SecureViewModel @Inject constructor(
    private val repository: Maswe0002SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0002SecureState, Maswe0002SecureIntent, Maswe0002SecureEffect>(
    Maswe0002SecureState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0002SecureIntent) {
        when (intent) {
            is Maswe0002SecureIntent.ExecuteMitigation -> executeVector(intent.mitigation)
            is Maswe0002SecureIntent.Reset -> updateState {
                it.copy(selectedMitigation = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeVector(vector: Maswe0002Mitigation) {
        viewModelScope.launch {
            updateState { it.copy(selectedMitigation = vector, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeMitigation(vector, appData)
            }
            result.fold(
                onSuccess = { path ->
                    updateState { it.copy(executionState = UiState.Success(path)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Mitigation execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0002SecureEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
