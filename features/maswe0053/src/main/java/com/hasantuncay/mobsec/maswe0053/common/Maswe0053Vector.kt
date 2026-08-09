package com.hasantuncay.mobsec.maswe0053.common

import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Vector
import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Mitigation
import com.hasantuncay.mobsec.maswe0053.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0053Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_EMULATOR_CHECKS(
        titleRes = R.string.maswe_0053_vector_no_emulator_checks_vuln,
        msgRes = R.string.maswe_0053_msg_no_emulator_checks_vuln,
        icon = Icons.Default.Android
    ),
    SINGLE_SOURCE_DETECTION_SIGNALS(
        titleRes = R.string.maswe_0053_vector_single_source_detection_signals_vuln,
        msgRes = R.string.maswe_0053_msg_single_source_detection_signals_vuln,
        icon = Icons.Default.SettingsCell
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0053_vector_no_response_strategy_vuln,
        msgRes = R.string.maswe_0053_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0053",
            titleRes = CommonR.string.maswe_0053_vuln_title,
            descRes = CommonR.string.maswe_0053_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0053_vuln_vectors_title
        )
    }
}
