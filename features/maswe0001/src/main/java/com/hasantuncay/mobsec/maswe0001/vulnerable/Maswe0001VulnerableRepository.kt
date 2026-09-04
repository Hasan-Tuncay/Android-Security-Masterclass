package com.hasantuncay.mobsec.maswe0001.vulnerable

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Base64

@Singleton
class Maswe0001VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val Context.maswe0001V1DataStore by preferencesDataStore(name = "maswe0001_v1")
    private val KEY_AUTH_TOKEN = stringPreferencesKey("auth_token")

    suspend fun executeVector(
        vector: Maswe0001Vector,
        appData: MasterclassData
    ): String? {
        return when (vector) {
            Maswe0001Vector.DATA_STORED_UNENCRYPTED -> triggerDataStoredUnencrypted(appData)
            Maswe0001Vector.HARDCODED_ENCRYPTION_KEY -> triggerHardcodedEncryptionKey(appData)
            Maswe0001Vector.KEY_STORED_ON_FILESYSTEM -> triggerKeyStoredOnFilesystem(appData)
            Maswe0001Vector.INSUFFICIENT_ENCRYPTION -> triggerInsufficientEncryption(appData)
            Maswe0001Vector.INSUFFICIENT_ACCESS_RESTRICTIONS -> triggerInsufficientAccessRestrictions(appData)
            Maswe0001Vector.DATA_NOT_REMOVED_AFTER_USE -> triggerDataNotRemovedAfterUse(appData)
        }
    }

    // VULNERABILITY 1: Data Stored Unencrypted (DataStore without Tink)
    private suspend fun triggerDataStoredUnencrypted(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            context.maswe0001V1DataStore.edit { prefs ->
                prefs[KEY_AUTH_TOKEN] = appData.networkSession.oAuth2BearerToken
            }
            val filePath = "${context.applicationInfo.dataDir}/files/datastore/maswe0001_v1.preferences_pb"
            Log.e("MASWE_0001", "Vector 1: Unencrypted DataStore saved at $filePath")
            withContext(Dispatchers.Main) { resultPath = filePath }
        }
        return resultPath
    }

    // VULNERABILITY 2: Hardcoded Encryption Key
    private suspend fun triggerHardcodedEncryptionKey(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // VULNERABILITY: Key is hardcoded in the source code
            val hardcodedKeyBytes = "SuperSecretKey1234567890123456".toByteArray()
            val secretKeySpec = SecretKeySpec(hardcodedKeyBytes, "AES")
            
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            val iv = cipher.iv
            
            val encryptedData = cipher.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())
            
            val file = File(context.filesDir, "maswe0001_v2.enc")
            FileOutputStream(file).use { 
                it.write(iv)
                it.write(encryptedData)
            }
            
            Log.e("MASWE_0001", "Vector 2: Encrypted with hardcoded key saved at ${file.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // VULNERABILITY 3: Encryption Key Stored on Filesystem
    private suspend fun triggerKeyStoredOnFilesystem(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // Generate a secure key, BUT save it to SharedPreferences in plaintext!
            val keyGen = KeyGenerator.getInstance("AES")
            keyGen.init(256)
            val secretKey = keyGen.generateKey()
            
            val prefs = context.getSharedPreferences("maswe0001_v3_keys", Context.MODE_PRIVATE)
            val encodedKey = Base64.getEncoder().encodeToString(secretKey.encoded)
            prefs.edit().putString("aes_key", encodedKey).commit() // VULNERABILITY

            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val iv = cipher.iv
            val encryptedData = cipher.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())
            
            val file = File(context.filesDir, "maswe0001_v3.enc")
            FileOutputStream(file).use { 
                it.write(iv)
                it.write(encryptedData)
            }
            
            val prefsPath = "${context.applicationInfo.dataDir}/shared_prefs/maswe0001_v3_keys.xml"
            Log.e("MASWE_0001", "Vector 3: Encrypted data saved, BUT key is plainly saved in $prefsPath")
            withContext(Dispatchers.Main) { resultPath = prefsPath }
        }
        return resultPath
    }

    // VULNERABILITY 4: Insufficient Encryption (Weak Algorithm)
    private suspend fun triggerInsufficientEncryption(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // Generate a secure key, but use a weak algorithm (ECB mode)
            val keyGen = KeyGenerator.getInstance("AES")
            keyGen.init(128) // 128-bit key might be considered weaker than 256
            val secretKey = keyGen.generateKey()
            
            // VULNERABILITY: ECB mode is insecure, doesn't use an IV, and is deterministic
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encryptedData = cipher.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())
            
            val file = File(context.filesDir, "maswe0001_v4.enc")
            FileOutputStream(file).use { 
                it.write(encryptedData)
            }
            
            Log.e("MASWE_0001", "Vector 4: Encrypted with weak AES/ECB mode saved at ${file.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // VULNERABILITY 5: Insufficient Access Restrictions
    private suspend fun triggerInsufficientAccessRestrictions(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val prefs = context.getSharedPreferences("maswe0001_v5_sensitive", Context.MODE_PRIVATE)
            prefs.edit().putString("auth_token", appData.networkSession.oAuth2BearerToken).commit()

            val file = File(context.applicationInfo.dataDir, "shared_prefs/maswe0001_v5_sensitive.xml")
            if (!file.exists()) return@withContext

            try {
                // VULNERABILITY: Exposing internal files via a misconfigured FileProvider that maps root-path
                val uri: Uri = FileProvider.getUriForFile(
                    context,
                    "${context.packageName}.fileprovider",
                    file
                )

                val exploitIntent = android.content.Intent().apply {
                    setClassName("com.hasantuncay.mobsec.attacker", "com.hasantuncay.mobsec.attacker.AttackerMainActivity")
                    data = uri
                    addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }

                try {
                    context.startActivity(exploitIntent)
                } catch (e: Exception) {
                    if (e is kotlin.coroutines.cancellation.CancellationException) throw e
                    Log.w("MASWE_0001", "Attacker app not installed.")
                }

                withContext(Dispatchers.Main) { resultPath = uri.toString() }
            } catch (e: Exception) {
                if (e is kotlin.coroutines.cancellation.CancellationException) throw e
                withContext(Dispatchers.Main) { resultPath = null }
            }
        }
        return resultPath
    }

    // VULNERABILITY 6: Data Not Removed After Use
    private suspend fun triggerDataNotRemovedAfterUse(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // VULNERABILITY: Writing to cacheDir and never deleting it
            val tempFile = File.createTempFile("sensitive_temp_", ".txt", context.cacheDir)
            
            FileOutputStream(tempFile).use { out ->
                val token = appData.networkSession.oAuth2BearerToken
                out.write("Temporary Session Dump: $token".toByteArray())
            }

            // We intentionally DO NOT call tempFile.deleteOnExit() or tempFile.delete()
            Log.e("MASWE_0001", "Vector 6: Sensitive data left indefinitely in cache at ${tempFile.absolutePath}")
            withContext(Dispatchers.Main) { resultPath = tempFile.absolutePath }
        }
        return resultPath
    }
}
