package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0052Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_VIRTUALIZATION_CHECKS(
        titleRes = R.string.maswe_0052_vector_no_virtualization_checks_vuln,
        msgRes = R.string.maswe_0052_msg_no_virtualization_checks_vuln,
        icon = Icons.Default.LaptopWindows
    ),
    KNOWN_FRAMEWORKS_NOT_DETECTED(
        titleRes = R.string.maswe_0052_vector_known_frameworks_not_detected_vuln,
        msgRes = R.string.maswe_0052_msg_known_frameworks_not_detected_vuln,
        icon = Icons.Default.Warning
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0052_vector_no_response_strategy_vuln,
        msgRes = R.string.maswe_0052_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0052",
            titleRes = R.string.maswe_0052_vuln_title,
            descRes = R.string.maswe_0052_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0052_vuln_vectors_title
        )
    }
}
