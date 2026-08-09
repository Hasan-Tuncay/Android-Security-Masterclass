package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0034Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    FILE_ACCESS_ENABLED(
        titleSecureRes = R.string.maswe_0034_vector_file_access_enabled_secure,
        msgSecureRes = R.string.maswe_0034_msg_file_access_enabled_secure,
        icon = Icons.Default.FolderShared
    ),
    UNIVERSAL_ACCESS_FROM_FILE_URLS(
        titleSecureRes = R.string.maswe_0034_vector_universal_access_from_file_urls_secure,
        msgSecureRes = R.string.maswe_0034_msg_universal_access_from_file_urls_secure,
        icon = Icons.Default.Public
    ),
    INSECURE_CUSTOM_RESOURCE_LOADING(
        titleSecureRes = R.string.maswe_0034_vector_insecure_custom_resource_loading_secure,
        msgSecureRes = R.string.maswe_0034_msg_insecure_custom_resource_loading_secure,
        icon = Icons.Default.Build
    ),
    OVERLY_BROAD_FILE_READ_GRANTS(
        titleSecureRes = R.string.maswe_0034_vector_overly_broad_file_read_grants_secure,
        msgSecureRes = R.string.maswe_0034_msg_overly_broad_file_read_grants_secure,
        icon = Icons.Default.FolderOpen
    );

    override val masweId = "MASWE-0034"
    override val screenTitleSecureRes = R.string.maswe_0034_secure_title
    override val screenDescSecureRes = R.string.maswe_0034_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0034_secure_vectors_title
}
