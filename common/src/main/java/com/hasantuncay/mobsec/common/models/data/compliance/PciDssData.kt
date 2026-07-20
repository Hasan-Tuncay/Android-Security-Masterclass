package com.hasantuncay.mobsec.common.models.data.compliance

/**
 * PCI-DSS v4.0 (Payment Card Industry Data Security Standard) Data Model.
 * Structurally separates Cardholder Data (CHD) from Sensitive Authentication Data (SAD).
 */
data class PciDssData(
    val cardholderData: CardholderData = CardholderData(),
    val sensitiveAuthenticationData: SensitiveAuthData = SensitiveAuthData()
)

/**
 * Cardholder Data (CHD).
 * May be stored persistently if protected using strong cryptography and key management.
 */
data class CardholderData(
    /** The Primary Account Number (PAN). Must be rendered unreadable (masked/truncated) when displayed. */
    val primaryAccountNumber: String = "4532112233445566",
    /** The name of the individual to whom the card was issued. */
    val cardholderName: String = "JOHN DOE",
    /** The expiration date of the card. */
    val expirationDate: String = "12/28",
    /** A three or four-digit value in the magnetic stripe that specifies acceptance requirements. */
    val serviceCode: String = "101"
)

/**
 * Sensitive Authentication Data (SAD).
 * WARNING: Under strict PCI-DSS regulations, SAD MUST NOT be stored in non-volatile memory (At Rest)
 * after authorization, even if encrypted. It should only exist In-Memory (In-Use).
 * This model is specifically used to simulate In-Memory vulnerabilities.
 */
data class SensitiveAuthData(
    /** The full raw data payload contained on the magnetic stripe (Track 1 / Track 2). */
    val fullMagneticStripeData: String = "%B4532112233445566^DOE/JOHN^281210100000000000000000000000?.",
    /** The Card Verification Code (CVV2, CVC2, CID, CAV2). Cannot be stored persistently. */
    val cardVerificationCode: String = "123",
    /** The encrypted block containing the Personal Identification Number (PIN). */
    val pinBlock: String = "1A2B3C4D5E6F7A8B"
)
