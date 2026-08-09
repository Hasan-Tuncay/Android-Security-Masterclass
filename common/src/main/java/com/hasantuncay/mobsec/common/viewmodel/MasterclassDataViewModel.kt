package com.hasantuncay.mobsec.common.viewmodel

import androidx.lifecycle.ViewModel
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MasterclassDataViewModel @Inject constructor(
    private val repository: MasterclassDataRepository
) : ViewModel() {
    val masterclassData = repository.masterclassData
    fun updateData(newData: com.hasantuncay.mobsec.common.models.data.MasterclassData) {
        repository.updateData(newData)
    }
}
