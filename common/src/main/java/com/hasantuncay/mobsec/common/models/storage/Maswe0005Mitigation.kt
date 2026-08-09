package com.hasantuncay.mobsec.common.models.storage

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0005Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SYSTEM_CONSOLE(
        titleRes = R.string.maswe_0005_vector_sys_console_secure,
        msgRes = R.string.maswe_0005_msg_sys_console_secure,
        icon = Icons.Default.Terminal
    ),
    NETWORK_INTERCEPTOR(
        titleRes = R.string.maswe_0005_vector_network_secure,
        msgRes = R.string.maswe_0005_msg_network_secure,
        icon = Icons.Default.NetworkWifi
    ),
    LOCAL_FILE(
        titleRes = R.string.maswe_0005_vector_local_file_secure,
        msgRes = R.string.maswe_0005_msg_local_file_secure,
        icon = Icons.Default.Save
    ),
    SDK_TELEMETRY(
        titleRes = R.string.maswe_0005_vector_sdk_secure,
        msgRes = R.string.maswe_0005_msg_sdk_secure,
        icon = Icons.Default.BugReport
    ),
    WEBVIEW_CONSOLE(
        titleRes = R.string.maswe_0005_vector_webview_secure,
        msgRes = R.string.maswe_0005_msg_webview_secure,
        icon = Icons.Default.Language
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0005",
            titleRes = R.string.maswe_0005_secure_title,
            descRes = R.string.maswe_0005_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0005_secure_vectors_title
        )
    }
}
