package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0019Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_AUTOFILL_IN_CREDENTIAL_FIELDS(
        titleSecureRes = R.string.maswe_0019_vector_no_autofill_in_credential_fields_secure,
        msgSecureRes = R.string.maswe_0019_msg_no_autofill_in_credential_fields_secure,
        icon = Icons.Default.Warning
    ),
    NO_OTC_AUTOFILL(
        titleSecureRes = R.string.maswe_0019_vector_no_otc_autofill_secure,
        msgSecureRes = R.string.maswe_0019_msg_no_otc_autofill_secure,
        icon = Icons.Default.DataArray
    ),
    MISSING_WEBSITE_ASSOCIATION(
        titleSecureRes = R.string.maswe_0019_vector_missing_website_association_secure,
        msgSecureRes = R.string.maswe_0019_msg_missing_website_association_secure,
        icon = Icons.Default.CloudOff
    ),
    EMBEDDED_CUSTOM_LOGIN(
        titleSecureRes = R.string.maswe_0019_vector_embedded_custom_login_secure,
        msgSecureRes = R.string.maswe_0019_msg_embedded_custom_login_secure,
        icon = Icons.Default.BugReport
    ),
    NO_PASSWORDLESS_AUTH(
        titleSecureRes = R.string.maswe_0019_vector_no_passwordless_auth_secure,
        msgSecureRes = R.string.maswe_0019_msg_no_passwordless_auth_secure,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0019"
    override val screenTitleSecureRes = R.string.maswe_0019_secure_title
    override val screenDescSecureRes = R.string.maswe_0019_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0019_secure_vectors_title
}
