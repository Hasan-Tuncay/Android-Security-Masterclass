package com.hasantuncay.mobsec.maswe0052.common

import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Vector
import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Mitigation
import com.hasantuncay.mobsec.maswe0052.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0052Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_VIRTUALIZATION_CHECKS(
        titleRes = R.string.maswe_0052_vector_no_virtualization_checks_secure,
        msgRes = R.string.maswe_0052_msg_no_virtualization_checks_secure,
        icon = Icons.Default.LaptopWindows
    ),
    KNOWN_FRAMEWORKS_NOT_DETECTED(
        titleRes = R.string.maswe_0052_vector_known_frameworks_not_detected_secure,
        msgRes = R.string.maswe_0052_msg_known_frameworks_not_detected_secure,
        icon = Icons.Default.Warning
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0052_vector_no_response_strategy_secure,
        msgRes = R.string.maswe_0052_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0052",
            titleRes = CommonR.string.maswe_0052_secure_title,
            descRes = CommonR.string.maswe_0052_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0052_secure_vectors_title
        )
    }
}
