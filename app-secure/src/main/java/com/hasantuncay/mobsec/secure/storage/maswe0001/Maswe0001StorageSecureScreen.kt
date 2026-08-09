package com.hasantuncay.mobsec.secure.storage.maswe0001

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.Maswe0001Mitigation
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001StorageSecureScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredMitigation by remember { mutableStateOf<Maswe0001Mitigation?>(null) }

    com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen(
        vectors = Maswe0001Mitigation.entries,
        onBack = onBack,
        onVectorClicked = { vector ->
            var path: String? = null
            Maswe0001SecureLogic.executeVector(
                vector = vector,
                appData = appData,
                context = context,
                onResult = { path = it }
            )
            path
        }
    ) {

        HorizontalDivider()
        
        var pqcResult by remember { mutableStateOf<String?>(null) }
        
        Button(
            onClick = {
                try {
                    val keyPair = com.hasantuncay.mobsec.secure.crypto.PqcManager.generateMlKemKeyPair()
                    val kemResult = com.hasantuncay.mobsec.secure.crypto.PqcManager.encapsulate(keyPair.public)
                    val decapsulatedSecret = com.hasantuncay.mobsec.secure.crypto.PqcManager.decapsulate(keyPair.private, kemResult.encapsulation)
                    
                    val success = kemResult.secretKey.contentEquals(decapsulatedSecret)
                    pqcResult = if (success) {
                        "✅ PQC Kyber KEM Success!\nShared Secret Match: ${kemResult.secretKey.size} bytes."
                    } else {
                        "❌ PQC Kyber Failed! Secrets do not match."
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    pqcResult = "Error: ${e.message}"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Test PQC (Kyber ML-KEM)")
        }
        
        if (pqcResult != null) {
            Text(
                text = pqcResult!!,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
