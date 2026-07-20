package com.hasantuncay.mobsec.common.models.data.classification

/**
 * Data Sensitivity Classification Model (ISO/IEC 27001 ISMS / FIPS 199).
 * Categorizes information based on the potential impact to the organization if the data
 * is disclosed, altered, or destroyed.
 */
data class SensitivityClassificationData(
    /** Public Information. Disclosure is not harmful. */
    val publicInformation: String = "https://company.com/brochures/q3-marketing.pdf",
    /** Internal Information. Disclosure may cause minor embarrassment or operational friction. */
    val internalInformation: String = "Human Resources 2026 Leave Policy Regulation v2.1",
    /** Confidential Information. Disclosure causes significant damage to the business (e.g., source code). */
    val confidentialInformation: String = "github.com/company-internal/core-banking-backend.git",
    /** Restricted Information. The highest level of sensitivity. Disclosure leads to catastrophic breach. */
    val restrictedInformation: String = "Root Certificate Authority (CA) Private Key / Admin DB Credentials"
)
