package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0061Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    VERBOSE_LOGGING_ACTIVE(
        titleSecureRes = R.string.maswe_0061_vector_verbose_logging_active_secure,
        msgSecureRes = R.string.maswe_0061_msg_verbose_logging_active_secure,
        icon = Icons.Default.BugReport
    ),
    TESTING_UTILITIES_ENABLED(
        titleSecureRes = R.string.maswe_0061_vector_testing_utilities_enabled_secure,
        msgSecureRes = R.string.maswe_0061_msg_testing_utilities_enabled_secure,
        icon = Icons.Default.Build
    ),
    DEBUGGING_SYMBOLS_NOT_STRIPPED(
        titleSecureRes = R.string.maswe_0061_vector_debugging_symbols_not_stripped_secure,
        msgSecureRes = R.string.maswe_0061_msg_debugging_symbols_not_stripped_secure,
        icon = Icons.Default.Subtitles
    ),
    BACKDOORS_OR_HIDDEN_SWITCHES(
        titleSecureRes = R.string.maswe_0061_vector_backdoors_or_hidden_switches_secure,
        msgSecureRes = R.string.maswe_0061_msg_backdoors_or_hidden_switches_secure,
        icon = Icons.Default.DoorBack
    );

    override val masweId = "MASWE-0061"
    override val screenTitleSecureRes = R.string.maswe_0061_secure_title
    override val screenDescSecureRes = R.string.maswe_0061_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0061_secure_vectors_title
}
