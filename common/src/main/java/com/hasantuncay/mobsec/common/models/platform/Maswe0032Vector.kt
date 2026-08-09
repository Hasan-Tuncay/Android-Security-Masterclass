package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0032Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    IMPLICIT_INTENTS_INTERNAL(
        titleRes = R.string.maswe_0032_vector_implicit_intents_internal_vuln,
        msgRes = R.string.maswe_0032_msg_implicit_intents_internal_vuln,
        icon = Icons.Default.Send
    ),
    INTENT_REDIRECTION(
        titleRes = R.string.maswe_0032_vector_intent_redirection_vuln,
        msgRes = R.string.maswe_0032_msg_intent_redirection_vuln,
        icon = Icons.Default.SwapHoriz
    ),
    MUTABLE_PENDING_INTENTS(
        titleRes = R.string.maswe_0032_vector_mutable_pending_intents_vuln,
        msgRes = R.string.maswe_0032_msg_mutable_pending_intents_vuln,
        icon = Icons.Default.Edit
    ),
    REPLAYABLE_PENDING_INTENTS(
        titleRes = R.string.maswe_0032_vector_replayable_pending_intents_vuln,
        msgRes = R.string.maswe_0032_msg_replayable_pending_intents_vuln,
        icon = Icons.Default.Replay
    ),
    STICKY_BROADCASTS(
        titleRes = R.string.maswe_0032_vector_sticky_broadcasts_vuln,
        msgRes = R.string.maswe_0032_msg_sticky_broadcasts_vuln,
        icon = Icons.Default.Campaign
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0032",
            titleRes = R.string.maswe_0032_vuln_title,
            descRes = R.string.maswe_0032_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0032_vuln_vectors_title
        )
    }
}
