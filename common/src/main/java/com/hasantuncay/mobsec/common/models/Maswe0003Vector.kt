package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

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
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INSECURE_STORAGE_LOCATION(
        titleVulnRes = R.string.maswe_0003_vector_insecure_storage_vuln,
        msgVulnRes = R.string.maswe_0003_msg_insecure_storage_vuln,
        icon = Icons.Default.Storage
    ),

    HARDCODED_KEY(
        titleVulnRes = R.string.maswe_0003_vector_hardcoded_key_vuln,
        msgVulnRes = R.string.maswe_0003_msg_hardcoded_key_vuln,
        icon = Icons.Default.Key
    ),

    INSECURE_KEY_IMPORT(
        titleVulnRes = R.string.maswe_0003_vector_insecure_key_import_vuln,
        msgVulnRes = R.string.maswe_0003_msg_insecure_key_import_vuln,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0003"
    override val screenTitleVulnRes = R.string.maswe_0003_vuln_title
    override val screenDescVulnRes = R.string.maswe_0003_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0003_vuln_vectors_title
}
