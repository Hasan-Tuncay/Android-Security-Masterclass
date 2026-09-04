package com.hasantuncay.mobsec.maswe0007.vulnerable

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0007VulnerableViewModel @Inject constructor(
    private val repository: Maswe0007VulnerableRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0007VulnerableState, Maswe0007VulnerableIntent, Maswe0007VulnerableEffect>(
    Maswe0007VulnerableState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0007VulnerableIntent) {
        when (intent) {
            is Maswe0007VulnerableIntent.ExecuteVector -> executeVector(intent.vector)
            is Maswe0007VulnerableIntent.Reset -> updateState {
                it.copy(selectedVector = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeVector(vector: Maswe0007Vector) {
        viewModelScope.launch {
            updateState { it.copy(selectedVector = vector, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeVector(vector, appData)
            }
            result.fold(
                onSuccess = { resultMessage ->
                    updateState { it.copy(executionState = UiState.Success(resultMessage)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Vector execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0007VulnerableEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
