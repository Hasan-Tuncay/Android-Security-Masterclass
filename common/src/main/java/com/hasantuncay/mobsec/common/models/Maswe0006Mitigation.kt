package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.DeviceUnknown
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * Defines the vulnerability attack vectors demonstrated in the MASWE-0006 module.
 *
 * MASWE-0006: Sensitive Data Not Excluded From Backup
 * MASVS:      MASVS-STORAGE-2
 *
 * Modes of Introduction (from MASWE repo):
 * - Automatic System Backups: Default cloud backup includes app data without exclusion rules
 * - Local Backups: Sensitive data included in ADB/iTunes local backups, often unencrypted
 * - Device-To-Device Transfer: Data included in migrations (iCloud, Google migration tools)
 * - Sensitive Data Unencrypted in Backups: Data in backed-up locations without extra encryption
 */
enum class Maswe0006Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    AUTOMATIC_SYSTEM_BACKUP(
        titleSecureRes = R.string.maswe_0006_vector_auto_backup_secure,
        msgSecureRes = R.string.maswe_0006_msg_auto_backup_secure,
        icon = Icons.Default.CloudOff
    ),

    LOCAL_BACKUP(
        titleSecureRes = R.string.maswe_0006_vector_local_backup_secure,
        msgSecureRes = R.string.maswe_0006_msg_local_backup_secure,
        icon = Icons.Default.FolderOpen
    ),

    DEVICE_TO_DEVICE_TRANSFER(
        titleSecureRes = R.string.maswe_0006_vector_d2d_transfer_secure,
        msgSecureRes = R.string.maswe_0006_msg_d2d_transfer_secure,
        icon = Icons.Default.DeviceUnknown
    ),

    UNENCRYPTED_BACKUP_DATA(
        titleSecureRes = R.string.maswe_0006_vector_unencrypted_backup_secure,
        msgSecureRes = R.string.maswe_0006_msg_unencrypted_backup_secure,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0006"
    override val screenTitleSecureRes = R.string.maswe_0006_secure_title
    override val screenDescSecureRes = R.string.maswe_0006_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0006_secure_vectors_title
}
