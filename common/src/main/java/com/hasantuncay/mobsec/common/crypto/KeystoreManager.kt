package com.hasantuncay.mobsec.common.crypto

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * Merkezi Kriptografi: Donanım Destekli Android Keystore Yönetimi
 *
 * TEE (Trusted Execution Environment) veya StrongBox üzerinde anahtar oluşturma mantığının
 * tek bir helper class üzerinden sunulması.
 */
object KeystoreManager {

    private const val ANDROID_KEYSTORE = "AndroidKeyStore"

    /**
     * Generates an AES-256 GCM key in the Android Keystore if it doesn't already exist.
     * Optionally requires user authentication.
     */
    fun getOrCreateKey(alias: String, requireAuth: Boolean = false): SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }

        if (!keyStore.containsAlias(alias)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)

            val builder = KeyGenParameterSpec.Builder(
                alias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(256)

            if (requireAuth) {
                // To enforce biometric/credential authentication for key usage
                builder.setUserAuthenticationRequired(true)
                // Need API 30+ for the new method, using standard for now or ignoring
                // builder.setUserAuthenticationValidityDurationSeconds(30) // deprecated in API 30
            }

            keyGenerator.init(builder.build())
            keyGenerator.generateKey()
        }

        val secretKeyEntry = keyStore.getEntry(alias, null) as KeyStore.SecretKeyEntry
        return secretKeyEntry.secretKey
    }
}