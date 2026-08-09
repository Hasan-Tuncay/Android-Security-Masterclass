package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0048Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MALICIOUS_DEVELOPER(
        titleRes = R.string.maswe_0048_vector_malicious_developer_vuln,
        msgRes = R.string.maswe_0048_msg_malicious_developer_vuln,
        icon = Icons.Default.PersonOff
    ),
    COMPROMISED_DEPENDENCIES(
        titleRes = R.string.maswe_0048_vector_compromised_dependencies_vuln,
        msgRes = R.string.maswe_0048_msg_compromised_dependencies_vuln,
        icon = Icons.Default.BugReport
    ),
    COMPROMISED_BUILD_PIPELINE(
        titleRes = R.string.maswe_0048_vector_compromised_build_pipeline_vuln,
        msgRes = R.string.maswe_0048_msg_compromised_build_pipeline_vuln,
        icon = Icons.Default.BuildCircle
    ),
    HIDDEN_FUNCTIONALITY(
        titleRes = R.string.maswe_0048_vector_hidden_functionality_vuln,
        msgRes = R.string.maswe_0048_msg_hidden_functionality_vuln,
        icon = Icons.Default.VisibilityOff
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0048",
            titleRes = R.string.maswe_0048_vuln_title,
            descRes = R.string.maswe_0048_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0048_vuln_vectors_title
        )
    }
}
