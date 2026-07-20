package com.hasantuncay.mobsec.secure.utils

import android.util.Log
import com.hasantuncay.mobsec.secure.BuildConfig

/**
 * OWASP MASTG-BEST-0002: Remove Logging Code
 * 
 * NEDEN BU SINIFI YAZDIK?
 * Standart loglamada (Örn: Log.d("Tag", "Şifre: " + password)) ProGuard/R8 ile `Log.d` çağrısı
 * silinse bile, Android derleyicisi bu satırı `new StringBuilder("Şifre: ").append(password).toString()`
 * şeklinde derler. `Log.d` metodunun silinmesi, StringBuilder'ın silinmesini GARANTİ ETMEZ.
 * 
 * Sonuç olarak, şifre düz metin (plaintext) olarak RAM'e (Memory) yüklenir. Hacker'lar uygulamanın 
 * Memory Dump'ını (Hafıza Dökümü) aldıklarında, ekrana hiç basılmasa bile o şifreyi RAM'de bulurlar.
 * 
 * NASIL ÇÖZDÜK?
 * 1. String Interpolation (`$password` veya `"Şifre: " + password`) KULLANMIYORUZ.
 * 2. Hassas veriyi sadece bir argüman (`vararg`) olarak geçiriyoruz. Örn: `SecureLog.d("Tag", "Şifre: %s", password)`
 * 3. ProGuard/R8 tarafında (`proguard-rules.pro`), `SecureLog` sınıfının hiçbir yan etkisi olmadığını 
 *    (`-assumenosideeffects`) belirttik. Böylece Release derlemesinde bu metoda yapılan çağrılar KÖKTEN silinir, 
 *    hafızada hiçbir String yaratılmaz.
 */
object SecureLog {

    /**
     * Debug seviyesinde güvenli loglama.
     * @param tag Log etiketi
     * @param message Formatlanacak mesaj (Örn: "User ID: %s")
     * @param args Mesajın içine yerleştirilecek argümanlar
     */
    @JvmStatic
    fun d(tag: String, message: String, vararg args: Any?) {
        // Sadece DEBUG modunda String oluşturulur.
        // ProGuard R8 kuralı sayesinde bu metodun çağrıldığı SATIR, Release apk'sından tamamen silinir.
        if (BuildConfig.DEBUG) {
            Log.d(tag, formatMessage(message, *args))
        }
    }

    /**
     * Error seviyesinde güvenli loglama.
     */
    @JvmStatic
    fun e(tag: String, message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, formatMessage(message, *args))
        }
    }

    /**
     * Info seviyesinde güvenli loglama.
     */
    @JvmStatic
    fun i(tag: String, message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, formatMessage(message, *args))
        }
    }

    /**
     * Warning seviyesinde güvenli loglama.
     */
    @JvmStatic
    fun w(tag: String, message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, formatMessage(message, *args))
        }
    }

    /**
     * Formatlama işlemini merkezi olarak yapar. Eğer argüman yoksa doğrudan mesajı döner.
     */
    private fun formatMessage(message: String, vararg args: Any?): String {
        return if (args.isNotEmpty()) {
            try {
                String.format(message, *args)
            } catch (e: Exception) {
                // String.format hatası olursa orijinal mesajı bas
                message
            }
        } else {
            message
        }
    }
}
