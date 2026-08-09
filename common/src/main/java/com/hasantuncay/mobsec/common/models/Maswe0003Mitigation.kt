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
enum class Maswe0003Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    INSECURE_STORAGE_LOCATION(
        titleSecureRes = R.string.maswe_0003_vector_insecure_storage_secure,
        msgSecureRes = R.string.maswe_0003_msg_insecure_storage_secure,
        icon = Icons.Default.Storage
    ),

    HARDCODED_KEY(
        titleSecureRes = R.string.maswe_0003_vector_hardcoded_key_secure,
        msgSecureRes = R.string.maswe_0003_msg_hardcoded_key_secure,
        icon = Icons.Default.Key
    ),

    INSECURE_KEY_IMPORT(
        titleSecureRes = R.string.maswe_0003_vector_insecure_key_import_secure,
        msgSecureRes = R.string.maswe_0003_msg_insecure_key_import_secure,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0003"
    override val screenTitleSecureRes = R.string.maswe_0003_secure_title
    override val screenDescSecureRes = R.string.maswe_0003_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0003_secure_vectors_title
}
