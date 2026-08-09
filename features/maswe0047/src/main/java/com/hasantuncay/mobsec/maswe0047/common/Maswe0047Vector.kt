package com.hasantuncay.mobsec.maswe0047.common

import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Vector
import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Mitigation
import com.hasantuncay.mobsec.maswe0047.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0047Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    ROLL_YOUR_OWN_CRYPTOGRAPHY(
        titleRes = R.string.maswe_0047_vector_roll_your_own_cryptography_vuln,
        msgRes = R.string.maswe_0047_msg_roll_your_own_cryptography_vuln,
        icon = Icons.Default.Build
    ),
    CUSTOM_NETWORKING_TLS_STACKS(
        titleRes = R.string.maswe_0047_vector_custom_networking_tls_stacks_vuln,
        msgRes = R.string.maswe_0047_msg_custom_networking_tls_stacks_vuln,
        icon = Icons.Default.SettingsEthernet
    ),
    CUSTOM_DNS_RESOLUTION(
        titleRes = R.string.maswe_0047_vector_custom_dns_resolution_vuln,
        msgRes = R.string.maswe_0047_msg_custom_dns_resolution_vuln,
        icon = Icons.Default.Dns
    ),
    CUSTOM_AUTHENTICATION(
        titleRes = R.string.maswe_0047_vector_custom_authentication_vuln,
        msgRes = R.string.maswe_0047_msg_custom_authentication_vuln,
        icon = Icons.Default.Lock
    ),
    UNMAINTAINED_SECURITY_LIBRARIES(
        titleRes = R.string.maswe_0047_vector_unmaintained_security_libraries_vuln,
        msgRes = R.string.maswe_0047_msg_unmaintained_security_libraries_vuln,
        icon = Icons.Default.AutoDelete
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0047",
            titleRes = CommonR.string.maswe_0047_vuln_title,
            descRes = CommonR.string.maswe_0047_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0047_vuln_vectors_title
        )
    }
}
