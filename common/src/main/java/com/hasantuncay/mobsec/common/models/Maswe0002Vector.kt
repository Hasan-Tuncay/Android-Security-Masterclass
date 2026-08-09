package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Sync
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * Defines the vulnerability attack vectors demonstrated in the MASWE-0002 module.
 *
 * MASWE-0002: Sensitive Data Stored Unencrypted Outside of Private Storage
 * MASVS:      MASVS-STORAGE-2
 *
 * Modes of Introduction (from MASWE repo):
 * - Data Stored Unencrypted: Sensitive data written to shared/external storage unencrypted
 * - Hardcoded Encryption Key: External storage data encrypted with hardcoded key
 * - Encryption Key Stored on Filesystem: Key stored alongside encrypted data externally
 * - Insufficient Encryption: Weak algorithm or config used for external storage encryption
 * - Reuse of Encryption Key: Same key shared between devices enabling data cloning
 */
enum class Maswe0002Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    EXTERNAL_STORAGE(
        titleVulnRes = R.string.maswe_0002_vector_external_storage_vuln,
        msgVulnRes = R.string.maswe_0002_msg_external_storage_vuln,
        icon = Icons.Default.FolderShared
    ),

    HARDCODED_ENCRYPTION_KEY(
        titleVulnRes = R.string.maswe_0002_vector_hardcoded_key_vuln,
        msgVulnRes = R.string.maswe_0002_msg_hardcoded_key_vuln,
        icon = Icons.Default.Key
    ),

    ENCRYPTION_KEY_ON_FILESYSTEM(
        titleVulnRes = R.string.maswe_0002_vector_key_on_fs_vuln,
        msgVulnRes = R.string.maswe_0002_msg_key_on_fs_vuln,
        icon = Icons.Default.DataObject
    ),

    INSUFFICIENT_ENCRYPTION(
        titleVulnRes = R.string.maswe_0002_vector_weak_encryption_vuln,
        msgVulnRes = R.string.maswe_0002_msg_weak_encryption_vuln,
        icon = Icons.Default.NoEncryption
    ),

    REUSE_OF_ENCRYPTION_KEY(
        titleVulnRes = R.string.maswe_0002_vector_key_reuse_vuln,
        msgVulnRes = R.string.maswe_0002_msg_key_reuse_vuln,
        icon = Icons.Default.Sync
    );

    override val masweId = "MASWE-0002"
    override val screenTitleVulnRes = R.string.maswe_0002_vuln_title
    override val screenDescVulnRes = R.string.maswe_0002_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0002_vuln_vectors_title
}
