package com.hasantuncay.mobsec.maswe0007.vulnerable

import android.content.Context
import android.util.Base64
import android.util.Log
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.KeyPairGenerator
import java.security.Signature
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.experimental.xor

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0007 (Improper Encryption)
 *
 * TECHNICAL OVERVIEW:
 * Violates OWASP MASVS-CRYPTO-1 and MASTG-TEST-0019.
 * CWE: CWE-327 (Broken Crypto), CWE-326 (Inadequate Strength), CWE-329 (Predictable IV), CWE-323 (Key Reuse).
 *
 * VULNERABILITY VECTORS:
 * 1. BROKEN ALGORITHM: DES with 56-bit effective key.
 * 2. REUSED IV: Static/zero IV in AES-CBC mode leaking plaintext differences.
 * 3. RISKY PADDING: Unauthenticated AES-CBC with PKCS#5/7 padding susceptible to padding oracle attacks.
 * 4. ECB MODE: Deterministic block encryption revealing structural data patterns.
 * 5. INSUFFICIENT KEY LENGTH: 56-bit or 64-bit weak key sizes.
 * 6. KEY REUSE: Cross-protocol RSA key reuse for both confidentiality and non-repudiation.
 * 7. NON-CRYPTO OBFUSCATION: Trivial XOR/Base64 masking masquerading as encryption.
 */
@Singleton
class Maswe0007VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun executeVector(
        vector: Maswe0007Vector,
        appData: MasterclassData
    ): String? = withContext(Dispatchers.IO) {
        when (vector) {
            Maswe0007Vector.BROKEN_ALGORITHM -> {
                // ❌ Vector 1: Broken Legacy Algorithm (DES - 56 bit)
                val desKeySpec = DESKeySpec("insecure".toByteArray(Charsets.UTF_8))
                val keyFactory = SecretKeyFactory.getInstance("DES")
                val desKey = keyFactory.generateSecret(desKeySpec)
                val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, desKey)
                val cipherBytes = cipher.doFinal(appData.userContext.plainTextPasswordInHeap.toByteArray(Charsets.UTF_8))
                val base64Output = Base64.encodeToString(cipherBytes, Base64.NO_WRAP)
                Log.e("MASWE_0007", "Vector 1: Encrypted with obsolete DES: $base64Output")
                "EXPOSED (DES 56-bit): $base64Output (Brute-forceable in < 24h via modern cloud FPGA)"
            }

            Maswe0007Vector.REUSED_IV -> {
                // ❌ Vector 2: Hardcoded Static All-Zeros IV in AES-CBC
                val key = SecretKeySpec("1234567890123456".toByteArray(Charsets.UTF_8), "AES")
                val staticZeroIv = IvParameterSpec(ByteArray(16)) // 0x00 * 16
                val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, key, staticZeroIv)
                val cipherBytes = cipher.doFinal("CONFIDENTIAL_RECORD_1".toByteArray(Charsets.UTF_8))
                val hexCipher = cipherBytes.joinToString("") { "%02x".format(it) }
                Log.e("MASWE_0007", "Vector 2: AES-CBC encrypted with hardcoded zero IV: $hexCipher")
                "EXPOSED (STATIC ZERO IV): $hexCipher (Repeating IV leaks XOR of plaintexts across sessions)"
            }

            Maswe0007Vector.RISKY_PADDING -> {
                // ❌ Vector 3: Unauthenticated AES-CBC Padding Oracle surface
                val key = SecretKeySpec("FixedSecretKey12".toByteArray(Charsets.UTF_8), "AES")
                val iv = IvParameterSpec(ByteArray(16) { 0x01 })
                val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, key, iv)
                val cipherBytes = cipher.doFinal(appData.networkSession.oAuth2BearerToken.take(32).toByteArray(Charsets.UTF_8))
                val b64 = Base64.encodeToString(cipherBytes, Base64.NO_WRAP)
                Log.e("MASWE_0007", "Vector 3: AES-CBC PKCS5 without MAC: $b64")
                "VULNERABLE (CBC PADDING ORACLE): $b64 (Observable padding errors allow bit-by-bit recovery)"
            }

            Maswe0007Vector.ECB_MODE -> {
                // ❌ Vector 4: Electronic Codebook (ECB) Mode
                val key = SecretKeySpec("16ByteKeyForECB!".toByteArray(Charsets.UTF_8), "AES")
                val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, key)
                // Two identical 16-byte blocks
                val repeatingPlaintext = "BLOCK_OF_16_BYTE" + "BLOCK_OF_16_BYTE"
                val cipherBytes = cipher.doFinal(repeatingPlaintext.toByteArray(Charsets.UTF_8))
                val block1Hex = cipherBytes.sliceArray(0 until 16).joinToString("") { "%02x".format(it) }
                val block2Hex = cipherBytes.sliceArray(16 until 32).joinToString("") { "%02x".format(it) }
                Log.e("MASWE_0007", "Vector 4: ECB Pattern Leak -> B1: $block1Hex == B2: $block2Hex")
                "EXPOSED (ECB PENGUIN ATTACK): Block1 ($block1Hex) == Block2 ($block2Hex). Data patterns visible!"
            }

            Maswe0007Vector.INSUFFICIENT_KEY_LENGTH -> {
                // ❌ Vector 5: Insufficient Key Length (64-bit DES key)
                val weakKey = SecretKeySpec(ByteArray(8) { 0x42 }, "DES")
                val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, weakKey)
                val cipherBytes = cipher.doFinal("WeakKeyPayload".toByteArray(Charsets.UTF_8))
                val hex = cipherBytes.joinToString("") { "%02x".format(it) }
                Log.e("MASWE_0007", "Vector 5: Key length 56/64 bits: $hex")
                "EXPOSED (56-BIT KEY): $hex (NIST requires minimum 128-bit symmetric key length)"
            }

            Maswe0007Vector.KEY_REUSE -> {
                // ❌ Vector 6: RSA Key Pair Reuse for both Encryption and Signing
                val kpg = KeyPairGenerator.getInstance("RSA")
                kpg.initialize(2048)
                val keyPair = kpg.generateKeyPair()

                // Encrypt with public key
                val encCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
                encCipher.init(Cipher.ENCRYPT_MODE, keyPair.public)
                val encBytes = encCipher.doFinal("ConfidentialData".toByteArray(Charsets.UTF_8))

                // Sign with the SAME private key
                val signer = Signature.getInstance("SHA256withRSA")
                signer.initSign(keyPair.private)
                signer.update("StatementToSign".toByteArray(Charsets.UTF_8))
                val sigBytes = signer.sign()

                Log.e("MASWE_0007", "Vector 6: Same RSA key pair used for encryption (${encBytes.size}B) and signature (${sigBytes.size}B)")
                "EXPOSED (KEY REUSE): Same RSA-2048 key used for Encrypt & Sign. Violates NIST SP 800-57!"
            }

            Maswe0007Vector.NON_CRYPTO_OBFUSCATION -> {
                // ❌ Vector 7: XOR / Base64 Masquerading as Encryption
                val plainBytes = appData.userContext.plainTextPasswordInHeap.toByteArray(Charsets.UTF_8)
                val xorKey: Byte = 0x5A
                val xored = ByteArray(plainBytes.size) { i -> plainBytes[i] xor xorKey }
                val encoded = Base64.encodeToString(xored, Base64.NO_WRAP)
                Log.e("MASWE_0007", "Vector 7: XOR 'encrypted' Base64 string: $encoded")
                "EXPOSED (NON-CRYPTO): XOR mask 0x5A + Base64 -> $encoded (Trivially reversible in 1 CPU cycle)"
            }
        }
    }
}
