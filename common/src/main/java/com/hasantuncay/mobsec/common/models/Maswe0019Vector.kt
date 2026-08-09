package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0019Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_AUTOFILL_IN_CREDENTIAL_FIELDS(
        titleVulnRes = R.string.maswe_0019_vector_no_autofill_in_credential_fields_vuln,
        msgVulnRes = R.string.maswe_0019_msg_no_autofill_in_credential_fields_vuln,
        icon = Icons.Default.Warning
    ),
    NO_OTC_AUTOFILL(
        titleVulnRes = R.string.maswe_0019_vector_no_otc_autofill_vuln,
        msgVulnRes = R.string.maswe_0019_msg_no_otc_autofill_vuln,
        icon = Icons.Default.DataArray
    ),
    MISSING_WEBSITE_ASSOCIATION(
        titleVulnRes = R.string.maswe_0019_vector_missing_website_association_vuln,
        msgVulnRes = R.string.maswe_0019_msg_missing_website_association_vuln,
        icon = Icons.Default.CloudOff
    ),
    EMBEDDED_CUSTOM_LOGIN(
        titleVulnRes = R.string.maswe_0019_vector_embedded_custom_login_vuln,
        msgVulnRes = R.string.maswe_0019_msg_embedded_custom_login_vuln,
        icon = Icons.Default.BugReport
    ),
    NO_PASSWORDLESS_AUTH(
        titleVulnRes = R.string.maswe_0019_vector_no_passwordless_auth_vuln,
        msgVulnRes = R.string.maswe_0019_msg_no_passwordless_auth_vuln,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0019"
    override val screenTitleVulnRes = R.string.maswe_0019_vuln_title
    override val screenDescVulnRes = R.string.maswe_0019_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0019_vuln_vectors_title
}
