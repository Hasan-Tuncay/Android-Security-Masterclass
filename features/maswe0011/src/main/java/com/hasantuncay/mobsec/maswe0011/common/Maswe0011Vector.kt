package com.hasantuncay.mobsec.maswe0011.common

import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Vector
import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Mitigation
import com.hasantuncay.mobsec.maswe0011.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0011: Improper Verification of Cryptographic Signature
 * Modes of Introduction from MASWE repo:
 * - Verification Skipped: Not verifying signatures or ignoring verification output
 * - Untrusted Signer Key: Verifying signatures with untrusted or caller-supplied keys
 * - Algorithm Confusion: Dynamic algorithm selection from signed payload (e.g., none algorithm)
 */
enum class Maswe0011Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    VERIFICATION_SKIPPED(
        titleRes = R.string.maswe_0011_vector_verification_skipped_vuln,
        msgRes = R.string.maswe_0011_msg_verification_skipped_vuln,
        icon = Icons.Default.Block
    ),
    UNTRUSTED_SIGNER_KEY(
        titleRes = R.string.maswe_0011_vector_untrusted_signer_key_vuln,
        msgRes = R.string.maswe_0011_msg_untrusted_signer_key_vuln,
        icon = Icons.Default.Warning
    ),
    ALGORITHM_CONFUSION(
        titleRes = R.string.maswe_0011_vector_algorithm_confusion_vuln,
        msgRes = R.string.maswe_0011_msg_algorithm_confusion_vuln,
        icon = Icons.Default.NoEncryption
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0011",
            titleRes = CommonR.string.maswe_0011_vuln_title,
            descRes = CommonR.string.maswe_0011_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0011_vuln_vectors_title
        )
    }
}
