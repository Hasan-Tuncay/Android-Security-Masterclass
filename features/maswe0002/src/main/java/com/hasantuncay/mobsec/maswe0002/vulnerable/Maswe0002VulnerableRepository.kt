package com.hasantuncay.mobsec.maswe0002.vulnerable

import android.content.Context
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import com.hasantuncay.mobsec.common.R as CommonR
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Vector
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0002
 * Sensitive Data Stored Unencrypted Outside of Private Storage
 *
 * MASVS:   MASVS-STORAGE-2
 * MASWE:   https://mas.owasp.org/MASWE/MASVS-STORAGE/MASWE-0002/
 *
 * TECHNICAL OVERVIEW:
 * This class demonstrates writing sensitive data to External Storage (`getExternalFilesDir()`)
 * which lacks the strict access controls of internal storage. Even if encrypted, the
 * implementation might suffer from hardcoded keys, keys stored on the filesystem, weak algorithms,
 * or predictable/reused keys across devices.
 *
 * THREAT MODEL:
 * - API < 29: Any app with `READ_EXTERNAL_STORAGE` can read files in `getExternalFilesDir()`.
 * - Physical Access (SD Card): If external storage is a physical SD card, it can be removed.
 * - MTP/USB Access: Files might be accessible without rooting the device.
 */
@Singleton
class Maswe0002VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun executeVector(
        vector: Maswe0002Vector,
        appData: MasterclassData
    ): String? {
        return when (vector) {
            Maswe0002Vector.EXTERNAL_STORAGE -> triggerExternalStorageLeak(appData)
            Maswe0002Vector.HARDCODED_ENCRYPTION_KEY -> triggerHardcodedKey(appData)
            Maswe0002Vector.ENCRYPTION_KEY_ON_FILESYSTEM -> triggerKeyOnFilesystem(appData)
            Maswe0002Vector.INSUFFICIENT_ENCRYPTION -> triggerInsufficientEncryption(appData)
            Maswe0002Vector.REUSE_OF_ENCRYPTION_KEY -> triggerKeyReuse(appData)
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 1: DATA STORED UNENCRYPTED
    // ══════════════════════════════════════════════════════════════════════════
    private suspend fun triggerExternalStorageLeak(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) {
                showError("External storage not available.")
                return@withContext
            }

            val sensitiveFile = File(externalDir, "maswe0002_plaintext.json")
            val payload = """
                {
                  "auth_token": "${appData.networkSession.oAuth2BearerToken}",
                  "pan": "${appData.pciDss.cardholderData.primaryAccountNumber}"
                }
            """.trimIndent()

            FileOutputStream(sensitiveFile).use { it.write(payload.toByteArray()) }

            Log.e("VULN_0002", "Vector 1 | Plaintext data written to: ${sensitiveFile.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = sensitiveFile.absolutePath }
        }
        return resultPath
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 2: HARDCODED ENCRYPTION KEY
    // ══════════════════════════════════════════════════════════════════════════
    private val HARDCODED_KEY = "Sup3rS3cr3tK3y!!1234567890123456" // 32 bytes

    private suspend fun triggerHardcodedKey(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) return@withContext

            val file = File(externalDir, "maswe0002_hardcoded.enc")
            val payload = appData.networkSession.oAuth2BearerToken.toByteArray()

            // VULNERABLE: Using a hardcoded key in source code
            val secretKey = SecretKeySpec(HARDCODED_KEY.toByteArray(), "AES")
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encrypted = cipher.doFinal(payload)

            FileOutputStream(file).use { it.write(encrypted) }

            Log.e("VULN_0002", "Vector 2 | Encrypted with hardcoded key: ${file.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 3: ENCRYPTION KEY STORED ON FILESYSTEM
    // ══════════════════════════════════════════════════════════════════════════
    private suspend fun triggerKeyOnFilesystem(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) return@withContext

            // Generate a random key but store it next to the encrypted file!
            val keyBytes = ByteArray(32)
            java.security.SecureRandom().nextBytes(keyBytes)
            
            val keyFile = File(externalDir, "maswe0002_secret.key")
            FileOutputStream(keyFile).use { it.write(keyBytes) }

            val file = File(externalDir, "maswe0002_key_on_fs.enc")
            val payload = appData.networkSession.oAuth2BearerToken.toByteArray()
            
            val secretKey = SecretKeySpec(keyBytes, "AES")
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            
            FileOutputStream(file).use { it.write(cipher.doFinal(payload)) }

            Log.e("VULN_0002", "Vector 3 | Key leaked at: ${keyFile.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 4: INSUFFICIENT ENCRYPTION (Weak algorithm - DES)
    // ══════════════════════════════════════════════════════════════════════════
    private suspend fun triggerInsufficientEncryption(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) return@withContext

            val file = File(externalDir, "maswe0002_weak.enc")
            val payload = appData.networkSession.oAuth2BearerToken.toByteArray()

            // VULNERABLE: Using DES, a broken and weak encryption algorithm
            val desKey = "WeakKey1".toByteArray() // 8 bytes
            val secretKey = SecretKeySpec(desKey, "DES")
            val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            
            FileOutputStream(file).use { it.write(cipher.doFinal(payload)) }

            Log.e("VULN_0002", "Vector 4 | Encrypted with weak DES algorithm: ${file.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 5: REUSE OF ENCRYPTION KEY (Predictable / Device Cloned Key)
    // ══════════════════════════════════════════════════════════════════════════
    private suspend fun triggerKeyReuse(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) return@withContext

            val file = File(externalDir, "maswe0002_reused_key.enc")
            val payload = appData.networkSession.oAuth2BearerToken.toByteArray()

            // VULNERABLE: Key is deterministically derived from ANDROID_ID.
            // If the user's data is moved to a cloned device or the ID is known/spoofed,
            // the data can be decrypted. It is not bound to the hardware Keystore.
            val androidId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: "unknown_id"
            val md = MessageDigest.getInstance("SHA-256")
            val keyBytes = md.digest(androidId.toByteArray())
            
            val secretKey = SecretKeySpec(keyBytes, "AES")
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            
            FileOutputStream(file).use { it.write(cipher.doFinal(payload)) }

            Log.e("VULN_0002", "Vector 5 | Encrypted with predictable key (ANDROID_ID): ${file.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    private suspend fun showError(msg: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
