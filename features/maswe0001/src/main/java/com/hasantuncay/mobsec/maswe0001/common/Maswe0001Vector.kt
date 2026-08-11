package com.hasantuncay.mobsec.maswe0001.common

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the private storage vulnerability attack vectors demonstrated in the MASWE-0001 module.
 *
 * MASWE-0001: Sensitive Data Stored Unencrypted in Private Storage
 * MASVS:      MASVS-STORAGE-1, MASVS-STORAGE-2, MASVS-CRYPTO-2
 */
enum class Maswe0001Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DATA_STORED_UNENCRYPTED(
        titleRes = R.string.maswe_0001_vector_1_vuln,
        msgRes = R.string.maswe_0001_msg_1_vuln,
        icon = Icons.Default.DataObject
    ),

    HARDCODED_ENCRYPTION_KEY(
        titleRes = R.string.maswe_0001_vector_2_vuln,
        msgRes = R.string.maswe_0001_msg_2_vuln,
        icon = Icons.Default.Key
    ),

    KEY_STORED_ON_FILESYSTEM(
        titleRes = R.string.maswe_0001_vector_3_vuln,
        msgRes = R.string.maswe_0001_msg_3_vuln,
        icon = Icons.Default.FolderShared
    ),

    INSUFFICIENT_ENCRYPTION(
        titleRes = R.string.maswe_0001_vector_4_vuln,
        msgRes = R.string.maswe_0001_msg_4_vuln,
        icon = Icons.Default.LockOpen
    ),

    INSUFFICIENT_ACCESS_RESTRICTIONS(
        titleRes = R.string.maswe_0001_vector_5_vuln,
        msgRes = R.string.maswe_0001_msg_5_vuln,
        icon = Icons.Default.FolderSpecial
    ),

    DATA_NOT_REMOVED_AFTER_USE(
        titleRes = R.string.maswe_0001_vector_6_vuln,
        msgRes = R.string.maswe_0001_msg_6_vuln,
        icon = Icons.Default.Storage
    );

    override fun getAdbCommand(resultPath: String?): String {
        val pkg = "com.hasantuncay.mobsec"
        return when (this) {
            DATA_STORED_UNENCRYPTED -> "adb shell run-as $pkg \\\n  cat files/datastore/maswe0001_v1.preferences_pb | strings"
            HARDCODED_ENCRYPTION_KEY -> "# Check the decompiled APK source code for HARDCODED_KEY\n# adb shell run-as $pkg cat files/maswe0001_v2.enc"
            KEY_STORED_ON_FILESYSTEM -> "adb shell run-as $pkg \\\n  cat shared_prefs/maswe0001_v3_keys.xml"
            INSUFFICIENT_ENCRYPTION -> "adb shell run-as $pkg \\\n  hexdump -C files/maswe0001_v4.enc\n# Check source for AES/ECB/PKCS5Padding usage."
            INSUFFICIENT_ACCESS_RESTRICTIONS -> if (resultPath != null) "adb shell content read \\\n  --uri \"$resultPath\"" else "adb logcat -s VULN_0001_FILEPROVIDER"
            DATA_NOT_REMOVED_AFTER_USE -> if (resultPath != null) "adb shell run-as $pkg \\\n  cat \"${resultPath.substringAfter(pkg + "/")}\"" else "adb shell run-as $pkg ls -la cache/"
        }
    }

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0001",
            titleRes = R.string.maswe_0001_vuln_title,
            descRes = R.string.maswe_0001_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0001_vuln_vectors_title
        )
    }
}
