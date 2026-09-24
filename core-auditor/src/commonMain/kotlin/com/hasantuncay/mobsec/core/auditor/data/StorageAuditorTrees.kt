package com.hasantuncay.mobsec.core.auditor.data

import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode

object StorageAuditorTrees {

    val maswe0001 = AuditorTree(
        id = "maswe-0001",
        title = "MASWE-0001: Unencrypted Sensitive Data in Private Storage",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Dahili depolamada (/data/data/) veri tutuluyor mu?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Tutulan veriler hassas nitelikte mi (PII, Token, Parola)?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Veriler EncryptedSharedPreferences, Encrypted DataStore, Room/SQLCipher veya Android Keystore destekli şifreleme ile korunuyor mu?",
                options = listOf(
                    Option("Hayır", "res_fail"),
                    Option("Evet", "q4")
                )
            ),
            "q4" to QuestionNode(
                text = "Şifreleme anahtarı Android Keystore donanımında mı korunuyor?",
                options = listOf(
                    Option("Hayır", "res_fail"),
                    Option("Evet", "res_pass")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val maswe0002 = AuditorTree(
        id = "maswe-0002",
        title = "MASWE-0002: Unencrypted Sensitive Data Outside Private Storage",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Harici depolama veya paylaşımlı alana (MediaStore, SD kart) dosya yazılıyor mu?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Yazılan dosyalar kullanıcıya ait hassas veri içeriyor mu?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Harici alandaki dosyalar EncryptedFile (AES-256 GCM) veya güçlü şifrelemeyle korunuyor mu?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır", "res_fail")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val maswe0003 = AuditorTree(
        id = "maswe-0003",
        title = "MASWE-0003: Cryptographic Keys Stored Outside Keystore",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Uygulama kriptografik anahtar kullanıyor mu?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Kriptografik anahtarlar nerede saklanıyor?",
                options = listOf(
                    Option("Kaynak kod, SharedPreferences veya DB", "res_fail"),
                    Option("Android Keystore Provider", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Anahtar üretilirken StrongBox veya TEE donanım koruması zorunlu kılınmış mı?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır (Yazılımsal Keystore)", "res_warning")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_warning" to ResultNode(status = "warning"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val maswe0004 = AuditorTree(
        id = "maswe-0004",
        title = "MASWE-0004: Hardcoded Secrets in APK",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "APK paketine gömülü statik gizli dizgiler (API secret, Private Key) var mı?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Sabit kodlanan anahtar kritik backend yetkisi sağlıyor mu?",
                options = listOf(
                    Option("Evet", "res_fail"),
                    Option("Hayır (Genel istemci API anahtarı)", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "İstemci anahtarı SHA-1 ve Package Name ile kısıtlanmış mı?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır", "res_fail")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val maswe0005 = AuditorTree(
        id = "maswe-0005",
        title = "MASWE-0005: Sensitive Data Leakage in Logs",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "Uygulama log basıyor mu (Log.d, Timber)?",
                options = listOf(
                    Option("Hayır", "res_pass"),
                    Option("Evet", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "Release derlemelerinde loglar ProGuard/R8 ile tamamen kaldırılıyor mu?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Canlı loglarda PII, token, parola veya ağ gövdeleri basılıyor mu?",
                options = listOf(
                    Option("Evet", "res_fail"),
                    Option("Hayır", "res_pass")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val maswe0006 = AuditorTree(
        id = "maswe-0006",
        title = "MASWE-0006: Sensitive Data Exposed in Backups",
        startNode = "q1",
        nodes = mapOf(
            "q1" to QuestionNode(
                text = "AndroidManifest.xml dosyasında android:allowBackup kapalı (false) mı?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır (true veya tanımsız)", "q2")
                )
            ),
            "q2" to QuestionNode(
                text = "dataExtractionRules ve fullBackupContent xml yapılandırmaları mevcut mu?",
                options = listOf(
                    Option("Hayır", "res_fail"),
                    Option("Evet", "q3")
                )
            ),
            "q3" to QuestionNode(
                text = "Hassas SharedPreferences ve veritabanı dosyaları <exclude> ile hariç tutulmuş mu?",
                options = listOf(
                    Option("Evet", "res_pass"),
                    Option("Hayır", "res_fail")
                )
            ),
            "res_pass" to ResultNode(status = "pass"),
            "res_fail" to ResultNode(status = "fail")
        )
    )

    val allStorageTrees: List<AuditorTree> = listOf(
        maswe0001,
        maswe0002,
        maswe0003,
        maswe0004,
        maswe0005,
        maswe0006
    )

    private val treeMap: Map<String, AuditorTree> = allStorageTrees.associateBy { it.id.lowercase() }

    fun getTree(masweId: String): AuditorTree? {
        val normalized = masweId.lowercase().trim()
        return treeMap[normalized]
    }
}
