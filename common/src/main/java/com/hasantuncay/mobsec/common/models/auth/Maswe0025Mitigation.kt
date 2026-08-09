package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0025Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_TRUSTED_CONFIRMATION_PATH(
        titleRes = R.string.maswe_0025_vector_no_trusted_confirmation_path_secure,
        msgRes = R.string.maswe_0025_msg_no_trusted_confirmation_path_secure,
        icon = Icons.Default.Warning
    ),
    NO_CRYPTOGRAPHIC_EVIDENCE(
        titleRes = R.string.maswe_0025_vector_no_cryptographic_evidence_secure,
        msgRes = R.string.maswe_0025_msg_no_cryptographic_evidence_secure,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0025",
            titleRes = R.string.maswe_0025_secure_title,
            descRes = R.string.maswe_0025_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0025_secure_vectors_title
        )
    }
}
