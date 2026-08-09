package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0047Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    ROLL_YOUR_OWN_CRYPTOGRAPHY(
        titleRes = R.string.maswe_0047_vector_roll_your_own_cryptography_secure,
        msgRes = R.string.maswe_0047_msg_roll_your_own_cryptography_secure,
        icon = Icons.Default.Build
    ),
    CUSTOM_NETWORKING_TLS_STACKS(
        titleRes = R.string.maswe_0047_vector_custom_networking_tls_stacks_secure,
        msgRes = R.string.maswe_0047_msg_custom_networking_tls_stacks_secure,
        icon = Icons.Default.SettingsEthernet
    ),
    CUSTOM_DNS_RESOLUTION(
        titleRes = R.string.maswe_0047_vector_custom_dns_resolution_secure,
        msgRes = R.string.maswe_0047_msg_custom_dns_resolution_secure,
        icon = Icons.Default.Dns
    ),
    CUSTOM_AUTHENTICATION(
        titleRes = R.string.maswe_0047_vector_custom_authentication_secure,
        msgRes = R.string.maswe_0047_msg_custom_authentication_secure,
        icon = Icons.Default.Lock
    ),
    UNMAINTAINED_SECURITY_LIBRARIES(
        titleRes = R.string.maswe_0047_vector_unmaintained_security_libraries_secure,
        msgRes = R.string.maswe_0047_msg_unmaintained_security_libraries_secure,
        icon = Icons.Default.AutoDelete
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0047",
            titleRes = R.string.maswe_0047_secure_title,
            descRes = R.string.maswe_0047_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0047_secure_vectors_title
        )
    }
}
