package com.hasantuncay.mobsec.common.models.data.threat

/**
 * System Vector Data Model.
 * Represents infrastructure, backend, and cryptographic materials required for the app to function.
 */
data class SystemData(
    /** A 256-bit AES master key used for symmetric encryption. Extremely critical. */
    val masterCryptoKeyAesGcm: String = "0x8F432B9A1C5E7D8F9A0B1C2D3E4F5A6B",
    /** A vulnerable Initialization Vector consisting only of zeros. Never hardcode IVs in production! */
    val staticInitializationVector: String = "0x00000000000000000000000000000000",
    /** A cryptographic salt used for key derivation functions (e.g., PBKDF2, Argon2). */
    val cryptographicSalt: String = "S0m3R@nd0mS@ltV@lu3!",
    /** The alias used to retrieve the master key from the hardware-backed Android Keystore. */
    val androidKeystoreAlias: String = "com.company.app.MASTER_KEY",
    /** An RSA Private Key in PEM format. Should never be stored on the client device. */
    val rsaPrivateKeyPem: String = "-----BEGIN RSA PRIVATE KEY-----\nMIIEowIBAA...\n-----END RSA PRIVATE KEY-----",
    /** The internal, non-public GraphQL endpoint used by the application backend. */
    val backendGraphqlEndpoint: String = "https://api.internal.company.com/graphql/v2"
)
