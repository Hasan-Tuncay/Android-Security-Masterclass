package com.hasantuncay.mobsec.storage.maswe0001

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.storage.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001StorageVulnerableScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    val context = LocalContext.current

    BaseVulnerableScreen(
        meta = Maswe0001Vector.meta,
        vectors = Maswe0001Vector.entries,
        onBack = onBack,
        onVectorClicked = { vector ->
            var path: String? = null
            Maswe0001VulnerableLogic.executeVector(
                vector = vector,
                appData = appData,
                context = context,
                onResult = { path = it }
            )
            path
        }
    )
}
