package com.hasantuncay.mobsec.maswe0049.common

import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Vector
import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Mitigation
import com.hasantuncay.mobsec.maswe0049.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0049Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    LOADING_FROM_WRITABLE_LOCATIONS(
        titleRes = R.string.maswe_0049_vector_loading_from_writable_locations_secure,
        msgRes = R.string.maswe_0049_msg_loading_from_writable_locations_secure,
        icon = Icons.Default.FolderSpecial
    ),
    DOWNLOADED_CODE_WITHOUT_VERIFICATION(
        titleRes = R.string.maswe_0049_vector_downloaded_code_without_verification_secure,
        msgRes = R.string.maswe_0049_msg_downloaded_code_without_verification_secure,
        icon = Icons.Default.CloudDownload
    ),
    CODE_FROM_OTHER_PACKAGES(
        titleRes = R.string.maswe_0049_vector_code_from_other_packages_secure,
        msgRes = R.string.maswe_0049_msg_code_from_other_packages_secure,
        icon = Icons.Default.Apps
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0049",
            titleRes = CommonR.string.maswe_0049_secure_title,
            descRes = CommonR.string.maswe_0049_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0049_secure_vectors_title
        )
    }
}
