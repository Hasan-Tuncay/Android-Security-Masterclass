package com.hasantuncay.mobsec.maswe0002.secure

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 🛡️ SECURE IMPLEMENTATION: MASWE-0002
 *
 * MITIGATION OVERVIEW:
 * 1. Prefer Private Storage: Store data in the internal sandbox (`context.filesDir`) instead of
 *    external storage. Internal storage enforces strict access control via SELinux and filesystem permissions.
 * 2. Encrypt Data Before Writing: If you *must* write to external storage, encrypt the data.
 * 3. Protect Encryption Keys: Keys must be generated and managed exclusively within the Android Keystore
 *    so they cannot be extracted or reused on another device. Jetpack Security `EncryptedFile` handles this.
 */
@Singleton
class Maswe0002SecureRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun executeMitigation(
        mitigation: Maswe0002Mitigation,
        appData: MasterclassData
    ): String? {
        return when (mitigation) {
            Maswe0002Mitigation.EXTERNAL_STORAGE -> secureInternalStorage(appData)
            Maswe0002Mitigation.HARDCODED_ENCRYPTION_KEY -> secureEncryptedFile(appData, "maswe0002_secure_1.enc")
            Maswe0002Mitigation.ENCRYPTION_KEY_ON_FILESYSTEM -> secureEncryptedFile(appData, "maswe0002_secure_2.enc")
            Maswe0002Mitigation.INSUFFICIENT_ENCRYPTION -> secureEncryptedFile(appData, "maswe0002_secure_3.enc")
            Maswe0002Mitigation.REUSE_OF_ENCRYPTION_KEY -> secureEncryptedFile(appData, "maswe0002_secure_4.enc")
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MITIGATION 1: PREFER PRIVATE STORAGE
    // ══════════════════════════════════════════════════════════════════════════
    private suspend fun secureInternalStorage(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // SECURE: Writing to context.filesDir (Internal Storage sandbox)
            // No other app can read this, even without encryption (unless rooted).
            val secureDir = context.filesDir
            val secureFile = File(secureDir, "maswe0002_internal.json")
            
            val payload = """
                {
                  "auth_token": "${appData.networkSession.oAuth2BearerToken}",
                  "pan": "${appData.pciDss.cardholderData.primaryAccountNumber}"
                }
            """.trimIndent()

            FileOutputStream(secureFile).use { it.write(payload.toByteArray()) }

            Log.i("SECURE_0002", "Mitigation 1 | Data written to internal sandbox: ${secureFile.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = secureFile.absolutePath }
        }
        return resultPath
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MITIGATIONS 2, 3, 4, 5: ENCRYPTED FILE (JETPACK SECURITY)
    // ══════════════════════════════════════════════════════════════════════════
    /**
     * If data MUST be stored in External Storage, it must be encrypted using 
     * a secure, non-deterministic authenticated algorithm (AES-256-GCM), with a 
     * key that is hardware-bound and safely stored in the Android Keystore.
     */
    private suspend fun secureEncryptedFile(appData: MasterclassData, fileName: String): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) {
                showError("External storage not available.")
                return@withContext
            }

            val file = File(externalDir, fileName)
            if (file.exists()) file.delete() // Clean up previous runs

            val payload = appData.networkSession.oAuth2BearerToken.toByteArray()

            try {
                // SECURE: Use Jetpack Security MasterKey.
                // It generates an AES-256-GCM key inside the Android Keystore hardware.
                // The key cannot be extracted, hardcoded, leaked on the filesystem, or reused on other devices.
                val masterKey = MasterKey.Builder(context)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build()

                // EncryptedFile wraps StreamingAead and automatically encrypts data written to disk.
                val encryptedFile = EncryptedFile.Builder(
                    context,
                    file,
                    masterKey,
                    EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
                ).build()

                encryptedFile.openFileOutput().use { out ->
                    out.write(payload)
                }

                Log.i("SECURE_0002", "Mitigation | Securely encrypted external file: ${file.absolutePath}")
                withContext(Dispatchers.Main) { resultPath = file.absolutePath }

            } catch (e: Exception) {
                Log.e("SECURE_0002", "Encryption failed", e)
                showError("Encryption failed: ${e.message}")
            }
        }
        return resultPath
    }

    private suspend fun showError(msg: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
