package com.hasantuncay.mobsec.maswe0002.common

import com.hasantuncay.mobsec.maswe0002.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Vector
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Sync
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

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
enum class Maswe0002Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    EXTERNAL_STORAGE(
        titleRes = R.string.maswe_0002_vector_external_storage_secure,
        msgRes = R.string.maswe_0002_msg_external_storage_secure,
        icon = Icons.Default.FolderShared
    ),

    HARDCODED_ENCRYPTION_KEY(
        titleRes = R.string.maswe_0002_vector_hardcoded_key_secure,
        msgRes = R.string.maswe_0002_msg_hardcoded_key_secure,
        icon = Icons.Default.Key
    ),

    ENCRYPTION_KEY_ON_FILESYSTEM(
        titleRes = R.string.maswe_0002_vector_key_on_fs_secure,
        msgRes = R.string.maswe_0002_msg_key_on_fs_secure,
        icon = Icons.Default.DataObject
    ),

    INSUFFICIENT_ENCRYPTION(
        titleRes = R.string.maswe_0002_vector_weak_encryption_secure,
        msgRes = R.string.maswe_0002_msg_weak_encryption_secure,
        icon = Icons.Default.NoEncryption
    ),

    REUSE_OF_ENCRYPTION_KEY(
        titleRes = R.string.maswe_0002_vector_key_reuse_secure,
        msgRes = R.string.maswe_0002_msg_key_reuse_secure,
        icon = Icons.Default.Sync
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0002",
            titleRes = CommonR.string.maswe_0002_secure_title,
            descRes = CommonR.string.maswe_0002_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0002_secure_vectors_title
        )
    }
}
