package com.hasantuncay.mobsec.maswe0064.common

import com.hasantuncay.mobsec.maswe0064.common.Maswe0064Vector
import com.hasantuncay.mobsec.maswe0064.common.Maswe0064Mitigation
import com.hasantuncay.mobsec.maswe0064.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0064Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_DEBUGGER_CHECKS(
        titleRes = R.string.maswe_0064_vector_no_debugger_checks_secure,
        msgRes = R.string.maswe_0064_msg_no_debugger_checks_secure,
        icon = Icons.Default.PestControl
    ),
    ONE_TIME_CHECKS(
        titleRes = R.string.maswe_0064_vector_one_time_checks_secure,
        msgRes = R.string.maswe_0064_msg_one_time_checks_secure,
        icon = Icons.Default.AvTimer
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0064_vector_no_response_strategy_secure,
        msgRes = R.string.maswe_0064_msg_no_response_strategy_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0064",
            titleRes = CommonR.string.maswe_0064_secure_title,
            descRes = CommonR.string.maswe_0064_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0064_secure_vectors_title
        )
    }
}
