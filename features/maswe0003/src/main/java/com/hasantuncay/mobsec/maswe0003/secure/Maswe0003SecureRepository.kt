package com.hasantuncay.mobsec.maswe0003.secure

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import dagger.hilt.android.qualifiers.ApplicationContext
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Maswe0003SecureRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val keyAlias = "maswe0003_secure_key"

    suspend fun executeMitigation(mitigation: Maswe0003Mitigation, appData: MasterclassData): String = withContext(Dispatchers.IO) {
        when (mitigation) {
            Maswe0003Mitigation.INSECURE_STORAGE_LOCATION -> {
                // MITIGATION 1: Generate and store the key purely in the Android Keystore
                generateKeyInKeystore(keyAlias, useStrongBox = false)
                "Key securely generated inside Android Keystore. Raw key bytes never leave the secure hardware."
            }
            Maswe0003Mitigation.HARDCODED_KEY -> {
                // MITIGATION 2: Runtime generation via Keystore (avoid hardcoding)
                val runtimeAlias = "maswe0003_runtime_key"
                generateKeyInKeystore(runtimeAlias, useStrongBox = true) // Prefer StrongBox for highest security
                
                // Check if key exists in Keystore to prove it works
                val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
                val hasKey = keyStore.containsAlias(runtimeAlias)
                
                "Generated key dynamically at runtime. StrongBox backend used (if supported). Verified in Keystore: $hasKey"
            }
            Maswe0003Mitigation.INSECURE_KEY_IMPORT -> {
                // MITIGATION 3: Do not import raw plaintext keys. Use wrapped key import.
                // (Detailed wrapped key import requires an ASN.1 SecureKeyWrapper structure, so we document it)
                "To securely import keys from a server, use Keystore Wrapped Key Import (requires ASN.1 wrapping format) or avoid importing symmetric keys entirely by using Asymmetric envelope encryption."
            }
        }
    }

    private fun generateKeyInKeystore(alias: String, useStrongBox: Boolean) {
        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES,
            "AndroidKeyStore"
        )
        
        val builder = KeyGenParameterSpec.Builder(
            alias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
        .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
        
        if (useStrongBox && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            builder.setIsStrongBoxBacked(true)
            try {
                keyGenerator.init(builder.build())
                keyGenerator.generateKey()
                return // Success with StrongBox
            } catch (e: Exception) {
                if (e is kotlinx.coroutines.CancellationException) throw e
                // Fallback to standard hardware keystore if StrongBox is unavailable
                builder.setIsStrongBoxBacked(false)
            }
        }
        
        keyGenerator.init(builder.build())
        keyGenerator.generateKey()
    }
}
