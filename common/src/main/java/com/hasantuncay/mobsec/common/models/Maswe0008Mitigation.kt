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
enum class Maswe0008Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    BROKEN_HASH_ALGORITHM(
        titleSecureRes = R.string.maswe_0008_vector_broken_hash_algorithm_secure,
        msgSecureRes = R.string.maswe_0008_msg_broken_hash_algorithm_secure,
        icon = Icons.Default.Block
    ),
    WRONG_HASH_FOR_JOB(
        titleSecureRes = R.string.maswe_0008_vector_wrong_hash_for_job_secure,
        msgSecureRes = R.string.maswe_0008_msg_wrong_hash_for_job_secure,
        icon = Icons.Default.Warning
    ),
    TRUNCATED_DIGEST(
        titleSecureRes = R.string.maswe_0008_vector_truncated_digest_secure,
        msgSecureRes = R.string.maswe_0008_msg_truncated_digest_secure,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0008"
    override val screenTitleSecureRes = R.string.maswe_0008_secure_title
    override val screenDescSecureRes = R.string.maswe_0008_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0008_secure_vectors_title
}
