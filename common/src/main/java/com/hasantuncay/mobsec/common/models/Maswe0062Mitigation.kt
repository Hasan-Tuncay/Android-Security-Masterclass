package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0062Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    TLS_ONLY_PROTECTION(
        titleSecureRes = R.string.maswe_0062_vector_tls_only_protection_secure,
        msgSecureRes = R.string.maswe_0062_msg_tls_only_protection_secure,
        icon = Icons.Default.VpnKey
    ),
    NO_INTEGRITY_BINDING_ON_REQUESTS(
        titleSecureRes = R.string.maswe_0062_vector_no_integrity_binding_on_requests_secure,
        msgSecureRes = R.string.maswe_0062_msg_no_integrity_binding_on_requests_secure,
        icon = Icons.Default.LinkOff
    );

    override val masweId = "MASWE-0062"
    override val screenTitleSecureRes = R.string.maswe_0062_secure_title
    override val screenDescSecureRes = R.string.maswe_0062_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0062_secure_vectors_title
}
