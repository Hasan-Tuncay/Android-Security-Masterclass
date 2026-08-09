package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0018Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNINTENTIONALLY_EXPORTED(
        titleVulnRes = R.string.maswe_0018_vector_unintentionally_exported_vuln,
        msgVulnRes = R.string.maswe_0018_msg_unintentionally_exported_vuln,
        icon = Icons.Default.BugReport
    ),
    MISSING_PERMISSIONS_ON_EXPORTS(
        titleVulnRes = R.string.maswe_0018_vector_missing_permissions_on_exports_vuln,
        msgVulnRes = R.string.maswe_0018_msg_missing_permissions_on_exports_vuln,
        icon = Icons.Default.Lock
    ),
    CALLER_NOT_VERIFIED(
        titleVulnRes = R.string.maswe_0018_vector_caller_not_verified_vuln,
        msgVulnRes = R.string.maswe_0018_msg_caller_not_verified_vuln,
        icon = Icons.Default.Warning
    ),
    OVERBROAD_DATA_GRANTS(
        titleVulnRes = R.string.maswe_0018_vector_overbroad_data_grants_vuln,
        msgVulnRes = R.string.maswe_0018_msg_overbroad_data_grants_vuln,
        icon = Icons.Default.CloudOff
    ),
    UNPROTECTED_LOCAL_NETWORK(
        titleVulnRes = R.string.maswe_0018_vector_unprotected_local_network_vuln,
        msgVulnRes = R.string.maswe_0018_msg_unprotected_local_network_vuln,
        icon = Icons.Default.NoEncryption
    ),
    AUTH_MATERIAL_NOT_VALIDATED(
        titleVulnRes = R.string.maswe_0018_vector_auth_material_not_validated_vuln,
        msgVulnRes = R.string.maswe_0018_msg_auth_material_not_validated_vuln,
        icon = Icons.Default.Key
    ),
    MISSING_AUTH_ON_DEEP_LINKS(
        titleVulnRes = R.string.maswe_0018_vector_missing_auth_on_deep_links_vuln,
        msgVulnRes = R.string.maswe_0018_msg_missing_auth_on_deep_links_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0018"
    override val screenTitleVulnRes = R.string.maswe_0018_vuln_title
    override val screenDescVulnRes = R.string.maswe_0018_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0018_vuln_vectors_title
}
