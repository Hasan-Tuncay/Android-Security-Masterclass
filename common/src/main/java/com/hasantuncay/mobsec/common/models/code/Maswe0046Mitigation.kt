package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0046Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DEPRECATED_CRYPTOGRAPHIC_PROVIDERS(
        titleRes = R.string.maswe_0046_vector_deprecated_cryptographic_providers_secure,
        msgRes = R.string.maswe_0046_msg_deprecated_cryptographic_providers_secure,
        icon = Icons.Default.NoEncryption
    ),
    DEPRECATED_PLATFORM_APIS(
        titleRes = R.string.maswe_0046_vector_deprecated_platform_apis_secure,
        msgRes = R.string.maswe_0046_msg_deprecated_platform_apis_secure,
        icon = Icons.Default.Api
    ),
    DEPRECATION_WARNINGS_IGNORED(
        titleRes = R.string.maswe_0046_vector_deprecation_warnings_ignored_secure,
        msgRes = R.string.maswe_0046_msg_deprecation_warnings_ignored_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0046",
            titleRes = R.string.maswe_0046_secure_title,
            descRes = R.string.maswe_0046_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0046_secure_vectors_title
        )
    }
}
