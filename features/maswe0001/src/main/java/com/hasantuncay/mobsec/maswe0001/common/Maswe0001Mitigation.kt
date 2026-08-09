package com.hasantuncay.mobsec.maswe0001.common

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the private storage vulnerability attack vectors demonstrated in the MASWE-0001 module.
 *
 * MASWE-0001: Sensitive Data Stored Unencrypted in Private Storage
 * MASVS:      MASVS-STORAGE-1
 */
enum class Maswe0001Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SHARED_PREFS_PLAINTEXT(
        titleRes = R.string.maswe_0001_vector_shared_prefs_secure,
        msgRes = R.string.maswe_0001_msg_shared_prefs_secure,
        icon = Icons.Default.Key
    ),

    DATASTORE_UNENCRYPTED(
        titleRes = R.string.maswe_0001_vector_datastore_secure,
        msgRes = R.string.maswe_0001_msg_datastore_secure,
        icon = Icons.Default.DataObject
    ),

    SQLITE_PLAINTEXT(
        titleRes = R.string.maswe_0001_vector_sqlite_secure,
        msgRes = R.string.maswe_0001_msg_sqlite_secure,
        icon = Icons.Default.Storage
    ),

    FILE_PROVIDER_ROOT_PATH(
        titleRes = R.string.maswe_0001_vector_file_provider_secure,
        msgRes = R.string.maswe_0001_msg_file_provider_secure,
        icon = Icons.Default.FolderSpecial
    ),

    WEBVIEW_DOM_STORAGE(
        titleRes = R.string.maswe_0001_vector_webview_secure,
        msgRes = R.string.maswe_0001_msg_webview_secure,
        icon = Icons.Default.DataObject
    ),

    CACHE_DIRECTORY(
        titleRes = R.string.maswe_0001_vector_cache_secure,
        msgRes = R.string.maswe_0001_msg_cache_secure,
        icon = Icons.Default.FolderSpecial
    ),

    PATH_TRAVERSAL(
        titleRes = R.string.maswe_0001_vector_path_traversal_secure,
        msgRes = R.string.maswe_0001_msg_path_traversal_secure,
        icon = Icons.Default.FolderSpecial
    ),

    THIRD_PARTY_SDK_LEAK(
        titleRes = R.string.maswe_0001_vector_sdk_leak_secure,
        msgRes = R.string.maswe_0001_msg_sdk_leak_secure,
        icon = Icons.Default.DataObject
    );

    override fun getAdbCommand(resultPath: String?): String {
        val pkg = "com.hasantuncay.mobsec"
        return when (this) {
            SHARED_PREFS_PLAINTEXT -> "adb shell run-as $pkg \\\n  cat shared_prefs/maswe0001_secure_session.xml"
            DATASTORE_UNENCRYPTED -> "adb shell run-as $pkg \\\n  hexdump -C files/datastore/maswe0001_secure_store.preferences_pb"
            SQLITE_PLAINTEXT -> "adb shell run-as $pkg sqlite3 \\\n  databases/maswe0001_secure.db \\\n  \"SELECT * FROM sensitive_records;\""
            FILE_PROVIDER_ROOT_PATH -> if (resultPath != null) "adb shell content read \\\n  --uri \"$resultPath\"" else "adb logcat -s SECURE_0001_FILEPROVIDER"
            WEBVIEW_DOM_STORAGE -> "adb logcat -d -s SECURE_0001_WEBVIEW"
            CACHE_DIRECTORY -> if (resultPath != null) "adb shell run-as $pkg \\\n  cat \"${resultPath.substringAfter(pkg + "/")}\"" else "adb shell run-as $pkg ls -la cache/"
            PATH_TRAVERSAL -> "adb shell content read \\\n  --uri \"$resultPath\""
            THIRD_PARTY_SDK_LEAK -> "adb logcat -d -s SECURE_0001_SDK"
        }
    }

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0001",
            titleRes = CommonR.string.maswe_0001_secure_title,
            descRes = CommonR.string.maswe_0001_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0001_secure_vectors_title
        )
    }
}
