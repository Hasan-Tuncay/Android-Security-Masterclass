package com.hasantuncay.mobsec.maswe0005.common

import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Mitigation
import com.hasantuncay.mobsec.maswe0005.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0005Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SYSTEM_CONSOLE(
        titleRes = R.string.maswe_0005_vector_sys_console_vuln,
        msgRes = R.string.maswe_0005_msg_sys_console_vuln,
        icon = Icons.Default.Terminal
    ),
    NETWORK_INTERCEPTOR(
        titleRes = R.string.maswe_0005_vector_network_vuln,
        msgRes = R.string.maswe_0005_msg_network_vuln,
        icon = Icons.Default.NetworkWifi
    ),
    LOCAL_FILE(
        titleRes = R.string.maswe_0005_vector_local_file_vuln,
        msgRes = R.string.maswe_0005_msg_local_file_vuln,
        icon = Icons.Default.Save
    ),
    SDK_TELEMETRY(
        titleRes = R.string.maswe_0005_vector_sdk_vuln,
        msgRes = R.string.maswe_0005_msg_sdk_vuln,
        icon = Icons.Default.BugReport
    ),
    WEBVIEW_CONSOLE(
        titleRes = R.string.maswe_0005_vector_webview_vuln,
        msgRes = R.string.maswe_0005_msg_webview_vuln,
        icon = Icons.Default.Language
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0005",
            titleRes = CommonR.string.maswe_0005_vuln_title,
            descRes = CommonR.string.maswe_0005_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0005_vuln_vectors_title
        )
    }
}
