package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0046Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DEPRECATED_CRYPTOGRAPHIC_PROVIDERS(
        titleSecureRes = R.string.maswe_0046_vector_deprecated_cryptographic_providers_secure,
        msgSecureRes = R.string.maswe_0046_msg_deprecated_cryptographic_providers_secure,
        icon = Icons.Default.NoEncryption
    ),
    DEPRECATED_PLATFORM_APIS(
        titleSecureRes = R.string.maswe_0046_vector_deprecated_platform_apis_secure,
        msgSecureRes = R.string.maswe_0046_msg_deprecated_platform_apis_secure,
        icon = Icons.Default.Api
    ),
    DEPRECATION_WARNINGS_IGNORED(
        titleSecureRes = R.string.maswe_0046_vector_deprecation_warnings_ignored_secure,
        msgSecureRes = R.string.maswe_0046_msg_deprecation_warnings_ignored_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0046"
    override val screenTitleSecureRes = R.string.maswe_0046_secure_title
    override val screenDescSecureRes = R.string.maswe_0046_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0046_secure_vectors_title
}
