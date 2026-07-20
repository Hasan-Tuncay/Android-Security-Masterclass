package com.hasantuncay.mobsec.common.viewmodel

import androidx.lifecycle.ViewModel
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Global ViewModel for managing MasterclassData.
 * Future-proofed to accept Repositories, Network Layers, and Domain Data injections.
 */
class MasterclassDataViewModel : ViewModel() {
    
    // Internal mutable state holding the global data
    private val _masterclassData = MutableStateFlow(MasterclassData())
    
    // Public immutable state exposed to the UI
    val masterclassData: StateFlow<MasterclassData> = _masterclassData.asStateFlow()

    /**
     * Future placeholder for dynamic data updates from Repositories/Network.
     */
    fun updateData(newData: MasterclassData) {
        _masterclassData.value = newData
    }
}
