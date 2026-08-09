package com.hasantuncay.mobsec.maswe0061.common

import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Vector
import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Mitigation
import com.hasantuncay.mobsec.maswe0061.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0061Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    VERBOSE_LOGGING_ACTIVE(
        titleRes = R.string.maswe_0061_vector_verbose_logging_active_vuln,
        msgRes = R.string.maswe_0061_msg_verbose_logging_active_vuln,
        icon = Icons.Default.BugReport
    ),
    TESTING_UTILITIES_ENABLED(
        titleRes = R.string.maswe_0061_vector_testing_utilities_enabled_vuln,
        msgRes = R.string.maswe_0061_msg_testing_utilities_enabled_vuln,
        icon = Icons.Default.Build
    ),
    DEBUGGING_SYMBOLS_NOT_STRIPPED(
        titleRes = R.string.maswe_0061_vector_debugging_symbols_not_stripped_vuln,
        msgRes = R.string.maswe_0061_msg_debugging_symbols_not_stripped_vuln,
        icon = Icons.Default.Subtitles
    ),
    BACKDOORS_OR_HIDDEN_SWITCHES(
        titleRes = R.string.maswe_0061_vector_backdoors_or_hidden_switches_vuln,
        msgRes = R.string.maswe_0061_msg_backdoors_or_hidden_switches_vuln,
        icon = Icons.Default.DoorBack
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0061",
            titleRes = CommonR.string.maswe_0061_vuln_title,
            descRes = CommonR.string.maswe_0061_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0061_vuln_vectors_title
        )
    }
}
