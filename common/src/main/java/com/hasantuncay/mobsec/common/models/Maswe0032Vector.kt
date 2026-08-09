package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0032Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    IMPLICIT_INTENTS_INTERNAL(
        titleVulnRes = R.string.maswe_0032_vector_implicit_intents_internal_vuln,
        msgVulnRes = R.string.maswe_0032_msg_implicit_intents_internal_vuln,
        icon = Icons.Default.Send
    ),
    INTENT_REDIRECTION(
        titleVulnRes = R.string.maswe_0032_vector_intent_redirection_vuln,
        msgVulnRes = R.string.maswe_0032_msg_intent_redirection_vuln,
        icon = Icons.Default.SwapHoriz
    ),
    MUTABLE_PENDING_INTENTS(
        titleVulnRes = R.string.maswe_0032_vector_mutable_pending_intents_vuln,
        msgVulnRes = R.string.maswe_0032_msg_mutable_pending_intents_vuln,
        icon = Icons.Default.Edit
    ),
    REPLAYABLE_PENDING_INTENTS(
        titleVulnRes = R.string.maswe_0032_vector_replayable_pending_intents_vuln,
        msgVulnRes = R.string.maswe_0032_msg_replayable_pending_intents_vuln,
        icon = Icons.Default.Replay
    ),
    STICKY_BROADCASTS(
        titleVulnRes = R.string.maswe_0032_vector_sticky_broadcasts_vuln,
        msgVulnRes = R.string.maswe_0032_msg_sticky_broadcasts_vuln,
        icon = Icons.Default.Campaign
    );

    override val masweId = "MASWE-0032"
    override val screenTitleVulnRes = R.string.maswe_0032_vuln_title
    override val screenDescVulnRes = R.string.maswe_0032_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0032_vuln_vectors_title
}
