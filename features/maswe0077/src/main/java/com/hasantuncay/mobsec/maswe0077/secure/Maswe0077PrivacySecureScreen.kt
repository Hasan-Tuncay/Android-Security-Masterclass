package com.hasantuncay.mobsec.maswe0077.secure

import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Vector
import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Mitigation
import com.hasantuncay.mobsec.maswe0077.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0077PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0077Mitigation.meta,
        vectors = Maswe0077Mitigation.entries,
        onBack = onBack
    )
}
