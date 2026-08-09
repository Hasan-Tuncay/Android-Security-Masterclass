package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0061Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    VERBOSE_LOGGING_ACTIVE(
        titleVulnRes = R.string.maswe_0061_vector_verbose_logging_active_vuln,
        msgVulnRes = R.string.maswe_0061_msg_verbose_logging_active_vuln,
        icon = Icons.Default.BugReport
    ),
    TESTING_UTILITIES_ENABLED(
        titleVulnRes = R.string.maswe_0061_vector_testing_utilities_enabled_vuln,
        msgVulnRes = R.string.maswe_0061_msg_testing_utilities_enabled_vuln,
        icon = Icons.Default.Build
    ),
    DEBUGGING_SYMBOLS_NOT_STRIPPED(
        titleVulnRes = R.string.maswe_0061_vector_debugging_symbols_not_stripped_vuln,
        msgVulnRes = R.string.maswe_0061_msg_debugging_symbols_not_stripped_vuln,
        icon = Icons.Default.Subtitles
    ),
    BACKDOORS_OR_HIDDEN_SWITCHES(
        titleVulnRes = R.string.maswe_0061_vector_backdoors_or_hidden_switches_vuln,
        msgVulnRes = R.string.maswe_0061_msg_backdoors_or_hidden_switches_vuln,
        icon = Icons.Default.DoorBack
    );

    override val masweId = "MASWE-0061"
    override val screenTitleVulnRes = R.string.maswe_0061_vuln_title
    override val screenDescVulnRes = R.string.maswe_0061_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0061_vuln_vectors_title
}
