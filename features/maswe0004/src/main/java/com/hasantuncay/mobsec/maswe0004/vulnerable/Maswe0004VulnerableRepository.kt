package com.hasantuncay.mobsec.maswe0004.vulnerable

import android.content.Context
import android.util.Log
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Maswe0004VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        // ❌ VULNERABILITY: Hardcoded Master Secret Key in source code (CWE-798)
        private const val HARDCODED_PAYMENT_SECRET = "mock_secret_payment_key_sample_insecure_12345"
        private const val HARDCODED_STAGING_ENDPOINT = "https://internal-dev-api.masterclass.security/v1/debug"
    }

    suspend fun executeVector(
        vector: Maswe0004Vector,
        appData: MasterclassData
    ): String? = withContext(Dispatchers.IO) {
        when (vector) {
            Maswe0004Vector.SOURCE_CODE -> {
                Log.e("MASWE_0004", "Vector 1: Hardcoded payment secret exposed in compiled DEX: $HARDCODED_PAYMENT_SECRET")
                "EXPOSED IN DEX: $HARDCODED_PAYMENT_SECRET (Extractable via jadx or apktool)"
            }
            Maswe0004Vector.ASSETS_AND_RESOURCES -> {
                val resourceKey = "res/values/strings.xml -> cloud_storage_api_key"
                Log.e("MASWE_0004", "Vector 2: Plaintext secret stored in app XML resources: $resourceKey")
                "EXPOSED IN RESOURCES: $resourceKey (No decompilation needed, readable in APK archive)"
            }
            Maswe0004Vector.THIRD_PARTY_LIBRARY -> {
                val leakedSdkKey = "com.thirdparty.analytics.CoreConfig -> BACKDOOR_TEST_KEY_443"
                Log.e("MASWE_0004", "Vector 3: Embedded test secret in bundled 3rd-party library: $leakedSdkKey")
                "EXPOSED IN 3RD-PARTY SDK: $leakedSdkKey (Transitive dependency vulnerability)"
            }
            Maswe0004Vector.BUILD_LEFTOVERS -> {
                Log.e("MASWE_0004", "Vector 4: Staging endpoint and test credentials bundled in release: $HARDCODED_STAGING_ENDPOINT")
                "EXPOSED BUILD LEFTOVER: $HARDCODED_STAGING_ENDPOINT (Internal network surface exposed)"
            }
        }
    }
}
