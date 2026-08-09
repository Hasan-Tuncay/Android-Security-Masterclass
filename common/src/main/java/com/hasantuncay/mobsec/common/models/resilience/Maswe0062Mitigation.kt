package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0062Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    TLS_ONLY_PROTECTION(
        titleRes = R.string.maswe_0062_vector_tls_only_protection_secure,
        msgRes = R.string.maswe_0062_msg_tls_only_protection_secure,
        icon = Icons.Default.VpnKey
    ),
    NO_INTEGRITY_BINDING_ON_REQUESTS(
        titleRes = R.string.maswe_0062_vector_no_integrity_binding_on_requests_secure,
        msgRes = R.string.maswe_0062_msg_no_integrity_binding_on_requests_secure,
        icon = Icons.Default.LinkOff
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0062",
            titleRes = R.string.maswe_0062_secure_title,
            descRes = R.string.maswe_0062_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0062_secure_vectors_title
        )
    }
}
