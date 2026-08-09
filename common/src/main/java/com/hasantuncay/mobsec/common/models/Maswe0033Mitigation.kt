package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0033Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    BRIDGES_REACHABLE_BY_UNTRUSTED(
        titleSecureRes = R.string.maswe_0033_vector_bridges_reachable_by_untrusted_secure,
        msgSecureRes = R.string.maswe_0033_msg_bridges_reachable_by_untrusted_secure,
        icon = Icons.Default.Public
    ),
    UNVALIDATED_BRIDGE_MESSAGES(
        titleSecureRes = R.string.maswe_0033_vector_unvalidated_bridge_messages_secure,
        msgSecureRes = R.string.maswe_0033_msg_unvalidated_bridge_messages_secure,
        icon = Icons.Default.Message
    ),
    GLOBALLY_EXPOSED_BRIDGES(
        titleSecureRes = R.string.maswe_0033_vector_globally_exposed_bridges_secure,
        msgSecureRes = R.string.maswe_0033_msg_globally_exposed_bridges_secure,
        icon = Icons.Default.Language
    ),
    APP_OWNED_SCRIPTS_PAGE_WORLD(
        titleSecureRes = R.string.maswe_0033_vector_app_owned_scripts_page_world_secure,
        msgSecureRes = R.string.maswe_0033_msg_app_owned_scripts_page_world_secure,
        icon = Icons.Default.Javascript
    ),
    SENSITIVE_DATA_IN_BRIDGE_REPLIES(
        titleSecureRes = R.string.maswe_0033_vector_sensitive_data_in_bridge_replies_secure,
        msgSecureRes = R.string.maswe_0033_msg_sensitive_data_in_bridge_replies_secure,
        icon = Icons.Default.Security
    ),
    OVER_EXPOSED_BRIDGES(
        titleSecureRes = R.string.maswe_0033_vector_over_exposed_bridges_secure,
        msgSecureRes = R.string.maswe_0033_msg_over_exposed_bridges_secure,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0033"
    override val screenTitleSecureRes = R.string.maswe_0033_secure_title
    override val screenDescSecureRes = R.string.maswe_0033_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0033_secure_vectors_title
}
