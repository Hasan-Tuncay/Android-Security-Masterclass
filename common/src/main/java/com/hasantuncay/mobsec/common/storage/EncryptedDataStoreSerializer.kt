package com.hasantuncay.mobsec.common.storage

import androidx.datastore.core.Serializer
import androidx.datastore.preferences.core.PreferencesSerializer.defaultValue
import com.google.crypto.tink.Aead
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.OutputStream

/**
 * 🛡️ SECURE VECTOR 2: DataStore Payload Encryption (Google Tink)
 *
 * Implements a custom Jetpack DataStore Serializer that transparently encrypts
 * and decrypts data using Google Tink's Authenticated Encryption with Associated Data (AEAD).
 *
 * This ensures that the underlying protobuf or custom file is fully encrypted at rest,
 * mitigating CWE-922 (Insecure Storage of Sensitive Information).
 */
class EncryptedDataStoreSerializer(
    private val aead: Aead
) : Serializer<String> {

    override val defaultValue: String = "{}"

    override suspend fun readFrom(input: InputStream): String {
        return withContext(Dispatchers.IO) {
            try {
                val encryptedBytes = input.readBytes()
                if (encryptedBytes.isEmpty()) {
                    return@withContext defaultValue
                }
                val decryptedBytes = aead.decrypt(encryptedBytes, null)
                String(decryptedBytes, Charsets.UTF_8)
            } catch (e: Exception) {
                e.printStackTrace()
                defaultValue
            }
        }
    }

    override suspend fun writeTo(t: String, output: OutputStream) {
        withContext(Dispatchers.IO) {
            val encryptedBytes = aead.encrypt(t.toByteArray(Charsets.UTF_8), null)
            output.write(encryptedBytes)
        }
    }
}
