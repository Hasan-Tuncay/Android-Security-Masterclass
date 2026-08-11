package com.hasantuncay.mobsec.maswe0003.secure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0003SecureViewModel @Inject constructor(
    private val repository: Maswe0003SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String?>>(UiState.Idle)
    val uiState: StateFlow<UiState<String?>> = _uiState.asStateFlow()

    fun executeMitigation(mitigation: Maswe0003Mitigation) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val appData = masterclassDataRepository.masterclassData.value
                val result = repository.executeMitigation(mitigation, appData)
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}
