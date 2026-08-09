package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0047Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    ROLL_YOUR_OWN_CRYPTOGRAPHY(
        titleSecureRes = R.string.maswe_0047_vector_roll_your_own_cryptography_secure,
        msgSecureRes = R.string.maswe_0047_msg_roll_your_own_cryptography_secure,
        icon = Icons.Default.Build
    ),
    CUSTOM_NETWORKING_TLS_STACKS(
        titleSecureRes = R.string.maswe_0047_vector_custom_networking_tls_stacks_secure,
        msgSecureRes = R.string.maswe_0047_msg_custom_networking_tls_stacks_secure,
        icon = Icons.Default.SettingsEthernet
    ),
    CUSTOM_DNS_RESOLUTION(
        titleSecureRes = R.string.maswe_0047_vector_custom_dns_resolution_secure,
        msgSecureRes = R.string.maswe_0047_msg_custom_dns_resolution_secure,
        icon = Icons.Default.Dns
    ),
    CUSTOM_AUTHENTICATION(
        titleSecureRes = R.string.maswe_0047_vector_custom_authentication_secure,
        msgSecureRes = R.string.maswe_0047_msg_custom_authentication_secure,
        icon = Icons.Default.Lock
    ),
    UNMAINTAINED_SECURITY_LIBRARIES(
        titleSecureRes = R.string.maswe_0047_vector_unmaintained_security_libraries_secure,
        msgSecureRes = R.string.maswe_0047_msg_unmaintained_security_libraries_secure,
        icon = Icons.Default.AutoDelete
    );

    override val masweId = "MASWE-0047"
    override val screenTitleSecureRes = R.string.maswe_0047_secure_title
    override val screenDescSecureRes = R.string.maswe_0047_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0047_secure_vectors_title
}
