package com.hasantuncay.mobsec.common.models

import androidx.compose.ui.graphics.vector.ImageVector

interface MasweMitigation {
    val name: String
    val titleSecureRes: Int
    val msgSecureRes: Int
    val icon: ImageVector

    // Screen-level metadata (common across all mitigations in the same MASWE)
    val masweId: String
    val screenTitleSecureRes: Int
    val screenDescSecureRes: Int
    val contextInfoRes: Int?
    val vectorsTitleSecureRes: Int

    fun getAdbCommandSecure(resultPath: String?): String = ""
}
