package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0053Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_EMULATOR_CHECKS(
        titleSecureRes = R.string.maswe_0053_vector_no_emulator_checks_secure,
        msgSecureRes = R.string.maswe_0053_msg_no_emulator_checks_secure,
        icon = Icons.Default.Android
    ),
    SINGLE_SOURCE_DETECTION_SIGNALS(
        titleSecureRes = R.string.maswe_0053_vector_single_source_detection_signals_secure,
        msgSecureRes = R.string.maswe_0053_msg_single_source_detection_signals_secure,
        icon = Icons.Default.SettingsCell
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0053_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0053_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0053"
    override val screenTitleSecureRes = R.string.maswe_0053_secure_title
    override val screenDescSecureRes = R.string.maswe_0053_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0053_secure_vectors_title
}
