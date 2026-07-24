package com.hasantuncay.mobsec.common.models.data.compliance

/**
 * GDPR (General Data Protection Regulation) & KVKK Data Model.
 * Represents data classified under Article 4 (Personal Data) and Article 9 (Special Category Data).
 *
 * This academic structure differentiates between data that directly identifies a user
 * versus data that requires aggregation to identify a user.
 */
data class GdprPiiData(
    val directIdentifiers: DirectIdentifiers = DirectIdentifiers(),
    val indirectIdentifiers: IndirectIdentifiers = IndirectIdentifiers(),
    val specialCategoryData: SpecialCategoryData = SpecialCategoryData()
)

/**
 * Data points that can explicitly identify a single individual without cross-referencing.
 */
data class DirectIdentifiers(
    /** National Identification Number (e.g., SSN, TCKN). Wrapped in ToMask for field-level security. */
    val nationalIdentificationNumber: ToMask = ToMask("10987654321".toCharArray()),
    /** Government-issued passport number. */
    val passportNumber: String = "U12345678",
    /** The full legal name of the data subject. */
    val fullName: String = "John Doe",
    /** Personal contact email address. Wrapped in ToMask to demonstrate field-level masking. */
    val personalEmail: ToMask = ToMask("john.doe@personal.domain.com".toCharArray())
) {
    override fun toString() = "[REDACTED_GDPR_DIRECT_IDENTIFIERS]"
}

/**
 * Data points that require correlation with other datasets to identify a specific individual.
 */
data class IndirectIdentifiers(
    /** IPv6 Address. Considered PII under GDPR as it can be traced to a subscriber. */
    val ipv6Address: String = "2001:0db8:85a3:0000:0000:8a2e:0370:7334",
    /** Mobile Advertising ID (GAID/IDFA). Used for tracking across applications. */
    val advertisingId: String = "38400000-8cf0-11bd-b23e-10b96e40000d",
    /** Highly precise geolocation coordinates. */
    val exactLocation: GeoLocation = GeoLocation(latitude = 39.92077, longitude = 32.85411)
) {
    override fun toString() = "[REDACTED_GDPR_INDIRECT_IDENTIFIERS]"
}

/**
 * Special categories of personal data (Article 9 GDPR).
 * Processing this data is generally prohibited unless explicit, freely given consent is obtained.
 */
data class SpecialCategoryData(
    /** Political opinions or affiliations. */
    val politicalAffiliation: String = "Independent",
    /** Cryptographic hash of raw genetic sequencing data. */
    val geneticDataHash: String = "SHA3-512:a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
    /** Biometric vector representation (e.g., Facial recognition embeddings). */
    val biometricFacialVector: String = "[0.12, -0.45, 0.88, ..., 0.04]"
)

/**
 * Standard spatial coordinate representation.
 */
data class GeoLocation(val latitude: Double, val longitude: Double)
