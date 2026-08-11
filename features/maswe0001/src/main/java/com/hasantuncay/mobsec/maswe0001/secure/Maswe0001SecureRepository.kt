package com.hasantuncay.mobsec.maswe0001.secure

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.core.content.FileProvider
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Mitigation
import com.hasantuncay.mobsec.common.storage.EncryptedDataStoreSerializer
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Base64

@Singleton
class Maswe0001SecureRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    init {
        AeadConfig.register()
    }

    private fun getTinkAead(): Aead {
        return AndroidKeysetManager.Builder()
            .withSharedPref(context, "maswe0001_v1_keyset", "secure_prefs")
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri("android-keystore://maswe0001_v1_master_key")
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    }

    suspend fun executeVector(
        vector: Maswe0001Mitigation,
        appData: MasterclassData
    ): String? {
        return when (vector) {
            Maswe0001Mitigation.DATA_STORED_SECURELY -> triggerDataStoredSecurely(appData)
            Maswe0001Mitigation.KEY_IN_KEYSTORE -> triggerKeyInKeystore(appData)
            Maswe0001Mitigation.ENVELOPE_ENCRYPTION -> triggerEnvelopeEncryption(appData)
            Maswe0001Mitigation.STRONG_ENCRYPTION -> triggerStrongEncryption(appData)
            Maswe0001Mitigation.PROPER_ACCESS_RESTRICTIONS -> triggerProperAccessRestrictions(appData)
            Maswe0001Mitigation.DATA_REMOVED_AFTER_USE -> triggerDataRemovedAfterUse(appData)
        }
    }

    // MITIGATION 1: Data Stored Securely (DataStore + Tink)
    private suspend fun triggerDataStoredSecurely(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val aead = getTinkAead()
            
            val dataStore = DataStoreFactory.create(
                serializer = EncryptedDataStoreSerializer(aead),
                produceFile = { context.dataStoreFile("maswe0001_v1_secure.json") }
            )
            
            val json = JSONObject().apply {
                put("auth_token", appData.networkSession.oAuth2BearerToken)
            }.toString()
            
            dataStore.updateData { json }

            val file = context.dataStoreFile("maswe0001_v1_secure.json")
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // MITIGATION 2: Key in Android Keystore
    private suspend fun triggerKeyInKeystore(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val alias = "maswe0001_v2_secure_key"
            val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
            
            if (!keyStore.containsAlias(alias)) {
                val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
                val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                    alias,
                    KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
                )
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setKeySize(256)
                    .build()
                keyGenerator.init(keyGenParameterSpec)
                keyGenerator.generateKey()
            }
            
            val secretKey = keyStore.getKey(alias, null) as SecretKey
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val iv = cipher.iv
            val encryptedData = cipher.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())
            
            val file = File(context.filesDir, "maswe0001_v2_secure.enc")
            FileOutputStream(file).use { 
                it.write(iv)
                it.write(encryptedData)
            }
            
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // MITIGATION 3: Envelope Encryption (DEK/KEK)
    private suspend fun triggerEnvelopeEncryption(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            // In a real scenario you would use Tink, but this demonstrates the Envelope pattern:
            // 1. Get KEK from Keystore
            val kekAlias = "maswe0001_v3_kek"
            val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
            if (!keyStore.containsAlias(kekAlias)) {
                val kg = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
                kg.init(KeyGenParameterSpec.Builder(kekAlias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .build())
                kg.generateKey()
            }
            val kek = keyStore.getKey(kekAlias, null) as SecretKey

            // 2. Generate local DEK
            val dekGen = KeyGenerator.getInstance("AES")
            dekGen.init(256)
            val dek = dekGen.generateKey()

            // 3. Encrypt DEK with KEK
            val cipherKek = Cipher.getInstance("AES/GCM/NoPadding")
            cipherKek.init(Cipher.ENCRYPT_MODE, kek)
            val encryptedDek = cipherKek.doFinal(dek.encoded)
            val kekIv = cipherKek.iv

            // 4. Save Encrypted DEK safely to Preferences
            val prefs = context.getSharedPreferences("maswe0001_v3_secure_keys", Context.MODE_PRIVATE)
            prefs.edit().apply {
                putString("encrypted_dek", Base64.getEncoder().encodeToString(encryptedDek))
                putString("kek_iv", Base64.getEncoder().encodeToString(kekIv))
            }.commit()

            // 5. Encrypt actual data with DEK
            val cipherDek = Cipher.getInstance("AES/GCM/NoPadding")
            cipherDek.init(Cipher.ENCRYPT_MODE, dek)
            val ivDek = cipherDek.iv
            val encryptedData = cipherDek.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())

            val file = File(context.filesDir, "maswe0001_v3_secure.enc")
            FileOutputStream(file).use { 
                it.write(ivDek)
                it.write(encryptedData)
            }

            val prefsPath = "${context.applicationInfo.dataDir}/shared_prefs/maswe0001_v3_secure_keys.xml"
            withContext(Dispatchers.Main) { resultPath = prefsPath }
        }
        return resultPath
    }

    // MITIGATION 4: Strong Encryption Algorithm
    private suspend fun triggerStrongEncryption(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val keyGen = KeyGenerator.getInstance("AES")
            keyGen.init(256)
            val secretKey = keyGen.generateKey()
            
            // MITIGATION: Use AES/GCM/NoPadding which provides Authenticated Encryption
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val iv = cipher.iv
            val encryptedData = cipher.doFinal(appData.networkSession.oAuth2BearerToken.toByteArray())
            
            val file = File(context.filesDir, "maswe0001_v4_secure.enc")
            FileOutputStream(file).use { 
                it.write(iv)
                it.write(encryptedData)
            }
            
            withContext(Dispatchers.Main) { resultPath = file.absolutePath }
        }
        return resultPath
    }

    // MITIGATION 5: Proper Access Restrictions
    private suspend fun triggerProperAccessRestrictions(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val file = File(context.filesDir, "images/safe_image.png")
            file.parentFile?.mkdirs()
            if (!file.exists()) file.createNewFile()

            try {
                // MITIGATION: We assume XML config has <files-path name="images" path="images/"/>
                val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
                withContext(Dispatchers.Main) { resultPath = uri.toString() }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { resultPath = "Error: ${e.message}" }
            }
        }
        return resultPath
    }

    // MITIGATION 6: Data Removed After Use
    private suspend fun triggerDataRemovedAfterUse(appData: MasterclassData): String? {
        var resultPath: String? = null
        withContext(Dispatchers.IO) {
            val tempFile = File.createTempFile("secure_temp_", ".txt", context.cacheDir)
            
            // MITIGATION: Delete file when VM exits, or explicitly via .delete()
            tempFile.deleteOnExit()

            val token = appData.networkSession.oAuth2BearerToken
            FileOutputStream(tempFile).use { out ->
                out.write("Temporary Session Dump: $token".toByteArray())
            }

            // Immediately explicitly delete after use as a best practice
            tempFile.delete()

            withContext(Dispatchers.Main) { resultPath = "${tempFile.absolutePath} (Deleted explicitly)" }
        }
        return resultPath
    }
}
