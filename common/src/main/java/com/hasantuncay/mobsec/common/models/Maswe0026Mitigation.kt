package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0026: Network Traffic Not Encrypted
 */
enum class Maswe0026Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    CLEARTEXT_ALLOWED_IN_NSC(
        titleSecureRes = R.string.maswe_0026_vector_cleartext_allowed_in_nsc_secure,
        msgSecureRes = R.string.maswe_0026_msg_cleartext_allowed_in_nsc_secure,
        icon = Icons.Default.NoEncryption
    ),
    HTTP_INSTEAD_OF_HTTPS(
        titleSecureRes = R.string.maswe_0026_vector_http_instead_of_https_secure,
        msgSecureRes = R.string.maswe_0026_msg_http_instead_of_https_secure,
        icon = Icons.Default.Warning
    ),
    NON_HTTP_INSECURE_PROTOCOL(
        titleSecureRes = R.string.maswe_0026_vector_non_http_insecure_protocol_secure,
        msgSecureRes = R.string.maswe_0026_msg_non_http_insecure_protocol_secure,
        icon = Icons.Default.Block
    ),
    UNENCRYPTED_M2M_CHANNEL(
        titleSecureRes = R.string.maswe_0026_vector_unencrypted_m2m_channel_secure,
        msgSecureRes = R.string.maswe_0026_msg_unencrypted_m2m_channel_secure,
        icon = Icons.Default.Bluetooth
    ),
    LOW_LEVEL_NETWORK_API(
        titleSecureRes = R.string.maswe_0026_vector_low_level_network_api_secure,
        msgSecureRes = R.string.maswe_0026_msg_low_level_network_api_secure,
        icon = Icons.Default.Code
    ),
    CROSS_PLATFORM_MISCONFIGURATION(
        titleSecureRes = R.string.maswe_0026_vector_cross_platform_misconfiguration_secure,
        msgSecureRes = R.string.maswe_0026_msg_cross_platform_misconfiguration_secure,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleSecureRes = R.string.maswe_0026_vector_third_party_library_secure,
        msgSecureRes = R.string.maswe_0026_msg_third_party_library_secure,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0026"
    override val screenTitleSecureRes = R.string.maswe_0026_secure_title
    override val screenDescSecureRes = R.string.maswe_0026_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0026_secure_vectors_title
}
