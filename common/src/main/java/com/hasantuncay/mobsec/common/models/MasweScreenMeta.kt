package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes

/**
 * Screen-level metadata for a MASWE module.
 * One instance per MASWE ID, shared across all vectors/mitigations in that module.
 * This eliminates repetitive overrides in every enum entry.
 */
data class MasweScreenMeta(
    val masweId: String,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int,
    @StringRes val contextInfoRes: Int? = null,
    @StringRes val itemsTitleRes: Int
)
