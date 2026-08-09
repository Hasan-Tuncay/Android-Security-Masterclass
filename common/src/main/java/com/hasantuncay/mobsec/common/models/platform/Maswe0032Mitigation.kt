package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0032Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    IMPLICIT_INTENTS_INTERNAL(
        titleRes = R.string.maswe_0032_vector_implicit_intents_internal_secure,
        msgRes = R.string.maswe_0032_msg_implicit_intents_internal_secure,
        icon = Icons.Default.Send
    ),
    INTENT_REDIRECTION(
        titleRes = R.string.maswe_0032_vector_intent_redirection_secure,
        msgRes = R.string.maswe_0032_msg_intent_redirection_secure,
        icon = Icons.Default.SwapHoriz
    ),
    MUTABLE_PENDING_INTENTS(
        titleRes = R.string.maswe_0032_vector_mutable_pending_intents_secure,
        msgRes = R.string.maswe_0032_msg_mutable_pending_intents_secure,
        icon = Icons.Default.Edit
    ),
    REPLAYABLE_PENDING_INTENTS(
        titleRes = R.string.maswe_0032_vector_replayable_pending_intents_secure,
        msgRes = R.string.maswe_0032_msg_replayable_pending_intents_secure,
        icon = Icons.Default.Replay
    ),
    STICKY_BROADCASTS(
        titleRes = R.string.maswe_0032_vector_sticky_broadcasts_secure,
        msgRes = R.string.maswe_0032_msg_sticky_broadcasts_secure,
        icon = Icons.Default.Campaign
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0032",
            titleRes = R.string.maswe_0032_secure_title,
            descRes = R.string.maswe_0032_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0032_secure_vectors_title
        )
    }
}
