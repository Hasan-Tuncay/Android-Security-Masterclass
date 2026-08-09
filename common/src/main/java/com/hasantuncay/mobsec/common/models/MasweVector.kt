package com.hasantuncay.mobsec.common.models

import androidx.compose.ui.graphics.vector.ImageVector

interface MasweVector {
    val name: String
    val titleVulnRes: Int
    val msgVulnRes: Int
    val icon: ImageVector

    // Screen-level metadata (common across all vectors in the same MASWE)
    val masweId: String
    val screenTitleVulnRes: Int
    val screenDescVulnRes: Int
    val contextInfoRes: Int?
    val vectorsTitleVulnRes: Int

    fun getAdbCommandVuln(resultPath: String?): String = ""
}
