package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0032Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    IMPLICIT_INTENTS_INTERNAL(
        titleSecureRes = R.string.maswe_0032_vector_implicit_intents_internal_secure,
        msgSecureRes = R.string.maswe_0032_msg_implicit_intents_internal_secure,
        icon = Icons.Default.Send
    ),
    INTENT_REDIRECTION(
        titleSecureRes = R.string.maswe_0032_vector_intent_redirection_secure,
        msgSecureRes = R.string.maswe_0032_msg_intent_redirection_secure,
        icon = Icons.Default.SwapHoriz
    ),
    MUTABLE_PENDING_INTENTS(
        titleSecureRes = R.string.maswe_0032_vector_mutable_pending_intents_secure,
        msgSecureRes = R.string.maswe_0032_msg_mutable_pending_intents_secure,
        icon = Icons.Default.Edit
    ),
    REPLAYABLE_PENDING_INTENTS(
        titleSecureRes = R.string.maswe_0032_vector_replayable_pending_intents_secure,
        msgSecureRes = R.string.maswe_0032_msg_replayable_pending_intents_secure,
        icon = Icons.Default.Replay
    ),
    STICKY_BROADCASTS(
        titleSecureRes = R.string.maswe_0032_vector_sticky_broadcasts_secure,
        msgSecureRes = R.string.maswe_0032_msg_sticky_broadcasts_secure,
        icon = Icons.Default.Campaign
    );

    override val masweId = "MASWE-0032"
    override val screenTitleSecureRes = R.string.maswe_0032_secure_title
    override val screenDescSecureRes = R.string.maswe_0032_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0032_secure_vectors_title
}
