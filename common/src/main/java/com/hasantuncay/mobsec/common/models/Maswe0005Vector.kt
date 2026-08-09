package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0005Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SYSTEM_CONSOLE(
        titleVulnRes = R.string.maswe_0005_vector_sys_console_vuln,
        msgVulnRes = R.string.maswe_0005_msg_sys_console_vuln,
        icon = Icons.Default.Terminal
    ),
    NETWORK_INTERCEPTOR(
        titleVulnRes = R.string.maswe_0005_vector_network_vuln,
        msgVulnRes = R.string.maswe_0005_msg_network_vuln,
        icon = Icons.Default.NetworkWifi
    ),
    LOCAL_FILE(
        titleVulnRes = R.string.maswe_0005_vector_local_file_vuln,
        msgVulnRes = R.string.maswe_0005_msg_local_file_vuln,
        icon = Icons.Default.Save
    ),
    SDK_TELEMETRY(
        titleVulnRes = R.string.maswe_0005_vector_sdk_vuln,
        msgVulnRes = R.string.maswe_0005_msg_sdk_vuln,
        icon = Icons.Default.BugReport
    ),
    WEBVIEW_CONSOLE(
        titleVulnRes = R.string.maswe_0005_vector_webview_vuln,
        msgVulnRes = R.string.maswe_0005_msg_webview_vuln,
        icon = Icons.Default.Language
    );

    override val masweId = "MASWE-0005"
    override val screenTitleVulnRes = R.string.maswe_0005_vuln_title
    override val screenDescVulnRes = R.string.maswe_0005_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0005_vuln_vectors_title
}
