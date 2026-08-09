package com.hasantuncay.mobsec.maswe0018.common

import com.hasantuncay.mobsec.maswe0018.common.Maswe0018Vector
import com.hasantuncay.mobsec.maswe0018.common.Maswe0018Mitigation
import com.hasantuncay.mobsec.maswe0018.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0018Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNINTENTIONALLY_EXPORTED(
        titleRes = R.string.maswe_0018_vector_unintentionally_exported_vuln,
        msgRes = R.string.maswe_0018_msg_unintentionally_exported_vuln,
        icon = Icons.Default.BugReport
    ),
    MISSING_PERMISSIONS_ON_EXPORTS(
        titleRes = R.string.maswe_0018_vector_missing_permissions_on_exports_vuln,
        msgRes = R.string.maswe_0018_msg_missing_permissions_on_exports_vuln,
        icon = Icons.Default.Lock
    ),
    CALLER_NOT_VERIFIED(
        titleRes = R.string.maswe_0018_vector_caller_not_verified_vuln,
        msgRes = R.string.maswe_0018_msg_caller_not_verified_vuln,
        icon = Icons.Default.Warning
    ),
    OVERBROAD_DATA_GRANTS(
        titleRes = R.string.maswe_0018_vector_overbroad_data_grants_vuln,
        msgRes = R.string.maswe_0018_msg_overbroad_data_grants_vuln,
        icon = Icons.Default.CloudOff
    ),
    UNPROTECTED_LOCAL_NETWORK(
        titleRes = R.string.maswe_0018_vector_unprotected_local_network_vuln,
        msgRes = R.string.maswe_0018_msg_unprotected_local_network_vuln,
        icon = Icons.Default.NoEncryption
    ),
    AUTH_MATERIAL_NOT_VALIDATED(
        titleRes = R.string.maswe_0018_vector_auth_material_not_validated_vuln,
        msgRes = R.string.maswe_0018_msg_auth_material_not_validated_vuln,
        icon = Icons.Default.Key
    ),
    MISSING_AUTH_ON_DEEP_LINKS(
        titleRes = R.string.maswe_0018_vector_missing_auth_on_deep_links_vuln,
        msgRes = R.string.maswe_0018_msg_missing_auth_on_deep_links_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0018",
            titleRes = CommonR.string.maswe_0018_vuln_title,
            descRes = CommonR.string.maswe_0018_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0018_vuln_vectors_title
        )
    }
}
