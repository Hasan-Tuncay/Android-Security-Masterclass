package com.hasantuncay.mobsec.common.models.storage

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Defines the vulnerability attack vectors demonstrated in the MASWE-0004 module.
 *
 * MASWE-0004: Sensitive Data Hardcoded in the App Package
 * MASVS:      MASVS-STORAGE-1, MASVS-CRYPTO-2
 *
 * Modes of Introduction (from MASWE repo):
 * - App Source Code: Secrets embedded directly in compiled app code
 * - App Assets and Resources: Secrets in config files, manifests, string resources, etc.
 * - Libraries: Secrets in first-party, third-party, or transitive dependency code/config
 * - Build and Developer Leftovers: Staging endpoints, dev identities, source files packaged
 */
enum class Maswe0004Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SOURCE_CODE(
        titleRes = R.string.maswe_0004_vector_source_code_secure,
        msgRes = R.string.maswe_0004_msg_source_code_secure,
        icon = Icons.Default.Code
    ),

    ASSETS_AND_RESOURCES(
        titleRes = R.string.maswe_0004_vector_assets_secure,
        msgRes = R.string.maswe_0004_msg_assets_secure,
        icon = Icons.Default.FolderSpecial
    ),

    THIRD_PARTY_LIBRARY(
        titleRes = R.string.maswe_0004_vector_library_secure,
        msgRes = R.string.maswe_0004_msg_library_secure,
        icon = Icons.Default.LibraryBooks
    ),

    BUILD_LEFTOVERS(
        titleRes = R.string.maswe_0004_vector_build_leftovers_secure,
        msgRes = R.string.maswe_0004_msg_build_leftovers_secure,
        icon = Icons.Default.Build
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0004",
            titleRes = R.string.maswe_0004_secure_title,
            descRes = R.string.maswe_0004_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0004_secure_vectors_title
        )
    }
}
