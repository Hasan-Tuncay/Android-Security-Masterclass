package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0065Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_INSTRUMENTATION_CHECKS(
        titleRes = R.string.maswe_0065_vector_no_instrumentation_checks_vuln,
        msgRes = R.string.maswe_0065_msg_no_instrumentation_checks_vuln,
        icon = Icons.Default.AutoFixOff
    ),
    ARTIFACT_CHECKS_MISSING(
        titleRes = R.string.maswe_0065_vector_artifact_checks_missing_vuln,
        msgRes = R.string.maswe_0065_msg_artifact_checks_missing_vuln,
        icon = Icons.Default.FactCheck
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0065_vector_no_response_strategy_vuln,
        msgRes = R.string.maswe_0065_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0065",
            titleRes = R.string.maswe_0065_vuln_title,
            descRes = R.string.maswe_0065_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0065_vuln_vectors_title
        )
    }
}
