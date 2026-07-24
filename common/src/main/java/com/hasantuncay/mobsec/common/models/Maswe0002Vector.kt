package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * Defines the five vulnerability attack vectors demonstrated in the MASWE-0002 module.
 *
 * MASWE-0002: Sensitive Data Stored With Insufficient Access Restrictions in Internal Locations
 * MASVS:      MASVS-STORAGE-2
 *
 * Each enum entry represents one distinct insecure storage mechanism. The vulnerable app
 * triggers the insecure write; the secure app applies the appropriate mitigation.
 *
 * Standard References:
 *  - OWASP MASWE-0002: https://mas.owasp.org/MASWE/MASVS-STORAGE/MASWE-0002/
 *  - MASVS-STORAGE-2:  https://mas.owasp.org/MASVS/05-MASVS-STORAGE/
 *  - Android Security Tips (Internal Storage): https://developer.android.com/privacy-and-security/security-tips#internal-storage
 */
enum class Maswe0002Vector(
    @StringRes val titleVulnRes: Int,
    @StringRes val titleSecureRes: Int,
    @StringRes val msgVulnRes: Int,
    @StringRes val msgSecureRes: Int,
    val icon: ImageVector
) {
    /**
     * VECTOR 1: SharedPreferences — Plaintext Key-Value Storage
     *
     * CWE-922: Insecure Storage of Sensitive Information
     * CWE-312: Cleartext Storage of Sensitive Information
     *
     * Attack: Root access or ADB backup (`adb backup -noapk com.hasantuncay.mobsec`) exposes
     * the XML file containing raw auth tokens, passwords, and session identifiers in plaintext.
     */
    SHARED_PREFS_PLAINTEXT(
        titleVulnRes = R.string.maswe_0002_vector_shared_prefs_vuln,
        titleSecureRes = R.string.maswe_0002_vector_shared_prefs_secure,
        msgVulnRes = R.string.maswe_0002_msg_shared_prefs_vuln,
        msgSecureRes = R.string.maswe_0002_msg_shared_prefs_secure,
        icon = Icons.Default.Key
    ),

    /**
     * VECTOR 2: Jetpack DataStore — Unencrypted Preferences DataStore
     *
     * CWE-922: Insecure Storage of Sensitive Information
     *
     * Common Misconception: DataStore stores data as Protocol Buffers (binary format).
     * Developers often assume "binary = encrypted". This is FALSE.
     * The `.preferences_pb` file is NOT encrypted; its contents can be extracted via
     * `strings` command or a protobuf parser on a rooted device or from an ADB backup.
     *
     * Attack Path: `adb shell run-as com.hasantuncay.mobsec cat files/datastore/maswe0002_store.preferences_pb | strings`
     */
    DATASTORE_UNENCRYPTED(
        titleVulnRes = R.string.maswe_0002_vector_datastore_vuln,
        titleSecureRes = R.string.maswe_0002_vector_datastore_secure,
        msgVulnRes = R.string.maswe_0002_msg_datastore_vuln,
        msgSecureRes = R.string.maswe_0002_msg_datastore_secure,
        icon = Icons.Default.DataObject
    ),

    /**
     * VECTOR 3: Room Database — Plaintext SQLite + WAL Journal Exposure
     *
     * CWE-922: Insecure Storage of Sensitive Information
     * CWE-200: Exposure of Sensitive Information to an Unauthorized Actor
     *
     * Double Exposure: Not only is the main `.db` file plaintext, but SQLite's
     * Write-Ahead Log (WAL) mode creates a `.db-wal` journal file that retains
     * the most recent uncommitted writes. Both files expose sensitive data.
     *
     * Attack Path: `adb shell run-as com.hasantuncay.mobsec sqlite3 databases/maswe0002_vuln.db "SELECT * FROM sensitive_records;"`
     */
    SQLITE_PLAINTEXT(
        titleVulnRes = R.string.maswe_0002_vector_sqlite_vuln,
        titleSecureRes = R.string.maswe_0002_vector_sqlite_secure,
        msgVulnRes = R.string.maswe_0002_msg_sqlite_vuln,
        msgSecureRes = R.string.maswe_0002_msg_sqlite_secure,
        icon = Icons.Default.Storage
    ),

    /**
     * VECTOR 4: FileProvider — Overly Broad Path Configuration (<root-path>)
     *
     * CWE-284: Improper Access Control
     * CWE-22:  Improper Limitation of a Pathname to a Restricted Directory (Path Traversal)
     *
     * The FileProvider is registered in AndroidManifest.xml with a `<root-path>` element
     * pointing to `/`. This grants any recipient of a content:// URI the ability to request
     * a file descriptor for ANY file on the device the app has permission to read —
     * including SharedPreferences, databases, and native libraries.
     *
     * Real CVE Analog: HackerOne Report #876192 — FileProvider root-path + native library
     * overwrite leads to Arbitrary Code Execution (ACE).
     *
     * Demo: This vector writes SharedPrefs data and then generates the content:// URI
     * that a malicious second app could use to read it. Logged to Logcat and shown on screen.
     */
    FILE_PROVIDER_ROOT_PATH(
        titleVulnRes = R.string.maswe_0002_vector_file_provider_vuln,
        titleSecureRes = R.string.maswe_0002_vector_file_provider_secure,
        msgVulnRes = R.string.maswe_0002_msg_file_provider_vuln,
        msgSecureRes = R.string.maswe_0002_msg_file_provider_secure,
        icon = Icons.Default.FolderSpecial
    ),

    /**
     * VECTOR 5: External Storage — App-Specific External Directory
     *
     * CWE-922: Insecure Storage of Sensitive Information
     * CWE-732: Incorrect Permission Assignment for Critical Resource
     *
     * `getExternalFilesDir()` writes to `/sdcard/Android/data/<pkg>/files/`.
     * On Android API < 29 (Android 9), any app holding READ_EXTERNAL_STORAGE permission
     * can directly access this path — no root required.
     * Even on API 29+ (Scoped Storage), the directory is unencrypted and accessible via
     * physical USB access, MTP, or on rooted devices.
     *
     * Sensitive data (PII, PCI-DSS) must NEVER be written to external storage.
     * Reference: Android Security Tips — https://developer.android.com/privacy-and-security/security-tips#external-storage
     */
    EXTERNAL_STORAGE(
        titleVulnRes = R.string.maswe_0002_vector_external_storage_vuln,
        titleSecureRes = R.string.maswe_0002_vector_external_storage_secure,
        msgVulnRes = R.string.maswe_0002_msg_external_storage_vuln,
        msgSecureRes = R.string.maswe_0002_msg_external_storage_secure,
        icon = Icons.Default.FolderShared
    ),

    /**
     * VECTOR 6: WebView DOM Storage (CWE-312)
     *
     * In hybrid apps or OAuth flows, WebView `localStorage` is written unencrypted to
     * `/data/data/<pkg>/app_webview/Default/Local Storage/leveldb/`.
     * Attackers with root or ADB can extract session tokens easily.
     */
    WEBVIEW_DOM_STORAGE(
        titleVulnRes = R.string.maswe_0002_vector_webview_vuln,
        titleSecureRes = R.string.maswe_0002_vector_webview_secure,
        msgVulnRes = R.string.maswe_0002_msg_webview_vuln,
        msgSecureRes = R.string.maswe_0002_msg_webview_secure,
        icon = Icons.Default.DataObject
    ),

    /**
     * VECTOR 7: Temporary Cache Directory (CWE-200)
     *
     * Writing sensitive files (like PDF statements) to `cacheDir` and assuming the OS will
     * clean them up immediately is false. They linger indefinitely until storage is low.
     */
    CACHE_DIRECTORY(
        titleVulnRes = R.string.maswe_0002_vector_cache_vuln,
        titleSecureRes = R.string.maswe_0002_vector_cache_secure,
        msgVulnRes = R.string.maswe_0002_msg_cache_vuln,
        msgSecureRes = R.string.maswe_0002_msg_cache_secure,
        icon = Icons.Default.FolderSpecial
    )
}
