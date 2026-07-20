package com.hasantuncay.mobsec.storage.maswe0001

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.Maswe0001Vector

import com.hasantuncay.mobsec.common.models.data.LocalMasterclassData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001LogVulnerableScreen(onBack: () -> Unit) {
    val appData = LocalMasterclassData.current
    val username = appData.gdprPii.directIdentifiers.fullName
    val creditCard = appData.pciDss.cardholderData.primaryAccountNumber
    
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.maswe_0001_vuln_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                stringResource(id = R.string.maswe_0001_vuln_desc),
                style = MaterialTheme.typography.bodyMedium
            )

            OutlinedTextField(
                value = username,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.maswe_0001_username)) },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = creditCard,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.maswe_0001_credit_card)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text(stringResource(id = R.string.maswe_0001_vuln_vectors_title), fontWeight = FontWeight.Bold)

            Maswe0001Vector.entries.forEach { vector ->
                VectorButton(
                    title = stringResource(id = vector.titleVulnRes),
                    icon = vector.icon,
                    onClick = {
                        Maswe0001VulnerableLogic.executeVector(vector, username, creditCard, context)
                    }
                )
            }
        }
    }
}

@Composable
fun VectorButton(title: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title)
        }
    }
}
