package com.hasantuncay.mobsec.maswe0003.common

import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import com.hasantuncay.mobsec.maswe0003.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the vulnerability attack vectors demonstrated in the MASWE-0003 module.
 *
 * MASWE-0003: Cryptographic Keys Stored Outside of Platform Keystore
 * MASVS:      MASVS-STORAGE-1, MASVS-CRYPTO-1
 *
 * Modes of Introduction (from MASWE repo):
 * - Insecure Storage Locations: Keys stored in regular config files, prefs, or app data dirs
 * - Hardcoded Cryptographic Keys: Keys embedded directly in app code or resources
 * - Insecure Key Import: Importing keys in plaintext instead of using secure wrapped import
 */
enum class Maswe0003Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INSECURE_STORAGE_LOCATION(
        titleRes = R.string.maswe_0003_vector_insecure_storage_vuln,
        msgRes = R.string.maswe_0003_msg_insecure_storage_vuln,
        icon = Icons.Default.Storage
    ),

    HARDCODED_KEY(
        titleRes = R.string.maswe_0003_vector_hardcoded_key_vuln,
        msgRes = R.string.maswe_0003_msg_hardcoded_key_vuln,
        icon = Icons.Default.Key
    ),

    INSECURE_KEY_IMPORT(
        titleRes = R.string.maswe_0003_vector_insecure_key_import_vuln,
        msgRes = R.string.maswe_0003_msg_insecure_key_import_vuln,
        icon = Icons.Default.Lock
    );

    override fun getAdbCommand(resultPath: String?): String {
        val pkg = "com.hasantuncay.mobsec"
        return when (this) {
            INSECURE_STORAGE_LOCATION -> "adb shell run-as $pkg \\\n  cat shared_prefs/crypto_key.xml"
            HARDCODED_KEY -> "# Check the decompiled APK source code for hardcoded AES key"
            INSECURE_KEY_IMPORT -> "adb logcat -s MASWE_0003_KEY_IMPORT"
        }
    }

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0003",
            titleRes = CommonR.string.maswe_0003_vuln_title,
            descRes = CommonR.string.maswe_0003_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0003_vuln_vectors_title
        )
    }
}
