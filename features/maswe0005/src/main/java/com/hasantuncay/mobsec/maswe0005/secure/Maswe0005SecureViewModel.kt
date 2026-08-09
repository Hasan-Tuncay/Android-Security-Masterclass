package com.hasantuncay.mobsec.maswe0005.secure

import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Mitigation
import com.hasantuncay.mobsec.maswe0005.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Maswe0005SecureViewModel @Inject constructor(
    private val repository: Maswe0005SecureRepository,
    private val masterclassDataRepository: MasterclassDataRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String?>>(UiState.Idle)
    val uiState: StateFlow<UiState<String?>> = _uiState.asStateFlow()

    fun executeVector(vector: Maswe0005Mitigation) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val appData = masterclassDataRepository.masterclassData.value
                val result = repository.executeVector(vector, appData)
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
