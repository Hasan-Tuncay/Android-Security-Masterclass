package com.hasantuncay.mobsec.maswe0006.secure

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0006SecureViewModel @Inject constructor(
    private val repository: Maswe0006SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0006SecureState, Maswe0006SecureIntent, Maswe0006SecureEffect>(
    Maswe0006SecureState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0006SecureIntent) {
        when (intent) {
            is Maswe0006SecureIntent.ExecuteMitigation -> executeVector(intent.mitigation)
            is Maswe0006SecureIntent.Reset -> updateState {
                it.copy(selectedMitigation = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeVector(vector: Maswe0006Mitigation) {
        viewModelScope.launch {
            updateState { it.copy(selectedMitigation = vector, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeMitigation(vector, appData)
            }
            result.fold(
                onSuccess = { resultMessage ->
                    updateState { it.copy(executionState = UiState.Success(resultMessage)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Mitigation execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0006SecureEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
