package com.hasantuncay.mobsec.common.models.network

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0026: Network Traffic Not Encrypted
 */
enum class Maswe0026Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    CLEARTEXT_ALLOWED_IN_NSC(
        titleRes = R.string.maswe_0026_vector_cleartext_allowed_in_nsc_secure,
        msgRes = R.string.maswe_0026_msg_cleartext_allowed_in_nsc_secure,
        icon = Icons.Default.NoEncryption
    ),
    HTTP_INSTEAD_OF_HTTPS(
        titleRes = R.string.maswe_0026_vector_http_instead_of_https_secure,
        msgRes = R.string.maswe_0026_msg_http_instead_of_https_secure,
        icon = Icons.Default.Warning
    ),
    NON_HTTP_INSECURE_PROTOCOL(
        titleRes = R.string.maswe_0026_vector_non_http_insecure_protocol_secure,
        msgRes = R.string.maswe_0026_msg_non_http_insecure_protocol_secure,
        icon = Icons.Default.Block
    ),
    UNENCRYPTED_M2M_CHANNEL(
        titleRes = R.string.maswe_0026_vector_unencrypted_m2m_channel_secure,
        msgRes = R.string.maswe_0026_msg_unencrypted_m2m_channel_secure,
        icon = Icons.Default.Bluetooth
    ),
    LOW_LEVEL_NETWORK_API(
        titleRes = R.string.maswe_0026_vector_low_level_network_api_secure,
        msgRes = R.string.maswe_0026_msg_low_level_network_api_secure,
        icon = Icons.Default.Code
    ),
    CROSS_PLATFORM_MISCONFIGURATION(
        titleRes = R.string.maswe_0026_vector_cross_platform_misconfiguration_secure,
        msgRes = R.string.maswe_0026_msg_cross_platform_misconfiguration_secure,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleRes = R.string.maswe_0026_vector_third_party_library_secure,
        msgRes = R.string.maswe_0026_msg_third_party_library_secure,
        icon = Icons.Default.BugReport
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0026",
            titleRes = R.string.maswe_0026_secure_title,
            descRes = R.string.maswe_0026_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0026_secure_vectors_title
        )
    }
}
