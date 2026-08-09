package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0061Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    VERBOSE_LOGGING_ACTIVE(
        titleRes = R.string.maswe_0061_vector_verbose_logging_active_secure,
        msgRes = R.string.maswe_0061_msg_verbose_logging_active_secure,
        icon = Icons.Default.BugReport
    ),
    TESTING_UTILITIES_ENABLED(
        titleRes = R.string.maswe_0061_vector_testing_utilities_enabled_secure,
        msgRes = R.string.maswe_0061_msg_testing_utilities_enabled_secure,
        icon = Icons.Default.Build
    ),
    DEBUGGING_SYMBOLS_NOT_STRIPPED(
        titleRes = R.string.maswe_0061_vector_debugging_symbols_not_stripped_secure,
        msgRes = R.string.maswe_0061_msg_debugging_symbols_not_stripped_secure,
        icon = Icons.Default.Subtitles
    ),
    BACKDOORS_OR_HIDDEN_SWITCHES(
        titleRes = R.string.maswe_0061_vector_backdoors_or_hidden_switches_secure,
        msgRes = R.string.maswe_0061_msg_backdoors_or_hidden_switches_secure,
        icon = Icons.Default.DoorBack
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0061",
            titleRes = R.string.maswe_0061_secure_title,
            descRes = R.string.maswe_0061_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0061_secure_vectors_title
        )
    }
}
