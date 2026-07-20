package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasantuncay.mobsec.common.models.data.classification.SensitivityClassificationData

@Composable
fun SensitivityClassificationCard(data: SensitivityClassificationData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Data Classification", modifier = modifier) {
        ReadOnlyDataField("Public", data.publicData)
        ReadOnlyDataField("Internal", data.internalData)
        ReadOnlyDataField("Confidential", data.confidentialData)
        ReadOnlyDataField("Restricted", data.restrictedData, isSensitive = true)
    }
}
