package com.hasantuncay.mobsec.maswe0001.common

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the private storage vulnerability attack vectors demonstrated in the MASWE-0001 module.
 *
 * MASWE-0001: Sensitive Data Stored Unencrypted in Private Storage
 * MASVS:      MASVS-STORAGE-1, MASVS-STORAGE-2, MASVS-CRYPTO-2
 */
enum class Maswe0001Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DATA_STORED_SECURELY(
        titleRes = R.string.maswe_0001_vector_1_secure,
        msgRes = R.string.maswe_0001_msg_1_secure,
        icon = Icons.Default.DataObject
    ),

    KEY_IN_KEYSTORE(
        titleRes = R.string.maswe_0001_vector_2_secure,
        msgRes = R.string.maswe_0001_msg_2_secure,
        icon = Icons.Default.Key
    ),

    ENVELOPE_ENCRYPTION(
        titleRes = R.string.maswe_0001_vector_3_secure,
        msgRes = R.string.maswe_0001_msg_3_secure,
        icon = Icons.Default.FolderShared
    ),

    STRONG_ENCRYPTION(
        titleRes = R.string.maswe_0001_vector_4_secure,
        msgRes = R.string.maswe_0001_msg_4_secure,
        icon = Icons.Default.Lock
    ),

    PROPER_ACCESS_RESTRICTIONS(
        titleRes = R.string.maswe_0001_vector_5_secure,
        msgRes = R.string.maswe_0001_msg_5_secure,
        icon = Icons.Default.FolderSpecial
    ),

    DATA_REMOVED_AFTER_USE(
        titleRes = R.string.maswe_0001_vector_6_secure,
        msgRes = R.string.maswe_0001_msg_6_secure,
        icon = Icons.Default.Storage
    );

    override fun getAdbCommand(resultPath: String?): String {
        val pkg = "com.hasantuncay.mobsec"
        return when (this) {
            DATA_STORED_SECURELY -> "adb shell run-as $pkg \\\n  hexdump -C files/datastore/maswe0001_v1_secure.preferences_pb"
            KEY_IN_KEYSTORE -> "adb shell run-as $pkg \\\n  hexdump -C files/maswe0001_v2_secure.enc"
            ENVELOPE_ENCRYPTION -> "adb shell run-as $pkg \\\n  cat shared_prefs/maswe0001_v3_secure_keys.xml"
            STRONG_ENCRYPTION -> "adb shell run-as $pkg \\\n  hexdump -C files/maswe0001_v4_secure.enc"
            PROPER_ACCESS_RESTRICTIONS -> if (resultPath != null) "adb shell content read \\\n  --uri \"$resultPath\"" else "adb logcat -s SECURE_0001_FILEPROVIDER"
            DATA_REMOVED_AFTER_USE -> if (resultPath != null) "adb shell run-as $pkg \\\n  ls -la \"${resultPath.substringAfter(pkg + "/")}\"" else "adb shell run-as $pkg ls -la cache/"
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
