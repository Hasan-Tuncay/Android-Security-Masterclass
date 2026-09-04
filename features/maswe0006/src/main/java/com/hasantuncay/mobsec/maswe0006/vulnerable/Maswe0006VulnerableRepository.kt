package com.hasantuncay.mobsec.maswe0006.vulnerable

import android.content.Context
import android.util.Log
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Vector
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0006 (Sensitive Data Not Excluded From Backup)
 *
 * TECHNICAL OVERVIEW:
 * Violates OWASP MASVS-STORAGE-2 and MASTG-TEST-0006.
 * Root causes: CWE-200 (Information Exposure) and CWE-312 (Cleartext Storage).
 *
 * VULNERABILITY VECTORS:
 * 1. AUTOMATIC SYSTEM BACKUP: Default cloud backup without backup_rules exclusions uploads credentials to Google Drive.
 * 2. LOCAL BACKUP: `android:allowBackup="true"` allows adb backup extraction without root on physical device.
 * 3. DEVICE-TO-DEVICE TRANSFER: Absence of data_extraction_rules exclusions permits credential migration across devices.
 * 4. UNENCRYPTED BACKUP DATA: Plaintext SQLite and SharedPreferences files stored in backed-up locations.
 */
@Singleton
class Maswe0006VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun executeVector(
        vector: Maswe0006Vector,
        appData: MasterclassData
    ): String? = withContext(Dispatchers.IO) {
        when (vector) {
            Maswe0006Vector.AUTOMATIC_SYSTEM_BACKUP -> {
                val prefs = context.getSharedPreferences("maswe0006_cloud_backup_session", Context.MODE_PRIVATE)
                prefs.edit()
                    .putString("auth_token", appData.networkSession.oAuth2BearerToken)
                    .putString("user_email", String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask()))
                    .apply()
                val prefsFile = File(context.filesDir.parentFile, "shared_prefs/maswe0006_cloud_backup_session.xml")
                Log.e("MASWE_0006", "Vector 1: Sensitive token persisted in unexcluded SharedPreferences -> ${prefsFile.absolutePath}")
                "EXPOSED IN AUTO-BACKUP: ${prefsFile.name} (Uploaded to Google Drive via default Auto Backup)"
            }

            Maswe0006Vector.LOCAL_BACKUP -> {
                val dbFile = File(context.filesDir, "maswe0006_local_backup_vault.db")
                FileOutputStream(dbFile).use { fos ->
                    val content = "SQLITE_SIMULATION: PAN=${appData.pciDss.cardholderData.primaryAccountNumber}|CVV=${appData.pciDss.sensitiveAuthenticationData.cardVerificationCode}"
                    fos.write(content.toByteArray())
                }
                Log.e("MASWE_0006", "Vector 2: Plaintext database created in filesDir extractable via `adb backup` -> ${dbFile.absolutePath}")
                "EXPOSED IN ADB BACKUP: ${dbFile.name} (Extractable via `adb backup -f backup.ab ${context.packageName}`)"
            }

            Maswe0006Vector.DEVICE_TO_DEVICE_TRANSFER -> {
                val transferFile = File(context.filesDir, "maswe0006_migration_credentials.json")
                FileOutputStream(transferFile).use { fos ->
                    val payload = """{"refreshToken":"${appData.networkSession.oAuth2RefreshToken}","masterKey":"${appData.systemContext.masterCryptoKeyAesGcm}"}"""
                    fos.write(payload.toByteArray())
                }
                Log.e("MASWE_0006", "Vector 3: Session keys stored without D2D transfer exclusions -> ${transferFile.absolutePath}")
                "EXPOSED IN D2D TRANSFER: ${transferFile.name} (Migrated to target device via USB/Wi-Fi setup wizard)"
            }

            Maswe0006Vector.UNENCRYPTED_BACKUP_DATA -> {
                val cleartextFile = File(context.filesDir, "maswe0006_unencrypted_customer_records.sqlite")
                FileOutputStream(cleartextFile).use { fos ->
                    val records = "TABLE customers: id=1, name=${appData.gdprPii.directIdentifiers.fullName}, plain_pwd=${appData.userContext.plainTextPasswordInHeap}"
                    fos.write(records.toByteArray())
                }
                Log.e("MASWE_0006", "Vector 4: Unencrypted SQLite records stored in backup location -> ${cleartextFile.absolutePath}")
                "UNENCRYPTED IN ARCHIVE: ${cleartextFile.name} (Readable directly in SQLite Browser when archive is unpacked)"
            }
        }
    }
}
