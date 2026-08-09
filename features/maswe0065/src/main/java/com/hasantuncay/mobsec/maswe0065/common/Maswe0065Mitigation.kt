package com.hasantuncay.mobsec.maswe0065.common

import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Vector
import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Mitigation
import com.hasantuncay.mobsec.maswe0065.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0065Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_INSTRUMENTATION_CHECKS(
        titleRes = R.string.maswe_0065_vector_no_instrumentation_checks_secure,
        msgRes = R.string.maswe_0065_msg_no_instrumentation_checks_secure,
        icon = Icons.Default.AutoFixOff
    ),
    ARTIFACT_CHECKS_MISSING(
        titleRes = R.string.maswe_0065_vector_artifact_checks_missing_secure,
        msgRes = R.string.maswe_0065_msg_artifact_checks_missing_secure,
        icon = Icons.AutoMirrored.Filled.FactCheck
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0065_vector_no_response_strategy_secure,
        msgRes = R.string.maswe_0065_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0065",
            titleRes = CommonR.string.maswe_0065_secure_title,
            descRes = CommonR.string.maswe_0065_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0065_secure_vectors_title
        )
    }
}
