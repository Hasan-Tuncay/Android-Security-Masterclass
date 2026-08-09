package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0059Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_OBFUSCATION_APPLIED(
        titleSecureRes = R.string.maswe_0059_vector_no_obfuscation_applied_secure,
        msgSecureRes = R.string.maswe_0059_msg_no_obfuscation_applied_secure,
        icon = Icons.Default.CodeOff
    ),
    SECURITY_RELEVANT_LOGIC_READABLE(
        titleSecureRes = R.string.maswe_0059_vector_security_relevant_logic_readable_secure,
        msgSecureRes = R.string.maswe_0059_msg_security_relevant_logic_readable_secure,
        icon = Icons.Default.Visibility
    ),
    OBFUSCATION_WITHOUT_HARDENING(
        titleSecureRes = R.string.maswe_0059_vector_obfuscation_without_hardening_secure,
        msgSecureRes = R.string.maswe_0059_msg_obfuscation_without_hardening_secure,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0059"
    override val screenTitleSecureRes = R.string.maswe_0059_secure_title
    override val screenDescSecureRes = R.string.maswe_0059_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0059_secure_vectors_title
}
