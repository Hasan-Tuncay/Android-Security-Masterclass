package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0018Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    UNINTENTIONALLY_EXPORTED(
        titleSecureRes = R.string.maswe_0018_vector_unintentionally_exported_secure,
        msgSecureRes = R.string.maswe_0018_msg_unintentionally_exported_secure,
        icon = Icons.Default.BugReport
    ),
    MISSING_PERMISSIONS_ON_EXPORTS(
        titleSecureRes = R.string.maswe_0018_vector_missing_permissions_on_exports_secure,
        msgSecureRes = R.string.maswe_0018_msg_missing_permissions_on_exports_secure,
        icon = Icons.Default.Lock
    ),
    CALLER_NOT_VERIFIED(
        titleSecureRes = R.string.maswe_0018_vector_caller_not_verified_secure,
        msgSecureRes = R.string.maswe_0018_msg_caller_not_verified_secure,
        icon = Icons.Default.Warning
    ),
    OVERBROAD_DATA_GRANTS(
        titleSecureRes = R.string.maswe_0018_vector_overbroad_data_grants_secure,
        msgSecureRes = R.string.maswe_0018_msg_overbroad_data_grants_secure,
        icon = Icons.Default.CloudOff
    ),
    UNPROTECTED_LOCAL_NETWORK(
        titleSecureRes = R.string.maswe_0018_vector_unprotected_local_network_secure,
        msgSecureRes = R.string.maswe_0018_msg_unprotected_local_network_secure,
        icon = Icons.Default.NoEncryption
    ),
    AUTH_MATERIAL_NOT_VALIDATED(
        titleSecureRes = R.string.maswe_0018_vector_auth_material_not_validated_secure,
        msgSecureRes = R.string.maswe_0018_msg_auth_material_not_validated_secure,
        icon = Icons.Default.Key
    ),
    MISSING_AUTH_ON_DEEP_LINKS(
        titleSecureRes = R.string.maswe_0018_vector_missing_auth_on_deep_links_secure,
        msgSecureRes = R.string.maswe_0018_msg_missing_auth_on_deep_links_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0018"
    override val screenTitleSecureRes = R.string.maswe_0018_secure_title
    override val screenDescSecureRes = R.string.maswe_0018_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0018_secure_vectors_title
}
