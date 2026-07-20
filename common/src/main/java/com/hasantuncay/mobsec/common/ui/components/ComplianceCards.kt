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
        ReadOnlyDataField("Email", data.directIdentifiers.personalEmail)
        ReadOnlyDataField("Passport", data.directIdentifiers.passportNumber)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Indirect Identifiers", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("IPv6 Address", data.indirectIdentifiers.ipv6Address)
        ReadOnlyDataField("Advertising ID", data.indirectIdentifiers.advertisingId)
        ReadOnlyDataField("GPS Lat", data.indirectIdentifiers.exactLocation.latitude.toString())
        ReadOnlyDataField("GPS Lng", data.indirectIdentifiers.exactLocation.longitude.toString())

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Special Category (Sensitive)", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Political Affiliation", data.specialCategoryData.politicalAffiliation)
        ReadOnlyDataField("Genetic Data Hash", data.specialCategoryData.geneticDataHash)
        ReadOnlyDataField("Biometric Vector", data.specialCategoryData.biometricFacialVector)
    }
}

@Composable
fun PciDssCard(data: PciDssData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "PCI-DSS Data", modifier = modifier) {
        Text("Cardholder Data", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("PAN", data.cardholderData.primaryAccountNumber, isSensitive = true)
        ReadOnlyDataField("Cardholder Name", data.cardholderData.cardholderName)
        ReadOnlyDataField("Expiration", data.cardholderData.expirationDate)
        ReadOnlyDataField("Service Code", data.cardholderData.serviceCode)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Sensitive Auth Data", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Full Mag Stripe", data.sensitiveAuthenticationData.fullMagneticStripeData, isSensitive = true)
        ReadOnlyDataField("CVV", data.sensitiveAuthenticationData.cardVerificationCode, isSensitive = true)
        ReadOnlyDataField("PIN Block", data.sensitiveAuthenticationData.pinBlock, isSensitive = true)
    }
}

@Composable
fun HipaaPhiCard(data: HipaaPhiData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "HIPAA - PHI Data", modifier = modifier) {
        Text("Health Records", style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField("Medical Record Number", data.medicalRecordNumber)
        ReadOnlyDataField("Health Plan Beneficiary", data.healthPlanBeneficiaryNumber)
        ReadOnlyDataField("ICD-10 Code", data.icd10DiagnosisCode)
        ReadOnlyDataField("Admission Date", data.admissionDate)
        ReadOnlyDataField("HL7 Payload", data.hl7ProcedurePayload)
        ReadOnlyDataField("Face Image URI", data.fullFacePhotographicImageUri)
    }
}
