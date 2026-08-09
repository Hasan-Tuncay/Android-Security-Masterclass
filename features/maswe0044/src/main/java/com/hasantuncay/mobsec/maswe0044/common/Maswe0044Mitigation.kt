package com.hasantuncay.mobsec.maswe0044.common

import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Vector
import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Mitigation
import com.hasantuncay.mobsec.maswe0044.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0044Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DIRECT_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_direct_dependencies_secure,
        msgRes = R.string.maswe_0044_msg_direct_dependencies_secure,
        icon = Icons.AutoMirrored.Filled.LibraryBooks
    ),
    TRANSITIVE_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_transitive_dependencies_secure,
        msgRes = R.string.maswe_0044_msg_transitive_dependencies_secure,
        icon = Icons.Default.AccountTree
    ),
    DYNAMICALLY_LOADED_DEPENDENCIES(
        titleRes = R.string.maswe_0044_vector_dynamically_loaded_dependencies_secure,
        msgRes = R.string.maswe_0044_msg_dynamically_loaded_dependencies_secure,
        icon = Icons.Default.Extension
    ),
    OUTDATED_PLATFORM_SECURITY_COMPONENTS(
        titleRes = R.string.maswe_0044_vector_outdated_platform_security_components_secure,
        msgRes = R.string.maswe_0044_msg_outdated_platform_security_components_secure,
        icon = Icons.Default.Security
    ),
    USAGE_OF_THIRD_PARTY_FRAMEWORKS(
        titleRes = R.string.maswe_0044_vector_usage_of_third_party_frameworks_secure,
        msgRes = R.string.maswe_0044_msg_usage_of_third_party_frameworks_secure,
        icon = Icons.Default.Code
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0044",
            titleRes = CommonR.string.maswe_0044_secure_title,
            descRes = CommonR.string.maswe_0044_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0044_secure_vectors_title
        )
    }
}
