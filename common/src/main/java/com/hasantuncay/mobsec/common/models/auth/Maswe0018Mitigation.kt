package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0018Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    UNINTENTIONALLY_EXPORTED(
        titleRes = R.string.maswe_0018_vector_unintentionally_exported_secure,
        msgRes = R.string.maswe_0018_msg_unintentionally_exported_secure,
        icon = Icons.Default.BugReport
    ),
    MISSING_PERMISSIONS_ON_EXPORTS(
        titleRes = R.string.maswe_0018_vector_missing_permissions_on_exports_secure,
        msgRes = R.string.maswe_0018_msg_missing_permissions_on_exports_secure,
        icon = Icons.Default.Lock
    ),
    CALLER_NOT_VERIFIED(
        titleRes = R.string.maswe_0018_vector_caller_not_verified_secure,
        msgRes = R.string.maswe_0018_msg_caller_not_verified_secure,
        icon = Icons.Default.Warning
    ),
    OVERBROAD_DATA_GRANTS(
        titleRes = R.string.maswe_0018_vector_overbroad_data_grants_secure,
        msgRes = R.string.maswe_0018_msg_overbroad_data_grants_secure,
        icon = Icons.Default.CloudOff
    ),
    UNPROTECTED_LOCAL_NETWORK(
        titleRes = R.string.maswe_0018_vector_unprotected_local_network_secure,
        msgRes = R.string.maswe_0018_msg_unprotected_local_network_secure,
        icon = Icons.Default.NoEncryption
    ),
    AUTH_MATERIAL_NOT_VALIDATED(
        titleRes = R.string.maswe_0018_vector_auth_material_not_validated_secure,
        msgRes = R.string.maswe_0018_msg_auth_material_not_validated_secure,
        icon = Icons.Default.Key
    ),
    MISSING_AUTH_ON_DEEP_LINKS(
        titleRes = R.string.maswe_0018_vector_missing_auth_on_deep_links_secure,
        msgRes = R.string.maswe_0018_msg_missing_auth_on_deep_links_secure,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0018",
            titleRes = R.string.maswe_0018_secure_title,
            descRes = R.string.maswe_0018_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0018_secure_vectors_title
        )
    }
}
