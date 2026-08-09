package com.hasantuncay.mobsec.common.data

import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MasterclassDataRepository @Inject constructor() {
    private val _masterclassData = MutableStateFlow(MasterclassData())
    val masterclassData: StateFlow<MasterclassData> = _masterclassData.asStateFlow()

    fun updateData(newData: MasterclassData) {
        _masterclassData.value = newData
    }
}
