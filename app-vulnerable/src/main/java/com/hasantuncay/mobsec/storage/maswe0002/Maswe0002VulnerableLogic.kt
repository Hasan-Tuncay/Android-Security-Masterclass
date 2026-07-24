package com.hasantuncay.mobsec.storage.maswe0002

import android.content.Context
import android.net.Uri
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hasantuncay.mobsec.common.models.Maswe0002Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0002
 * Sensitive Data Stored With Insufficient Access Restrictions in Internal Locations
 *
 * MASVS:   MASVS-STORAGE-2
 * MASWE:   https://mas.owasp.org/MASWE/MASVS-STORAGE/MASWE-0002/
 *
 * TECHNICAL OVERVIEW:
 * This class demonstrates distinct insecure storage patterns. Each vector writes
 * sensitive data (auth tokens, PII, PCI-DSS cardholder data) to a storage location
 * that lacks sufficient access restrictions — either due to missing encryption,
 * wrong file permissions, incorrect FileProvider configuration, or inappropriate
 * storage location selection.
 *
 * THREAT MODEL:
 * - Root access: All vectors exploitable
 * - ADB backup (allowBackup=true): Vectors 1, 2, 3, 5 exploitable
 * - Other-app (no root): Vectors 4 (via crafted content:// URI), 5 (API < 29)
 * - Physical access (USB/MTP): All vectors exploitable
 */
object Maswe0002VulnerableLogic {

    // ──────────────────────────────────────────────────────────────────────────
    // VECTOR 2 SETUP: DataStore property extension on Context
    // The DataStore file will be written to: /data/data/<pkg>/files/datastore/maswe0002_store.preferences_pb
    // ──────────────────────────────────────────────────────────────────────────
    private val Context.maswe0002DataStore by preferencesDataStore(name = "maswe0002_store")

    private val KEY_AUTH_TOKEN   = stringPreferencesKey("auth_token")
    private val KEY_OAUTH_REFRESH = stringPreferencesKey("oauth_refresh_token")
    private val KEY_FULL_NAME    = stringPreferencesKey("user_full_name")
    private val KEY_NATIONAL_ID  = stringPreferencesKey("national_id")
    private val KEY_EMAIL        = stringPreferencesKey("email")

    suspend fun executeVector(
        vector: Maswe0002Vector,
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        when (vector) {
            Maswe0002Vector.SHARED_PREFS_PLAINTEXT   -> triggerSharedPrefsLeak(appData, context, onResult)
            Maswe0002Vector.DATASTORE_UNENCRYPTED    -> triggerDataStoreLeak(appData, context, onResult)
            Maswe0002Vector.SQLITE_PLAINTEXT         -> triggerSqliteLeak(appData, context, onResult)
            Maswe0002Vector.FILE_PROVIDER_ROOT_PATH  -> triggerFileProviderLeak(appData, context, onResult)
            Maswe0002Vector.EXTERNAL_STORAGE         -> triggerExternalStorageLeak(appData, context, onResult)
            Maswe0002Vector.WEBVIEW_DOM_STORAGE      -> triggerWebViewLeak(appData, context, onResult)
            Maswe0002Vector.CACHE_DIRECTORY          -> triggerCacheLeak(appData, context, onResult)
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 1: SHARED PREFERENCES PLAINTEXT LEAK
    // CWE-922: Insecure Storage of Sensitive Information
    // CWE-312: Cleartext Storage of Sensitive Information
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 1: SharedPreferences (CWE-922 / CWE-312)
     *
     * Mechanism: The Android SharedPreferences API writes key-value pairs to an XML file
     * at /data/data/<pkg>/shared_prefs/<name>.xml. MODE_PRIVATE prevents other apps from
     * directly accessing the file via the filesystem, but provides NO encryption.
     *
     * Why it fails:
     * 1. ROOT ATTACK: Any process with root privileges (`adb shell su`) can read the file.
     * 2. ADB BACKUP: `adb backup -noapk com.hasantuncay.mobsec` extracts the shared_prefs/
     *    directory as plaintext (when allowBackup=true in AndroidManifest).
     * 3. PHYSICAL EXTRACTION: On an unencrypted or unlocked device, forensic tools
     *    (Cellebrite, Magnet AXIOM) can extract the file from a disk image.
     * 4. CONTENT PROVIDER LEAK (Vector 4): The FileProvider can expose this file via a
     *    content:// URI to a malicious third-party app.
     *
     * ADB Verification Command:
     * adb shell run-as com.hasantuncay.mobsec cat shared_prefs/maswe0002_session.xml
     */
    private suspend fun triggerSharedPrefsLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        val prefs = context.getSharedPreferences("maswe0002_session", Context.MODE_PRIVATE)
        prefs.edit().apply {
            // CWE-922: Storing OAuth2 bearer token in plaintext XML
            putString("auth_token", appData.networkSession.oAuth2BearerToken)
            // CWE-922: Storing refresh token in plaintext
            putString("oauth_refresh", appData.networkSession.oAuth2RefreshToken)
            // CWE-922 + GDPR: Storing personally identifiable information without encryption
            putString("user_full_name", appData.gdprPii.directIdentifiers.fullName)
            putString("national_id", String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask()))
            putString("email", String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask()))
            // CWE-312 + PCI-DSS Violation: Storing plaintext password in SharedPreferences
            putString("user_password", appData.userContext.plainTextPasswordInHeap)
        }.apply() 

        val filePath = "${context.applicationInfo.dataDir}/shared_prefs/maswe0002_session.xml"
        
        Log.e(
            "VULN_0002_PREFS",
            """
            ⚠️ MASWE-0002 | Vector 1: SharedPreferences Plaintext Leak
            File: $filePath
            Verification: adb shell run-as com.hasantuncay.mobsec cat shared_prefs/maswe0002_session.xml
            """.trimIndent()
        )
        
        withContext(Dispatchers.Main) {
            onResult(filePath)
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 2: DATASTORE UNENCRYPTED
    // CWE-922: Insecure Storage of Sensitive Information
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 2: Jetpack DataStore — Unencrypted Preferences DataStore (CWE-922)
     *
     * Mechanism: Preferences DataStore serializes key-value pairs to a Protocol Buffers
     * binary file at /data/data/<pkg>/files/datastore/<name>.preferences_pb.
     *
     * Common Misconception — "Binary = Encrypted":
     * Protocol Buffers is a SERIALIZATION format, not an ENCRYPTION format.
     * The `.preferences_pb` file is binary, which makes it unreadable in a text editor,
     * but any tool that understands the protobuf wire format can decode it instantly.
     * Running `strings` on the file will reveal plaintext string values directly.
     *
     * The DataStore documentation explicitly states:
     * "DataStore does not offer encryption out-of-the-box."
     *
     * Why it fails:
     * 1. ROOT ATTACK: `adb shell run-as com.hasantuncay.mobsec strings files/datastore/maswe0002_store.preferences_pb`
     * 2. ADB BACKUP: Included in adb backup output by default.
     * 3. PROTOBUF DECODE: `protoc --decode_raw < maswe0002_store.preferences_pb`
     *
     * ADB Verification Command:
     * adb shell run-as com.hasantuncay.mobsec cat files/datastore/maswe0002_store.preferences_pb | strings
     */
    private suspend fun triggerDataStoreLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        val appContext = context.applicationContext
        
        withContext(Dispatchers.IO) {
            appContext.maswe0002DataStore.edit { prefs ->
                prefs[KEY_AUTH_TOKEN]    = appData.networkSession.oAuth2BearerToken
                prefs[KEY_OAUTH_REFRESH] = appData.networkSession.oAuth2RefreshToken
                prefs[KEY_FULL_NAME]   = appData.gdprPii.directIdentifiers.fullName
                prefs[KEY_NATIONAL_ID] = String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask())
                prefs[KEY_EMAIL]       = String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask())
            }

            val filePath = "${appContext.applicationInfo.dataDir}/files/datastore/maswe0002_store.preferences_pb"
            Log.e(
                "VULN_0002_DATASTORE",
                """
                ⚠️ MASWE-0002 | Vector 2: DataStore Unencrypted (Binary ≠ Encrypted!)
                File: $filePath
                IMPORTANT: .preferences_pb is Protocol Buffers binary, NOT encrypted!
                Verification: adb shell run-as com.hasantuncay.mobsec cat files/datastore/maswe0002_store.preferences_pb | strings
                """.trimIndent()
            )
            withContext(Dispatchers.Main) {
                onResult(filePath)
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 3: ROOM / SQLITE PLAINTEXT
    // CWE-922: Insecure Storage of Sensitive Information
    // CWE-200: Exposure of Sensitive Information to an Unauthorized Actor
    // ══════════════════════════════════════════════════════════════════════════

    @Entity(tableName = "sensitive_records")
    data class SensitiveRecord(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo(name = "pan")         val pan: String,
        @ColumnInfo(name = "cvv")         val cvv: String,
        @ColumnInfo(name = "pin_block")   val pinBlock: String,
        @ColumnInfo(name = "hipaa_mrn")   val hipaaMrn: String,
        @ColumnInfo(name = "icd10_code")  val icd10Code: String,
        @ColumnInfo(name = "national_id") val nationalId: String
    )

    @Dao
    interface SensitiveRecordDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(record: SensitiveRecord)
    }

    @Database(entities = [SensitiveRecord::class], version = 1, exportSchema = false)
    abstract class VulnerableDatabase : RoomDatabase() {
        abstract fun sensitiveRecordDao(): SensitiveRecordDao
    }

    /**
     * VULNERABLE VECTOR 3: Room Database Plaintext Leak
     * 
     * Mechanism: Room uses standard SQLite. SQLite databases store data as plaintext unless
     * explicitly encrypted (e.g., using SQLCipher). Furthermore, SQLite writes rollback journals
     * or WAL (Write-Ahead Log) files to disk which often contain unencrypted fragments.
     */
    private suspend fun triggerSqliteLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val db = Room.databaseBuilder(
                context,
                VulnerableDatabase::class.java,
                "maswe0002_vuln.db"
            ).build()

            db.sensitiveRecordDao().insert(
                SensitiveRecord(
                    pan       = appData.pciDss.cardholderData.primaryAccountNumber,
                    cvv       = appData.pciDss.sensitiveAuthenticationData.cardVerificationCode,
                    pinBlock  = appData.pciDss.sensitiveAuthenticationData.pinBlock,
                    hipaaMrn  = appData.hipaaPhi.medicalRecordNumber,
                    icd10Code = appData.hipaaPhi.icd10DiagnosisCode,
                    nationalId = String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask())
                )
            )

            val dbPath   = "${context.applicationInfo.dataDir}/databases/maswe0002_vuln.db"
            withContext(Dispatchers.Main) {
                onResult(dbPath)
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 4: FILEPROVIDER ROOT-PATH MISCONFIGURATION
    // CWE-284: Improper Access Control
    // CWE-22:  Path Traversal
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 4: FileProvider Root-Path Misconfiguration
     * 
     * Mechanism: <root-path> maps to the root directory (/) of the device filesystem. 
     * Even if we only mean to share a specific image, using <root-path> allows an attacker 
     * to traverse and request any file within the app's sandbox.
     */
    private suspend fun triggerFileProviderLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val prefs = context.getSharedPreferences("maswe0002_fileprovider", Context.MODE_PRIVATE)
            
            // CRITICAL FIX: Use commit() to ensure file is on disk before FileProvider Intent is fired
            prefs.edit().apply {
                putString("auth_token", appData.networkSession.oAuth2BearerToken)
            }.commit() 

            val file = File(context.applicationInfo.dataDir, "shared_prefs/maswe0002_fileprovider.xml")
            if (!file.exists()) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error: File was not created.", Toast.LENGTH_SHORT).show()
                }
                return@withContext
            }

            try {
                val uri: Uri = FileProvider.getUriForFile(
                    context,
                    "${context.packageName}.fileprovider",
                    file
                )

                val exploitIntent = android.content.Intent().apply {
                    setClassName("com.hasantuncay.mobsec.attacker", "com.hasantuncay.mobsec.attacker.AttackerMainActivity")
                    data = uri
                    addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                }

                try {
                    context.startActivity(exploitIntent)
                } catch (e: android.content.ActivityNotFoundException) {
                    Log.w("VULN_0002_FILEPROVIDER", "Attacker app not installed.")
                }

                withContext(Dispatchers.Main) {
                    onResult(uri.toString())
                }
            } catch (e: IllegalArgumentException) {
                Log.e("VULN_0002_FILEPROVIDER", "FileProvider error: ${e.message}")
                withContext(Dispatchers.Main) {
                    onResult(null)
                }
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 5: EXTERNAL STORAGE SENSITIVE DATA LEAK
    // CWE-922: Insecure Storage of Sensitive Information
    // CWE-732: Incorrect Permission Assignment for Critical Resource
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 5: External Storage Leak
     *
     * Mechanism: On devices running Android 9 (API 28) or lower, files written to 
     * `getExternalFilesDir()` are world-readable if the malicious app holds the 
     * `READ_EXTERNAL_STORAGE` permission.
     */
    private suspend fun triggerExternalStorageLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            val externalDir = context.getExternalFilesDir(null)
            if (externalDir == null) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "External storage not mounted", Toast.LENGTH_SHORT).show()
                }
                return@withContext
            }

            val sensitiveFile = File(externalDir, "maswe0002_external_leak.json")
            
            // Fix Memory Amplification: Stream bytes directly without allocating huge immutable Strings
            FileOutputStream(sensitiveFile).use { out ->
                out.write("{\n  \"full_name\": \"${appData.gdprPii.directIdentifiers.fullName}\",\n".toByteArray())
                
                out.write("  \"email\": \"".toByteArray())
                val emailBytes = appData.gdprPii.directIdentifiers.personalEmail.getDataToMask().map { it.code.toByte() }.toByteArray()
                out.write(emailBytes)
                
                out.write("\",\n  \"national_id\": \"".toByteArray())
                val natIdBytes = appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask().map { it.code.toByte() }.toByteArray()
                out.write(natIdBytes)
                
                out.write("\"\n}".toByteArray())
            }
            
            Log.e(
                "VULN_0002_EXTERNAL",
                """
                ⚠️ MASWE-0002 | Vector 5: External Storage Sensitive Data Leak
                File: ${sensitiveFile.absolutePath}
                API < 29 Attack: Any app with READ_EXTERNAL_STORAGE can read this.
                """.trimIndent()
            )

            withContext(Dispatchers.Main) {
                onResult(sensitiveFile.absolutePath)
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 6: WEBVIEW DOM STORAGE LEAK
    // CWE-312: Cleartext Storage of Sensitive Information
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 6: WebView DOM Storage
     *
     * Mechanism: Enabling `domStorageEnabled` allows web pages to write to `localStorage`.
     * This data is physically persisted to the device filesystem as a LevelDB database
     * under `/app_webview/Default/Local Storage/leveldb/`. If tokens are stored here,
     * they are accessible to root or backups.
     */
    private suspend fun triggerWebViewLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.Main) {
            try {
                val webView = WebView(context)
                webView.settings.javaScriptEnabled = true
                // VULNERABILITY: Enabling DOM Storage
                webView.settings.domStorageEnabled = true
                
                val token = appData.networkSession.oAuth2BearerToken
                val jsCode = "localStorage.setItem('auth_token', '$token');"
                
                webView.evaluateJavascript(jsCode) {
                    val path = "${context.applicationInfo.dataDir}/app_webview/Default/Local Storage/leveldb/"
                    onResult(path)
                }
            } catch (e: Exception) {
                onResult("WebView Error: ${e.message}")
            }
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // VECTOR 7: TEMPORARY CACHE DIRECTORY LEAK
    // CWE-200: Exposure of Sensitive Information to an Unauthorized Actor
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * VULNERABLE VECTOR 7: Temporary Cache Directory Leak
     *
     * Mechanism: Using `context.cacheDir` for sensitive files (like PDF statements) is dangerous.
     * The OS does NOT immediately delete cache files. They persist indefinitely until the
     * device runs out of storage and requests cache clearing. If `deleteOnExit()` is not called,
     * the sensitive file remains on disk forever.
     */
    private suspend fun triggerCacheLeak(
        appData: MasterclassData,
        context: Context,
        onResult: (filePath: String?) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            // VULNERABILITY: Writing to cacheDir and never deleting it
            val tempFile = File.createTempFile("ekstre_", ".pdf", context.cacheDir)
            
            FileOutputStream(tempFile).use { out ->
                val pan = appData.pciDss.cardholderData.primaryAccountNumber
                out.write("PDF HEADER... PAN: $pan".toByteArray())
            }

            // Notice we do NOT call tempFile.deleteOnExit()
            withContext(Dispatchers.Main) {
                onResult(tempFile.absolutePath)
            }
        }
    }
}
