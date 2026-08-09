package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0011: Improper Verification of Cryptographic Signature
 * Modes of Introduction from MASWE repo:
 * - Verification Skipped: Not verifying signatures or ignoring verification output
 * - Untrusted Signer Key: Verifying signatures with untrusted or caller-supplied keys
 * - Algorithm Confusion: Dynamic algorithm selection from signed payload (e.g., none algorithm)
 */
enum class Maswe0011Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    VERIFICATION_SKIPPED(
        titleSecureRes = R.string.maswe_0011_vector_verification_skipped_secure,
        msgSecureRes = R.string.maswe_0011_msg_verification_skipped_secure,
        icon = Icons.Default.Block
    ),
    UNTRUSTED_SIGNER_KEY(
        titleSecureRes = R.string.maswe_0011_vector_untrusted_signer_key_secure,
        msgSecureRes = R.string.maswe_0011_msg_untrusted_signer_key_secure,
        icon = Icons.Default.Warning
    ),
    ALGORITHM_CONFUSION(
        titleSecureRes = R.string.maswe_0011_vector_algorithm_confusion_secure,
        msgSecureRes = R.string.maswe_0011_msg_algorithm_confusion_secure,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0011"
    override val screenTitleSecureRes = R.string.maswe_0011_secure_title
    override val screenDescSecureRes = R.string.maswe_0011_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0011_secure_vectors_title
}
