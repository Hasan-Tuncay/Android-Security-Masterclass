package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0033Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    BRIDGES_REACHABLE_BY_UNTRUSTED(
        titleRes = R.string.maswe_0033_vector_bridges_reachable_by_untrusted_secure,
        msgRes = R.string.maswe_0033_msg_bridges_reachable_by_untrusted_secure,
        icon = Icons.Default.Public
    ),
    UNVALIDATED_BRIDGE_MESSAGES(
        titleRes = R.string.maswe_0033_vector_unvalidated_bridge_messages_secure,
        msgRes = R.string.maswe_0033_msg_unvalidated_bridge_messages_secure,
        icon = Icons.Default.Message
    ),
    GLOBALLY_EXPOSED_BRIDGES(
        titleRes = R.string.maswe_0033_vector_globally_exposed_bridges_secure,
        msgRes = R.string.maswe_0033_msg_globally_exposed_bridges_secure,
        icon = Icons.Default.Language
    ),
    APP_OWNED_SCRIPTS_PAGE_WORLD(
        titleRes = R.string.maswe_0033_vector_app_owned_scripts_page_world_secure,
        msgRes = R.string.maswe_0033_msg_app_owned_scripts_page_world_secure,
        icon = Icons.Default.Javascript
    ),
    SENSITIVE_DATA_IN_BRIDGE_REPLIES(
        titleRes = R.string.maswe_0033_vector_sensitive_data_in_bridge_replies_secure,
        msgRes = R.string.maswe_0033_msg_sensitive_data_in_bridge_replies_secure,
        icon = Icons.Default.Security
    ),
    OVER_EXPOSED_BRIDGES(
        titleRes = R.string.maswe_0033_vector_over_exposed_bridges_secure,
        msgRes = R.string.maswe_0033_msg_over_exposed_bridges_secure,
        icon = Icons.Default.LockOpen
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0033",
            titleRes = R.string.maswe_0033_secure_title,
            descRes = R.string.maswe_0033_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0033_secure_vectors_title
        )
    }
}
