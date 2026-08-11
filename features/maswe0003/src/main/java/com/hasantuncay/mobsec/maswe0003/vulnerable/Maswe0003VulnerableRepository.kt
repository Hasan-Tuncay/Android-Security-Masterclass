package com.hasantuncay.mobsec.maswe0003.vulnerable

import android.content.Context
import android.util.Base64
import android.util.Log
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Maswe0003VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    // VULNERABILITY 2: Hardcoded Key
    // Never hardcode cryptographic keys in source code!
    private val hardcodedAesKey = byteArrayOf(
        0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
        0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10
    )

    suspend fun executeVector(vector: Maswe0003Vector, appData: MasterclassData): String = withContext(Dispatchers.IO) {
        when (vector) {
            Maswe0003Vector.INSECURE_STORAGE_LOCATION -> {
                // VULNERABILITY 1: Storing raw key in SharedPreferences
                val keyGen = KeyGenerator.getInstance("AES")
                keyGen.init(256)
                val secretKey: SecretKey = keyGen.generateKey()
                val encodedKey = Base64.encodeToString(secretKey.encoded, Base64.DEFAULT)

                val prefs = context.getSharedPreferences("crypto_key", Context.MODE_PRIVATE)
                prefs.edit().putString("aes_key", encodedKey).apply()

                "Key generated and saved in plain text to SharedPreferences: crypto_key.xml"
            }
            Maswe0003Vector.HARDCODED_KEY -> {
                // Simulate using the hardcoded key
                val keyHex = hardcodedAesKey.joinToString("") { "%02x".format(it) }
                "Using hardcoded AES key from source code: $keyHex"
            }
            Maswe0003Vector.INSECURE_KEY_IMPORT -> {
                // VULNERABILITY 3: Passing key material in plaintext and logging it
                val importedKey = "plaintext_key_material_12345"
                Log.d("MASWE_0003_KEY_IMPORT", "Importing key: $importedKey")
                "Key imported in plaintext and leaked to Logcat. Check ADB."
            }
        }
    }
}
