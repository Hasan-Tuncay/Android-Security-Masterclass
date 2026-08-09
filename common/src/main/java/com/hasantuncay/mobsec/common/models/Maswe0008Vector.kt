package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0008: Improper Hashing
 * Modes of Introduction from MASWE repo:
 * - Broken Hash Algorithm: Using MD5 or SHA-1 in security contexts
 * - Wrong Hash For Job: Plain cryptographic hash for passwords instead of KDF
 * - Truncated Digest: Hash output truncated below security strength
 */
enum class Maswe0008Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    BROKEN_HASH_ALGORITHM(
        titleVulnRes = R.string.maswe_0008_vector_broken_hash_algorithm_vuln,
        msgVulnRes = R.string.maswe_0008_msg_broken_hash_algorithm_vuln,
        icon = Icons.Default.Block
    ),
    WRONG_HASH_FOR_JOB(
        titleVulnRes = R.string.maswe_0008_vector_wrong_hash_for_job_vuln,
        msgVulnRes = R.string.maswe_0008_msg_wrong_hash_for_job_vuln,
        icon = Icons.Default.Warning
    ),
    TRUNCATED_DIGEST(
        titleVulnRes = R.string.maswe_0008_vector_truncated_digest_vuln,
        msgVulnRes = R.string.maswe_0008_msg_truncated_digest_vuln,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0008"
    override val screenTitleVulnRes = R.string.maswe_0008_vuln_title
    override val screenDescVulnRes = R.string.maswe_0008_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0008_vuln_vectors_title
}
