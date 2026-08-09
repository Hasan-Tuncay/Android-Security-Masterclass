package com.hasantuncay.mobsec.maswe0019.common

import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Vector
import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Mitigation
import com.hasantuncay.mobsec.maswe0019.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0019Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_AUTOFILL_IN_CREDENTIAL_FIELDS(
        titleRes = R.string.maswe_0019_vector_no_autofill_in_credential_fields_vuln,
        msgRes = R.string.maswe_0019_msg_no_autofill_in_credential_fields_vuln,
        icon = Icons.Default.Warning
    ),
    NO_OTC_AUTOFILL(
        titleRes = R.string.maswe_0019_vector_no_otc_autofill_vuln,
        msgRes = R.string.maswe_0019_msg_no_otc_autofill_vuln,
        icon = Icons.Default.DataArray
    ),
    MISSING_WEBSITE_ASSOCIATION(
        titleRes = R.string.maswe_0019_vector_missing_website_association_vuln,
        msgRes = R.string.maswe_0019_msg_missing_website_association_vuln,
        icon = Icons.Default.CloudOff
    ),
    EMBEDDED_CUSTOM_LOGIN(
        titleRes = R.string.maswe_0019_vector_embedded_custom_login_vuln,
        msgRes = R.string.maswe_0019_msg_embedded_custom_login_vuln,
        icon = Icons.Default.BugReport
    ),
    NO_PASSWORDLESS_AUTH(
        titleRes = R.string.maswe_0019_vector_no_passwordless_auth_vuln,
        msgRes = R.string.maswe_0019_msg_no_passwordless_auth_vuln,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0019",
            titleRes = CommonR.string.maswe_0019_vuln_title,
            descRes = CommonR.string.maswe_0019_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0019_vuln_vectors_title
        )
    }
}
