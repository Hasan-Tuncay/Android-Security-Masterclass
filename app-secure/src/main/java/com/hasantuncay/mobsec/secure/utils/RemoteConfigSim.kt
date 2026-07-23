package com.hasantuncay.mobsec.secure.utils

/**
 * Educational Simulation of a Remote Configuration service (like Firebase Remote Config).
 * Used to demonstrate the "Kill Switch" (Incident Response Flag) concept.
 * 
 * NEDEN ENTEGRE ETTİK? (WHY WAS THIS INTEGRATED?)
 * 1. Olay Müdahale (Incident Response): Canlıda (Production) bir zafiyet tespit edilirse (Örn: Loglara PII 
 *    verisi sızdığı fark edilirse), geliştirme ekibinin kodu düzeltip, derleyip, Google Play'e göndermesi 
 *    ve onay alması GÜNLER sürebilir.
 * 2. Anında Kapatma (Zero-Time Mitigation): Bu bayrak sayesinde, sunucudan `isLoggingKilled = true` 
 *    sinyali gönderildiği saniye, uygulamayı güncellemeye gerek kalmadan milyarlarca cihazdaki 
 *    tüm loglama faaliyetleri anında (runtime'da) felç edilir.
 * 3. Google Kılavuzu: Resmi Android Güvenlik Dokümanları, canlıda log tutulacaksa mutlaka uzaktan 
 *    kapatılabilir bir şartel (shut down logging conditionally) kurulmasını emreder.
 */
object RemoteConfigSim {
    /**
     * INCIDENT RESPONSE FLAG (Kill Switch)
     * When true, `SecureLog` will immediately drop all incoming logs.
     */
    @Volatile
    var isLoggingKilled: Boolean = false
}
