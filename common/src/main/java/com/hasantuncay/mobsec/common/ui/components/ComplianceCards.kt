package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.hasantuncay.mobsec.common.models.data.compliance.GdprPiiData
import com.hasantuncay.mobsec.common.models.data.compliance.HipaaPhiData
import com.hasantuncay.mobsec.common.models.data.compliance.PciDssData

@Composable
fun GdprPiiCard(data: GdprPiiData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "GDPR - PII Data", modifier = modifier) {
        Text("Direct Identifiers", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Full Name", data.directIdentifiers.fullName)
        ReadOnlyDataField("National ID (TCKN)", data.directIdentifiers.nationalIdentificationNumber, isSensitive = true)
        ReadOnlyDataField("Email", data.directIdentifiers.emailAddress)
        ReadOnlyDataField("Phone", data.directIdentifiers.phoneNumber)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Indirect Identifiers", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("DOB", data.indirectIdentifiers.dateOfBirth)
        ReadOnlyDataField("Gender", data.indirectIdentifiers.gender)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Special Category (Sensitive)", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Health Condition", data.specialCategoryData.healthCondition)
        ReadOnlyDataField("Biometric Hash", data.specialCategoryData.biometricTemplateHash)
    }
}

@Composable
fun PciDssCard(data: PciDssData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "PCI-DSS Data", modifier = modifier) {
        Text("Cardholder Data", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("PAN", data.cardholderData.primaryAccountNumber, isSensitive = true)
        ReadOnlyDataField("Cardholder Name", data.cardholderData.cardholderName)
        ReadOnlyDataField("Expiration", data.cardholderData.expirationDate)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Sensitive Auth Data", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("CVV", data.sensitiveAuthData.cardVerificationValue, isSensitive = true)
        ReadOnlyDataField("PIN Block", data.sensitiveAuthData.pinBlock, isSensitive = true)
    }
}

@Composable
fun HipaaPhiCard(data: HipaaPhiData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "HIPAA - PHI Data", modifier = modifier) {
        Text("Health Records", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Medical Record Number", data.medicalRecordNumber)
        ReadOnlyDataField("Diagnosis Code", data.diagnosisCode)
        ReadOnlyDataField("Treatment Date", data.treatmentDate)
        ReadOnlyDataField("Attending Physician", data.attendingPhysician)
    }
}
