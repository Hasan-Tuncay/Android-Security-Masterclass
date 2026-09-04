package com.hasantuncay.mobsec.maswe0003.vulnerable

import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.architecture.AppError
import com.hasantuncay.mobsec.common.architecture.MviViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0003VulnerableViewModel @Inject constructor(
    private val repository: Maswe0003VulnerableRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : MviViewModel<Maswe0003VulnerableState, Maswe0003VulnerableIntent, Maswe0003VulnerableEffect>(
    Maswe0003VulnerableState()
) {

    val legacyUiState: StateFlow<UiState<String?>> = uiState
        .map { it.executionState }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState.Idle)

    override fun processIntent(intent: Maswe0003VulnerableIntent) {
        when (intent) {
            is Maswe0003VulnerableIntent.ExecuteVector -> executeVector(intent.vector)
            is Maswe0003VulnerableIntent.Reset -> updateState {
                it.copy(selectedVector = null, executionState = UiState.Idle)
            }
        }
    }

    fun executeVector(vector: Maswe0003Vector) {
        viewModelScope.launch {
            updateState { it.copy(selectedVector = vector, executionState = UiState.Loading) }
            val result = runSafeCatching {
                val appData = masterclassDataRepository.masterclassData.value
                repository.executeVector(vector, appData)
            }
            result.fold(
                onSuccess = { path ->
                    updateState { it.copy(executionState = UiState.Success(path)) }
                },
                onFailure = { throwable ->
                    val appError = AppError.ExecutionError(throwable.message ?: "Vector execution failed")
                    updateState { it.copy(executionState = UiState.Error(appError.message)) }
                    sendEffect { Maswe0003VulnerableEffect.ExecutionFailed(appError) }
                }
            )
        }
    }
}
