package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0048Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MALICIOUS_DEVELOPER(
        titleSecureRes = R.string.maswe_0048_vector_malicious_developer_secure,
        msgSecureRes = R.string.maswe_0048_msg_malicious_developer_secure,
        icon = Icons.Default.PersonOff
    ),
    COMPROMISED_DEPENDENCIES(
        titleSecureRes = R.string.maswe_0048_vector_compromised_dependencies_secure,
        msgSecureRes = R.string.maswe_0048_msg_compromised_dependencies_secure,
        icon = Icons.Default.BugReport
    ),
    COMPROMISED_BUILD_PIPELINE(
        titleSecureRes = R.string.maswe_0048_vector_compromised_build_pipeline_secure,
        msgSecureRes = R.string.maswe_0048_msg_compromised_build_pipeline_secure,
        icon = Icons.Default.BuildCircle
    ),
    HIDDEN_FUNCTIONALITY(
        titleSecureRes = R.string.maswe_0048_vector_hidden_functionality_secure,
        msgSecureRes = R.string.maswe_0048_msg_hidden_functionality_secure,
        icon = Icons.Default.VisibilityOff
    );

    override val masweId = "MASWE-0048"
    override val screenTitleSecureRes = R.string.maswe_0048_secure_title
    override val screenDescSecureRes = R.string.maswe_0048_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0048_secure_vectors_title
}
