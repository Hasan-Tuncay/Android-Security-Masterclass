package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0053Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_EMULATOR_CHECKS(
        titleVulnRes = R.string.maswe_0053_vector_no_emulator_checks_vuln,
        msgVulnRes = R.string.maswe_0053_msg_no_emulator_checks_vuln,
        icon = Icons.Default.Android
    ),
    SINGLE_SOURCE_DETECTION_SIGNALS(
        titleVulnRes = R.string.maswe_0053_vector_single_source_detection_signals_vuln,
        msgVulnRes = R.string.maswe_0053_msg_single_source_detection_signals_vuln,
        icon = Icons.Default.SettingsCell
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0053_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0053_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0053"
    override val screenTitleVulnRes = R.string.maswe_0053_vuln_title
    override val screenDescVulnRes = R.string.maswe_0053_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0053_vuln_vectors_title
}
