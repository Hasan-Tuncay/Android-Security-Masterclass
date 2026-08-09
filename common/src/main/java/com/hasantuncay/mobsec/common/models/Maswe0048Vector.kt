package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0048Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MALICIOUS_DEVELOPER(
        titleVulnRes = R.string.maswe_0048_vector_malicious_developer_vuln,
        msgVulnRes = R.string.maswe_0048_msg_malicious_developer_vuln,
        icon = Icons.Default.PersonOff
    ),
    COMPROMISED_DEPENDENCIES(
        titleVulnRes = R.string.maswe_0048_vector_compromised_dependencies_vuln,
        msgVulnRes = R.string.maswe_0048_msg_compromised_dependencies_vuln,
        icon = Icons.Default.BugReport
    ),
    COMPROMISED_BUILD_PIPELINE(
        titleVulnRes = R.string.maswe_0048_vector_compromised_build_pipeline_vuln,
        msgVulnRes = R.string.maswe_0048_msg_compromised_build_pipeline_vuln,
        icon = Icons.Default.BuildCircle
    ),
    HIDDEN_FUNCTIONALITY(
        titleVulnRes = R.string.maswe_0048_vector_hidden_functionality_vuln,
        msgVulnRes = R.string.maswe_0048_msg_hidden_functionality_vuln,
        icon = Icons.Default.VisibilityOff
    );

    override val masweId = "MASWE-0048"
    override val screenTitleVulnRes = R.string.maswe_0048_vuln_title
    override val screenDescVulnRes = R.string.maswe_0048_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0048_vuln_vectors_title
}
