package com.hasantuncay.mobsec.common.models

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Base interface for all MASWE items (both vulnerability vectors and secure mitigations).
 * Each item represents a single demonstrable scenario within a MASWE module.
 */
interface MasweItem {
    val name: String
    val titleRes: Int
    val msgRes: Int
    val icon: ImageVector
    fun getAdbCommand(resultPath: String?): String = ""
}
