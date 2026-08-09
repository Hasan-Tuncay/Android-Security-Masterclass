package com.hasantuncay.mobsec.maswe0048.common

import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Vector
import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Mitigation
import com.hasantuncay.mobsec.maswe0048.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0048Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MALICIOUS_DEVELOPER(
        titleRes = R.string.maswe_0048_vector_malicious_developer_secure,
        msgRes = R.string.maswe_0048_msg_malicious_developer_secure,
        icon = Icons.Default.PersonOff
    ),
    COMPROMISED_DEPENDENCIES(
        titleRes = R.string.maswe_0048_vector_compromised_dependencies_secure,
        msgRes = R.string.maswe_0048_msg_compromised_dependencies_secure,
        icon = Icons.Default.BugReport
    ),
    COMPROMISED_BUILD_PIPELINE(
        titleRes = R.string.maswe_0048_vector_compromised_build_pipeline_secure,
        msgRes = R.string.maswe_0048_msg_compromised_build_pipeline_secure,
        icon = Icons.Default.BuildCircle
    ),
    HIDDEN_FUNCTIONALITY(
        titleRes = R.string.maswe_0048_vector_hidden_functionality_secure,
        msgRes = R.string.maswe_0048_msg_hidden_functionality_secure,
        icon = Icons.Default.VisibilityOff
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0048",
            titleRes = CommonR.string.maswe_0048_secure_title,
            descRes = CommonR.string.maswe_0048_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0048_secure_vectors_title
        )
    }
}
