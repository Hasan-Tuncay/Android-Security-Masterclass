package com.hasantuncay.mobsec.secure.storage.maswe0002

import android.content.Context
import android.net.Uri
import android.os.Build
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.core.content.FileProvider

import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import com.hasantuncay.mobsec.common.models.Maswe0002Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

/**
 * 🛡️ SECURE IMPLEMENTATION: MASWE-0002
 * Sensitive Data Stored With Insufficient Access Restrictions in Internal Locations
 *
 * MASVS:   MASVS-STORAGE-2
 *
 * EDUCATIONAL OVERVIEW:
 * This class implements proper cryptographic countermeasures for all local storage vectors.
 * It demonstrates how to utilize Android's hardware-backed Keystore, EncryptedSharedPreferences,
 * Google Tink (AEAD) for DataStore/Files, and secure API configurations (FileProvider/WebView).
 */
object Maswe0002SecureLogic {

    init {
        AeadConfig.register()
    }

    /**
     * TINK AEAD INITIALIZATION
     *
     * Google Tink provides high-level cryptographic APIs. Here we generate/retrieve an AES256-GCM
     * keyset wrapped by a Master Key residing in the Android Keystore (TEE/StrongBox).
     */
    private fun getTinkAead(context: Context): Aead {
        return AndroidKeysetManager.Builder()
            .withSharedPref(context, "maswe0002_tink_keyset", "secure_prefs")
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri("android-keystore://maswe0002_tink_master_key")
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    }

    suspend fun executeVector(
        vector: Maswe0002Vector,
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        when (vector) {
            Maswe0002Vector.SHARED_PREFS_PLAINTEXT   -> triggerSharedPrefsSecure(appData, context, onResult)
            Maswe0002Vector.DATASTORE_UNENCRYPTED    -> triggerDataStoreSecure(appData, context, onResult)
            Maswe0002Vector.SQLITE_PLAINTEXT         -> triggerSqliteSecure(appData, context, onResult)
            Maswe0002Vector.FILE_PROVIDER_ROOT_PATH  -> triggerFileProviderSecure(appData, context, onResult)
            Maswe0002Vector.EXTERNAL_STORAGE         -> triggerExternalStorageSecure(appData, context, onResult)
            Maswe0002Vector.WEBVIEW_DOM_STORAGE      -> triggerWebViewSecure(appData, context, onResult)
            Maswe0002Vector.CACHE_DIRECTORY          -> triggerCacheSecure(appData, context, onResult)
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 1: ENCRYPTED SHARED PREFERENCES
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 1: EncryptedSharedPreferences
     *
     * Countermeasure: Uses AndroidX Security library to transparently encrypt keys (AES256-SIV)
     * and values (AES256-GCM). The MasterKey is hardware-backed, meaning the encryption keys
     * never leave the Trusted Execution Environment (TEE).
     */
    private suspend fun triggerSharedPrefsSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            val encryptedPrefs = EncryptedSharedPreferences.create(
                context,
                "maswe0002_secure_prefs",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )

            encryptedPrefs.edit().apply {
                putString("auth_token", appData.networkSession.oAuth2BearerToken)
                putString("national_id", String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask()))
            }.commit()
            
            // Memory scrubbing immediately after encryption
            appData.gdprPii.directIdentifiers.nationalIdentificationNumber.wipe()

            val path = "${context.applicationInfo.dataDir}/shared_prefs/maswe0002_secure_prefs.xml"
            withContext(Dispatchers.Main) { onResult(path) }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 2: DATASTORE WITH TINK AEAD
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 2: DataStore Payload Encryption (Google Tink)
     *
     * Countermeasure: Since DataStore natively uses unencrypted Protocol Buffers or JSON,
     * the application MUST encrypt the payload before passing it to the DataStore serializer.
     * We use Tink's Authenticated Encryption with Associated Data (AEAD) to ensure both
     * confidentiality and integrity.
     */
    private suspend fun triggerDataStoreSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val aead = getTinkAead(context)
            val file = File(context.filesDir, "datastore/maswe0002_secure.json")
            file.parentFile?.mkdirs()
            
            val json = JSONObject().apply {
                put("auth_token", appData.networkSession.oAuth2BearerToken)
                put("national_id", String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask()))
            }.toString()
            
            appData.gdprPii.directIdentifiers.nationalIdentificationNumber.wipe()

            // SECURE: Encrypt the JSON payload before writing to disk
            val ciphertext = aead.encrypt(json.toByteArray(), null)
            FileOutputStream(file).use { it.write(ciphertext) }

            withContext(Dispatchers.Main) { onResult(file.absolutePath) }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 3: SQLCIPHER (STUB)
    // ══════════════════════════════════════════════════════════════════════════

    private suspend fun triggerSqliteSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.Main) {
            onResult("SQLCipher Implementation (To be fully integrated with net.zetetic:android-database-sqlcipher)")
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 4: RESTRICTED FILEPROVIDER
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 4: Scoped FileProvider Paths
     *
     * Countermeasure: Never use <root-path> or broad directories. The XML config should explicitly 
     * map only the sub-directories intended for sharing (e.g., <files-path name="images" path="images/"/>).
     */
    private suspend fun triggerFileProviderSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val file = File(context.filesDir, "images/safe_image.png")
            file.parentFile?.mkdirs()
            if (!file.exists()) file.createNewFile()

            try {
                // Requires an XML config mapping `files/images/` to `images`
                val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
                withContext(Dispatchers.Main) { onResult(uri.toString()) }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { onResult("Error: ${e.message}") }
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 5: ENCRYPTED INTERNAL FALLBACK
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 5: EncryptedFile and Internal Relocation
     *
     * Countermeasure: PII/PHI should NEVER be on External Storage. It should be relocated to 
     * the Internal App Sandbox and protected at rest using AndroidX Security EncryptedFile.
     */
    private suspend fun triggerExternalStorageSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val safeInternalFile = File(context.filesDir, "maswe0002_safe_internal.json")
            val payload = "{\"email\":\"${String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask())}\"}"
            appData.gdprPii.directIdentifiers.personalEmail.wipe()
            
            val masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
            
            if (safeInternalFile.exists()) safeInternalFile.delete()
            
            val encryptedFile = EncryptedFile.Builder(
                context,
                safeInternalFile,
                masterKey,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
            ).build()

            encryptedFile.openFileOutput().use { it.write(payload.toByteArray()) }
            
            withContext(Dispatchers.Main) { onResult(safeInternalFile.absolutePath) }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 6: WEBVIEW DOM STORAGE DISABLED
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 6: DOM Storage Disabled
     *
     * Countermeasure: Prevent the WebView from writing `localStorage` to the filesystem.
     * If session persistence is required, use secure JavaScript Interfaces (addJavascriptInterface)
     * backed by EncryptedSharedPreferences on the native side.
     */
    private suspend fun triggerWebViewSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.Main) {
            val webView = WebView(context)
            webView.settings.javaScriptEnabled = true
            // SECURE: Disable DOM Storage entirely
            webView.settings.domStorageEnabled = false
            onResult("WebView configured securely (domStorageEnabled = false)")
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 7: ENCRYPTED CACHE & LIFECYCLE MANAGEMENT
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 7: Ephemeral Encrypted Cache
     *
     * Countermeasure: Files written to the Cache directory MUST be encrypted and explicitly 
     * flagged for deletion via `deleteOnExit()`. Sensitive buffers must be zeroed out.
     */
    private suspend fun triggerCacheSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val aead = getTinkAead(context)
            val tempFile = File.createTempFile("ekstre_", ".pdf", context.cacheDir)
            
            // SECURE: Enforce VM-level deletion hook
            tempFile.deleteOnExit()

            val pan = appData.pciDss.cardholderData.primaryAccountNumber
            val ciphertext = aead.encrypt("PDF HEADER... PAN: $pan".toByteArray(), null)
            
            FileOutputStream(tempFile).use { it.write(ciphertext) }

            withContext(Dispatchers.Main) { onResult("${tempFile.absolutePath} (Encrypted & deleteOnExit)") }
        }
    }
}
