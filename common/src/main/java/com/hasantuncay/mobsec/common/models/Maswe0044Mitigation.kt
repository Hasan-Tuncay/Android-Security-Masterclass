package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0044Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DIRECT_DEPENDENCIES(
        titleSecureRes = R.string.maswe_0044_vector_direct_dependencies_secure,
        msgSecureRes = R.string.maswe_0044_msg_direct_dependencies_secure,
        icon = Icons.Default.LibraryBooks
    ),
    TRANSITIVE_DEPENDENCIES(
        titleSecureRes = R.string.maswe_0044_vector_transitive_dependencies_secure,
        msgSecureRes = R.string.maswe_0044_msg_transitive_dependencies_secure,
        icon = Icons.Default.AccountTree
    ),
    DYNAMICALLY_LOADED_DEPENDENCIES(
        titleSecureRes = R.string.maswe_0044_vector_dynamically_loaded_dependencies_secure,
        msgSecureRes = R.string.maswe_0044_msg_dynamically_loaded_dependencies_secure,
        icon = Icons.Default.Extension
    ),
    OUTDATED_PLATFORM_SECURITY_COMPONENTS(
        titleSecureRes = R.string.maswe_0044_vector_outdated_platform_security_components_secure,
        msgSecureRes = R.string.maswe_0044_msg_outdated_platform_security_components_secure,
        icon = Icons.Default.Security
    ),
    USAGE_OF_THIRD_PARTY_FRAMEWORKS(
        titleSecureRes = R.string.maswe_0044_vector_usage_of_third_party_frameworks_secure,
        msgSecureRes = R.string.maswe_0044_msg_usage_of_third_party_frameworks_secure,
        icon = Icons.Default.Code
    );

    override val masweId = "MASWE-0044"
    override val screenTitleSecureRes = R.string.maswe_0044_secure_title
    override val screenDescSecureRes = R.string.maswe_0044_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0044_secure_vectors_title
}
