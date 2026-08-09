package com.hasantuncay.mobsec.common.models.storage

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the private storage vulnerability attack vectors demonstrated in the MASWE-0001 module.
 *
 * MASWE-0001: Sensitive Data Stored Unencrypted in Private Storage
 * MASVS:      MASVS-STORAGE-1
 */
enum class Maswe0001Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SHARED_PREFS_PLAINTEXT(
        titleRes = R.string.maswe_0001_vector_shared_prefs_vuln,
        msgRes = R.string.maswe_0001_msg_shared_prefs_vuln,
        icon = Icons.Default.Key
    ),

    DATASTORE_UNENCRYPTED(
        titleRes = R.string.maswe_0001_vector_datastore_vuln,
        msgRes = R.string.maswe_0001_msg_datastore_vuln,
        icon = Icons.Default.DataObject
    ),

    SQLITE_PLAINTEXT(
        titleRes = R.string.maswe_0001_vector_sqlite_vuln,
        msgRes = R.string.maswe_0001_msg_sqlite_vuln,
        icon = Icons.Default.Storage
    ),

    FILE_PROVIDER_ROOT_PATH(
        titleRes = R.string.maswe_0001_vector_file_provider_vuln,
        msgRes = R.string.maswe_0001_msg_file_provider_vuln,
        icon = Icons.Default.FolderSpecial
    ),

    WEBVIEW_DOM_STORAGE(
        titleRes = R.string.maswe_0001_vector_webview_vuln,
        msgRes = R.string.maswe_0001_msg_webview_vuln,
        icon = Icons.Default.DataObject
    ),

    CACHE_DIRECTORY(
        titleRes = R.string.maswe_0001_vector_cache_vuln,
        msgRes = R.string.maswe_0001_msg_cache_vuln,
        icon = Icons.Default.FolderSpecial
    ),

    PATH_TRAVERSAL(
        titleRes = R.string.maswe_0001_vector_path_traversal_vuln,
        msgRes = R.string.maswe_0001_msg_path_traversal_vuln,
        icon = Icons.Default.FolderSpecial
    ),

    THIRD_PARTY_SDK_LEAK(
        titleRes = R.string.maswe_0001_vector_sdk_leak_vuln,
        msgRes = R.string.maswe_0001_msg_sdk_leak_vuln,
        icon = Icons.Default.DataObject
    );

    override fun getAdbCommand(resultPath: String?): String {
        val pkg = "com.hasantuncay.mobsec"
        return when (this) {
            SHARED_PREFS_PLAINTEXT -> "adb shell run-as $pkg \\\n  cat shared_prefs/maswe0001_session.xml"
            DATASTORE_UNENCRYPTED -> "# Option A — strings extraction:\nadb shell run-as $pkg \\\n  cat files/datastore/maswe0001_store.preferences_pb | strings\n\n# Option B — raw hex dump:\nadb shell run-as $pkg \\\n  hexdump -C files/datastore/maswe0001_store.preferences_pb"
            SQLITE_PLAINTEXT -> "# Main database:\nadb shell run-as $pkg sqlite3 \\\n  databases/maswe0001_vuln.db \\\n  \"SELECT * FROM sensitive_records;\"\n\n# WAL journal (also contains plaintext):\nadb shell run-as $pkg \\\n  strings databases/maswe0001_vuln.db-wal"
            FILE_PROVIDER_ROOT_PATH -> if (resultPath != null) "adb shell content read \\\n  --uri \"$resultPath\"" else "adb logcat -s VULN_0001_FILEPROVIDER"
            WEBVIEW_DOM_STORAGE -> "# DOM Storage is written to LevelDB inside app_webview:\nadb shell run-as $pkg \\\n  cat \"app_webview/Default/Local Storage/leveldb/LOG\"\n\n# Requires root to dump full LevelDB contents, or ADB backup."
            CACHE_DIRECTORY -> if (resultPath != null) "adb shell run-as $pkg \\\n  cat \"${resultPath.substringAfter(pkg + "/")}\"" else "adb shell run-as $pkg ls -la cache/"
            PATH_TRAVERSAL -> "# Attackers can exploit the exported provider by appending ../\nadb shell content read \\\n  --uri \"$resultPath\""
            THIRD_PARTY_SDK_LEAK -> "# The SDK created an unencrypted SQLite DB in the app sandbox!\nadb shell run-as $pkg sqlite3 \\\n  databases/analytics_shadow.db \\\n  \"SELECT * FROM events;\""
        }
    }

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0001",
            titleRes = R.string.maswe_0001_vuln_title,
            descRes = R.string.maswe_0001_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0001_vuln_vectors_title
        )
    }
}
