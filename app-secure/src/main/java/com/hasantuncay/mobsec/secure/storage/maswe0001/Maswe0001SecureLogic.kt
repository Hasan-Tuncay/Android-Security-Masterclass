package com.hasantuncay.mobsec.secure.storage.maswe0001

import android.content.Context
import android.net.Uri
import android.os.Build
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.room.Room

import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import com.hasantuncay.mobsec.common.models.Maswe0001Mitigation
import com.hasantuncay.mobsec.common.utils.DataMaskingUtils
import com.hasantuncay.mobsec.secure.crypto.KeystoreManager
import net.sqlcipher.database.SupportFactory
import com.hasantuncay.mobsec.secure.storage.maswe0002.EncryptedDataStoreSerializer
import com.hasantuncay.mobsec.secure.storage.maswe0002.SecureDatabase
import com.hasantuncay.mobsec.secure.storage.maswe0002.SecureRecord
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
object Maswe0001SecureLogic {

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
            .withSharedPref(context, "maswe0001_tink_keyset", "secure_prefs")
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri("android-keystore://maswe0001_tink_master_key")
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    }

    suspend fun executeVector(
        vector: Maswe0001Mitigation,
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        when (vector) {
            Maswe0001Mitigation.SHARED_PREFS_PLAINTEXT   -> triggerSharedPrefsSecure(appData, context, onResult)
            Maswe0001Mitigation.DATASTORE_UNENCRYPTED    -> triggerDataStoreSecure(appData, context, onResult)
            Maswe0001Mitigation.SQLITE_PLAINTEXT         -> triggerSqliteSecure(appData, context, onResult)
            Maswe0001Mitigation.FILE_PROVIDER_ROOT_PATH  -> triggerFileProviderSecure(appData, context, onResult)
            Maswe0001Mitigation.WEBVIEW_DOM_STORAGE      -> triggerWebViewSecure(appData, context, onResult)
            Maswe0001Mitigation.CACHE_DIRECTORY          -> triggerCacheSecure(appData, context, onResult)
            Maswe0001Mitigation.PATH_TRAVERSAL           -> triggerPathTraversalSecure(appData, context, onResult)
            Maswe0001Mitigation.THIRD_PARTY_SDK_LEAK     -> triggerSdkSecure(appData, context, onResult)
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
     *
     * ⚠️ EDUCATIONAL NOTE:
     * This library (androidx.security.crypto) is officially DEPRECATED by Google as of 2025 due
     * to performance/corruption issues. The modern "Best Practice" is Jetpack DataStore + Tink (see Vector 2).
     * However, this implementation is kept here as an example because it is still heavily used 
     * in the industry and you will frequently encounter it in existing legacy codebases.
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
                "maswe0001_secure_prefs",
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

            val path = "${context.applicationInfo.dataDir}/shared_prefs/maswe0001_secure_prefs.xml"
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
            
            // Generate the secure datastore using the custom AEAD Serializer
            val dataStore = DataStoreFactory.create(
                serializer = EncryptedDataStoreSerializer(aead),
                produceFile = { context.dataStoreFile("maswe0001_secure.json") }
            )
            
            val json = JSONObject().apply {
                put("auth_token", appData.networkSession.oAuth2BearerToken)
                put("national_id", String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask()))
            }.toString()
            
            appData.gdprPii.directIdentifiers.nationalIdentificationNumber.wipe()

            // SECURE: Encrypt the JSON payload before writing to disk automatically via Serializer
            dataStore.updateData { json }

            val file = context.dataStoreFile("maswe0001_secure.json")
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
        withContext(Dispatchers.IO) {
            // Generate a 256-bit AES key using the hardware-backed keystore
            val secretKey = KeystoreManager.getOrCreateKey("maswe0001_db_key")
            val passphrase = secretKey.encoded

            // Pass the passphrase to SQLCipher's SupportFactory
            val factory = SupportFactory(passphrase)

            val db = Room.databaseBuilder(
                context,
                SecureDatabase::class.java,
                "maswe0001_secure.db"
            ).openHelperFactory(factory).build()

            db.secureRecordDao().insert(
                SecureRecord(
                    pan = appData.pciDss.cardholderData.primaryAccountNumber,
                    cvv = appData.pciDss.sensitiveAuthenticationData.cardVerificationCode,
                    pinBlock = appData.pciDss.sensitiveAuthenticationData.pinBlock,
                    hipaaMrn = appData.hipaaPhi.medicalRecordNumber,
                    icd10Code = appData.hipaaPhi.icd10DiagnosisCode,
                    nationalId = String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask())
                )
            )

            // Clear passphrase from memory
            passphrase.fill(0)

            val dbPath = "${context.applicationInfo.dataDir}/databases/maswe0001_secure.db"
            withContext(Dispatchers.Main) {
                onResult(dbPath)
            }
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
     *
     * ⚠️ EDUCATIONAL NOTE:
     * Like EncryptedSharedPreferences, `EncryptedFile` is DEPRECATED. The modern best practice
     * is to use Google Tink's `StreamingAead` or standard `Aead` directly. We include this 
     * wrapper here because it is a very common legacy pattern still found in many applications.
     * To suppress the IDE warning, you can use @Suppress("DEPRECATION") if strictly required.
     */
    @Suppress("DEPRECATION")
    private suspend fun triggerExternalStorageSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val safeInternalFile = File(context.filesDir, "maswe0001_safe_internal.json")
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

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 8: PATH CANONICALIZATION (CWE-22)
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 8: Path Traversal Mitigation
     *
     * Countermeasure: Never trust user/external input for file paths. Always use `canonicalPath`
     * to resolve `../` sequences, and verify that the resolved path still resides inside the 
     * intended base directory.
     */
    private suspend fun triggerPathTraversalSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val maliciousInput = "../../../shared_prefs/maswe0001_session.xml"
            val baseDir = context.cacheDir
            
            // 1. Create file object (contains malicious input)
            val requestedFile = File(baseDir, maliciousInput)
            
            // 2. SECURE: Resolve the absolute path removing all symlinks and ../
            val resolvedCanonicalPath = requestedFile.canonicalPath
            val safeBaseCanonicalPath = baseDir.canonicalPath
            
            // 3. SECURE: Verify that the resolved path is a child of the base directory
            if (!resolvedCanonicalPath.startsWith(safeBaseCanonicalPath)) {
                withContext(Dispatchers.Main) { 
                    onResult("BLOCKED: SecurityException - Path Traversal Attempt Detected!") 
                }
                return@withContext
            }

            // If it was safe, proceed...
            withContext(Dispatchers.Main) { 
                onResult("Safe file access granted.") 
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SECURE VECTOR 9: 3RD PARTY SDK SHADOW LEAK MITIGATION
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * SECURE VECTOR 9: Data Masking for 3rd Party SDKs
     *
     * Countermeasure: If an SDK saves data unencrypted, never send it raw PII. 
     * Mask, truncate, or hash the data before calling the SDK's tracking methods.
     */
    private suspend fun triggerSdkSecure(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val rawEmail = String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask())
            val rawTckn = String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask())
            
            // SECURE: Mask the email using common utils
            val maskedEmail = DataMaskingUtils.maskEmail(rawEmail)
            
            // SECURE: Hash the TCKN (One-way cryptographic hash)
            val tcknHash = DataMaskingUtils.hashSha256(rawTckn)

            // Write to the shadow DB simulating the SDK
            val dbDir = File(context.applicationInfo.dataDir, "databases")
            if (!dbDir.exists()) dbDir.mkdirs()
            val shadowDb = File(dbDir, "analytics_shadow_secure.db")
            
            android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(shadowDb, null).use { db ->
                db.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY, event_name TEXT, payload TEXT)")
                
                val safePayload = """
                    {"user_email": "$maskedEmail", "tckn_hash": "$tcknHash"}
                """.trimIndent()
                
                val values = android.content.ContentValues().apply {
                    put("event_name", "user_signup")
                    put("payload", safePayload)
                }
                db.insert("events", null, values)
            }

            withContext(Dispatchers.Main) {
                onResult("${shadowDb.absolutePath}\nCheck DB to verify data is masked/hashed!")
            }
        }
    }
}
