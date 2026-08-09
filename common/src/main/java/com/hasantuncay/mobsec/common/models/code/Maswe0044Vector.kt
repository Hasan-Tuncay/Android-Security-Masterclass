package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0044Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DIRECT_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_direct_dependencies_vuln,
        msgRes = R.string.maswe_0044_msg_direct_dependencies_vuln,
        icon = Icons.Default.LibraryBooks
    ),
    TRANSITIVE_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_transitive_dependencies_vuln,
        msgRes = R.string.maswe_0044_msg_transitive_dependencies_vuln,
        icon = Icons.Default.AccountTree
    ),
    DYNAMICALLY_LOADED_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_dynamically_loaded_dependencies_vuln,
        msgRes = R.string.maswe_0044_msg_dynamically_loaded_dependencies_vuln,
        icon = Icons.Default.Extension
    ),
    OUTDATED_PLATFORM_SECURITY_COMPONENTS(
        titleRes = R.string.maswe_0044_vector_outdated_platform_security_components_vuln,
        msgRes = R.string.maswe_0044_msg_outdated_platform_security_components_vuln,
        icon = Icons.Default.Security
    ),
    USAGE_OF_THIRD_PARTY_FRAMEWORKS(
        titleRes = R.string.maswe_0044_vector_usage_of_third_party_frameworks_vuln,
        msgRes = R.string.maswe_0044_msg_usage_of_third_party_frameworks_vuln,
        icon = Icons.Default.Code
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0044",
            titleRes = R.string.maswe_0044_vuln_title,
            descRes = R.string.maswe_0044_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0044_vuln_vectors_title
        )
    }
}
