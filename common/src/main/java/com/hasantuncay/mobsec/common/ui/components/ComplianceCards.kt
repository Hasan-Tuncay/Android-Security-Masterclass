package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.data.compliance.GdprPiiData
import com.hasantuncay.mobsec.common.models.data.compliance.HipaaPhiData
import com.hasantuncay.mobsec.common.models.data.compliance.PciDssData

@Composable
fun GdprPiiCard(data: GdprPiiData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_gdpr), modifier = modifier) {
        Text(stringResource(id = R.string.subtitle_direct_identifiers), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_full_name), data.directIdentifiers.fullName)
        ReadOnlyDataField(stringResource(id = R.string.label_tckn), data.directIdentifiers.nationalIdentificationNumber, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_email), data.directIdentifiers.personalEmail)
        ReadOnlyDataField(stringResource(id = R.string.label_passport), data.directIdentifiers.passportNumber)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text(stringResource(id = R.string.subtitle_indirect_identifiers), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_ipv6), data.indirectIdentifiers.ipv6Address)
        ReadOnlyDataField(stringResource(id = R.string.label_advertising_id), data.indirectIdentifiers.advertisingId)
        ReadOnlyDataField(stringResource(id = R.string.label_gps_lat), data.indirectIdentifiers.exactLocation.latitude.toString())
        ReadOnlyDataField(stringResource(id = R.string.label_gps_lng), data.indirectIdentifiers.exactLocation.longitude.toString())

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text(stringResource(id = R.string.subtitle_special_category), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_political_affiliation), data.specialCategoryData.politicalAffiliation)
        ReadOnlyDataField(stringResource(id = R.string.label_genetic_hash), data.specialCategoryData.geneticDataHash)
        ReadOnlyDataField(stringResource(id = R.string.label_biometric_vector), data.specialCategoryData.biometricFacialVector)
    }
}

@Composable
fun PciDssCard(data: PciDssData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_pci), modifier = modifier) {
        Text(stringResource(id = R.string.subtitle_cardholder_data), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_pan), data.cardholderData.primaryAccountNumber, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_cardholder_name), data.cardholderData.cardholderName)
        ReadOnlyDataField(stringResource(id = R.string.label_expiration), data.cardholderData.expirationDate)
        ReadOnlyDataField(stringResource(id = R.string.label_service_code), data.cardholderData.serviceCode)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text(stringResource(id = R.string.subtitle_sensitive_auth_data), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_full_mag_stripe), data.sensitiveAuthenticationData.fullMagneticStripeData, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_cvv), data.sensitiveAuthenticationData.cardVerificationCode, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_pin_block), data.sensitiveAuthenticationData.pinBlock, isSensitive = true)
    }
}

@Composable
fun HipaaPhiCard(data: HipaaPhiData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_hipaa), modifier = modifier) {
        Text(stringResource(id = R.string.subtitle_health_records), style = MaterialTheme.typography.labelLarge)
        ReadOnlyDataField(stringResource(id = R.string.label_medical_record_number), data.medicalRecordNumber)
        ReadOnlyDataField(stringResource(id = R.string.label_health_plan_beneficiary), data.healthPlanBeneficiaryNumber)
        ReadOnlyDataField(stringResource(id = R.string.label_icd10_code), data.icd10DiagnosisCode)
        ReadOnlyDataField(stringResource(id = R.string.label_admission_date), data.admissionDate)
        ReadOnlyDataField(stringResource(id = R.string.label_hl7_payload), data.hl7ProcedurePayload)
        ReadOnlyDataField(stringResource(id = R.string.label_face_image_uri), data.fullFacePhotographicImageUri)
    }
}
