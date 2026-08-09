package com.hasantuncay.mobsec.maswe0046.common

import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Vector
import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Mitigation
import com.hasantuncay.mobsec.maswe0046.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0046Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DEPRECATED_CRYPTOGRAPHIC_PROVIDERS(
        titleRes = R.string.maswe_0046_vector_deprecated_cryptographic_providers_vuln,
        msgRes = R.string.maswe_0046_msg_deprecated_cryptographic_providers_vuln,
        icon = Icons.Default.NoEncryption
    ),
    DEPRECATED_PLATFORM_APIS(
        titleRes = R.string.maswe_0046_vector_deprecated_platform_apis_vuln,
        msgRes = R.string.maswe_0046_msg_deprecated_platform_apis_vuln,
        icon = Icons.Default.Api
    ),
    DEPRECATION_WARNINGS_IGNORED(
        titleRes = R.string.maswe_0046_vector_deprecation_warnings_ignored_vuln,
        msgRes = R.string.maswe_0046_msg_deprecation_warnings_ignored_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0046",
            titleRes = CommonR.string.maswe_0046_vuln_title,
            descRes = CommonR.string.maswe_0046_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0046_vuln_vectors_title
        )
    }
}
