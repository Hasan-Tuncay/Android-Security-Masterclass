package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0019Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_AUTOFILL_IN_CREDENTIAL_FIELDS(
        titleRes = R.string.maswe_0019_vector_no_autofill_in_credential_fields_secure,
        msgRes = R.string.maswe_0019_msg_no_autofill_in_credential_fields_secure,
        icon = Icons.Default.Warning
    ),
    NO_OTC_AUTOFILL(
        titleRes = R.string.maswe_0019_vector_no_otc_autofill_secure,
        msgRes = R.string.maswe_0019_msg_no_otc_autofill_secure,
        icon = Icons.Default.DataArray
    ),
    MISSING_WEBSITE_ASSOCIATION(
        titleRes = R.string.maswe_0019_vector_missing_website_association_secure,
        msgRes = R.string.maswe_0019_msg_missing_website_association_secure,
        icon = Icons.Default.CloudOff
    ),
    EMBEDDED_CUSTOM_LOGIN(
        titleRes = R.string.maswe_0019_vector_embedded_custom_login_secure,
        msgRes = R.string.maswe_0019_msg_embedded_custom_login_secure,
        icon = Icons.Default.BugReport
    ),
    NO_PASSWORDLESS_AUTH(
        titleRes = R.string.maswe_0019_vector_no_passwordless_auth_secure,
        msgRes = R.string.maswe_0019_msg_no_passwordless_auth_secure,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0019",
            titleRes = R.string.maswe_0019_secure_title,
            descRes = R.string.maswe_0019_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0019_secure_vectors_title
        )
    }
}
