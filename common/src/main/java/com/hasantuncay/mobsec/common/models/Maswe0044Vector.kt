package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0044Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DIRECT_DEPENDENCIES(
        titleVulnRes = R.string.maswe_0044_vector_direct_dependencies_vuln,
        msgVulnRes = R.string.maswe_0044_msg_direct_dependencies_vuln,
        icon = Icons.Default.LibraryBooks
    ),
    TRANSITIVE_DEPENDENCIES(
        titleVulnRes = R.string.maswe_0044_vector_transitive_dependencies_vuln,
        msgVulnRes = R.string.maswe_0044_msg_transitive_dependencies_vuln,
        icon = Icons.Default.AccountTree
    ),
    DYNAMICALLY_LOADED_DEPENDENCIES(
        titleVulnRes = R.string.maswe_0044_vector_dynamically_loaded_dependencies_vuln,
        msgVulnRes = R.string.maswe_0044_msg_dynamically_loaded_dependencies_vuln,
        icon = Icons.Default.Extension
    ),
    OUTDATED_PLATFORM_SECURITY_COMPONENTS(
        titleVulnRes = R.string.maswe_0044_vector_outdated_platform_security_components_vuln,
        msgVulnRes = R.string.maswe_0044_msg_outdated_platform_security_components_vuln,
        icon = Icons.Default.Security
    ),
    USAGE_OF_THIRD_PARTY_FRAMEWORKS(
        titleVulnRes = R.string.maswe_0044_vector_usage_of_third_party_frameworks_vuln,
        msgVulnRes = R.string.maswe_0044_msg_usage_of_third_party_frameworks_vuln,
        icon = Icons.Default.Code
    );

    override val masweId = "MASWE-0044"
    override val screenTitleVulnRes = R.string.maswe_0044_vuln_title
    override val screenDescVulnRes = R.string.maswe_0044_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0044_vuln_vectors_title
}
