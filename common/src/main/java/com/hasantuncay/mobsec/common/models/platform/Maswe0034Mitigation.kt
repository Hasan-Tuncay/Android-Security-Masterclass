package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0034Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    FILE_ACCESS_ENABLED(
        titleRes = R.string.maswe_0034_vector_file_access_enabled_secure,
        msgRes = R.string.maswe_0034_msg_file_access_enabled_secure,
        icon = Icons.Default.FolderShared
    ),
    UNIVERSAL_ACCESS_FROM_FILE_URLS(
        titleRes = R.string.maswe_0034_vector_universal_access_from_file_urls_secure,
        msgRes = R.string.maswe_0034_msg_universal_access_from_file_urls_secure,
        icon = Icons.Default.Public
    ),
    INSECURE_CUSTOM_RESOURCE_LOADING(
        titleRes = R.string.maswe_0034_vector_insecure_custom_resource_loading_secure,
        msgRes = R.string.maswe_0034_msg_insecure_custom_resource_loading_secure,
        icon = Icons.Default.Build
    ),
    OVERLY_BROAD_FILE_READ_GRANTS(
        titleRes = R.string.maswe_0034_vector_overly_broad_file_read_grants_secure,
        msgRes = R.string.maswe_0034_msg_overly_broad_file_read_grants_secure,
        icon = Icons.Default.FolderOpen
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0034",
            titleRes = R.string.maswe_0034_secure_title,
            descRes = R.string.maswe_0034_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0034_secure_vectors_title
        )
    }
}
