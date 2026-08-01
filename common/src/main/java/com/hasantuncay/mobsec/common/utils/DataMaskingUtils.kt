package com.hasantuncay.mobsec.common.utils

import java.security.MessageDigest
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

/**
 * 🛡️ DataMaskingUtils
 *
 * A centralized utility object to handle Data Masking, Sanitization, and Cryptographic Hashing.
 * Adheres to the DRY (Don't Repeat Yourself) principle by providing reusable security functions
 * across all MASWE modules.
 */
object DataMaskingUtils {

    /**
     * Masks an email address to protect PII.
     * Example: "ahmet@gmail.com" -> "a***t@gmail.com"
     */
    fun maskEmail(email: String): String {
        if (email.isBlank() || !email.contains("@")) return "MASKED"
        return email.replace(Regex("(^[^@]{1})[^@]+([^@]{1}@[^@]+$)"), "$1***$2")
    }

    /**
     * Masks a Primary Account Number (PAN) according to PCI-DSS standards.
     * Keeps the first 6 (BIN) and last 4 digits visible, masking the rest.
     * Example: "1234567812345678" -> "123456******5678"
     */
    fun maskPan(pan: String): String {
        return if (pan.length > 10) {
            "${pan.take(6)}******${pan.takeLast(4)}"
        } else {
            "MASKED"
        }
    }

    /**
     * Generates a one-way cryptographic SHA-256 hash.
     * Suitable for high-entropy data. For low-entropy data (like PII), use KDF instead.
     */
    fun hashSha256(input: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-256")
            val hashBytes = md.digest(input.toByteArray())
            hashBytes.joinToString("") { "%02x".format(it) }
        } catch (e: Exception) {
            "HASH_ERROR"
        }
    }

    /**
     * Generates a PBKDF2 Hash (Key Derivation Function).
     * Replaces weak single-pass SHA-256 to protect low-entropy PII against brute-force attacks.
     *
     * @param input The sensitive data to hash (as CharArray to allow memory scrubbing).
     * @param salt A unique salt (e.g., SSAID or random bytes).
     * @param iterations Computational cost (default: 10,000).
     */
    fun generatePbkdf2Hash(input: CharArray, salt: String, iterations: Int = 10000): String {
        return try {
            val keyLength = 256 // Output length in bits
            val spec = PBEKeySpec(
                input,
                salt.toByteArray(Charsets.UTF_8),
                iterations,
                keyLength
            )
            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val hashBytes = factory.generateSecret(spec).encoded
            hashBytes.joinToString("") { "%02x".format(it) }
        } catch (e: Exception) {
            "KDF_ERROR"
        }
    }
}
