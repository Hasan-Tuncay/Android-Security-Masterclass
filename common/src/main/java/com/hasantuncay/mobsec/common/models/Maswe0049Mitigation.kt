package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0049Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    LOADING_FROM_WRITABLE_LOCATIONS(
        titleSecureRes = R.string.maswe_0049_vector_loading_from_writable_locations_secure,
        msgSecureRes = R.string.maswe_0049_msg_loading_from_writable_locations_secure,
        icon = Icons.Default.FolderSpecial
    ),
    DOWNLOADED_CODE_WITHOUT_VERIFICATION(
        titleSecureRes = R.string.maswe_0049_vector_downloaded_code_without_verification_secure,
        msgSecureRes = R.string.maswe_0049_msg_downloaded_code_without_verification_secure,
        icon = Icons.Default.CloudDownload
    ),
    CODE_FROM_OTHER_PACKAGES(
        titleSecureRes = R.string.maswe_0049_vector_code_from_other_packages_secure,
        msgSecureRes = R.string.maswe_0049_msg_code_from_other_packages_secure,
        icon = Icons.Default.Apps
    );

    override val masweId = "MASWE-0049"
    override val screenTitleSecureRes = R.string.maswe_0049_secure_title
    override val screenDescSecureRes = R.string.maswe_0049_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0049_secure_vectors_title
}
