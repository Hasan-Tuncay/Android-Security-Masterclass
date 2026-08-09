package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

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
enum class Maswe0004Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SOURCE_CODE(
        titleVulnRes = R.string.maswe_0004_vector_source_code_vuln,
        msgVulnRes = R.string.maswe_0004_msg_source_code_vuln,
        icon = Icons.Default.Code
    ),

    ASSETS_AND_RESOURCES(
        titleVulnRes = R.string.maswe_0004_vector_assets_vuln,
        msgVulnRes = R.string.maswe_0004_msg_assets_vuln,
        icon = Icons.Default.FolderSpecial
    ),

    THIRD_PARTY_LIBRARY(
        titleVulnRes = R.string.maswe_0004_vector_library_vuln,
        msgVulnRes = R.string.maswe_0004_msg_library_vuln,
        icon = Icons.Default.LibraryBooks
    ),

    BUILD_LEFTOVERS(
        titleVulnRes = R.string.maswe_0004_vector_build_leftovers_vuln,
        msgVulnRes = R.string.maswe_0004_msg_build_leftovers_vuln,
        icon = Icons.Default.Build
    );

    override val masweId = "MASWE-0004"
    override val screenTitleVulnRes = R.string.maswe_0004_vuln_title
    override val screenDescVulnRes = R.string.maswe_0004_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0004_vuln_vectors_title
}
