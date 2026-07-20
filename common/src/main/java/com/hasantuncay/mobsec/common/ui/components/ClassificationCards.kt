package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.data.classification.SensitivityClassificationData

@Composable
fun SensitivityClassificationCard(data: SensitivityClassificationData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_classification), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_public), data.publicInformation)
        ReadOnlyDataField(stringResource(id = R.string.label_internal), data.internalInformation)
        ReadOnlyDataField(stringResource(id = R.string.label_confidential), data.confidentialInformation)
        ReadOnlyDataField(stringResource(id = R.string.label_restricted), data.restrictedInformation, isSensitive = true)
    }
}
