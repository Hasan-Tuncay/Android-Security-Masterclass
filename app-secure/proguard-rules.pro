# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# =====================================================================
# OWASP MASTG-BEST-0002: Remove Logging Code (Custom Logging Strip)
# =====================================================================
# NEDEN BURADA?
# Bu kural, R8 derleyicisine (ProGuard) com.hasantuncay.mobsec.secure.utils.SecureLog
# sınıfının içerisindeki hiçbir metodun uygulamanın durumunu (state) veya yan etkilerini
# (side-effect) değiştirmediğini garanti eder.
# 
# SONUÇ:
# Release build'i alındığında, R8 kodu analiz eder. `SecureLog.d(...)` gibi çağrıların 
# hiçbir işe yaramadığını (çünkü -assumenosideeffects dedik) varsayar ve bu çağrıları 
# KÖKTEN SİLER (Strip eder). Bu sayede uygulamanın canlı sürümünde zerre kadar Log sızıntısı 
# veya RAM sızıntısı (Memory Leak) olmaz.
# =====================================================================
-assumenosideeffects class com.hasantuncay.mobsec.secure.utils.SecureLog {
    public static void d(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void e(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void i(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void w(java.lang.String, java.lang.String, java.lang.Object[]);
}