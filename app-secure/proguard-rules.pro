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
# WHY IS THIS HERE?
# This rule guarantees to the R8 compiler (ProGuard) that none of the methods
# inside the com.hasantuncay.mobsec.secure.utils.SecureLog class modify the 
# application state or have any side-effects.
# 
# RESULT:
# When building a Release build, R8 analyzes the code. It assumes that calls
# like `SecureLog.d(...)` have no effect (because we specified -assumenosideeffects)
# and COMPLETELY STRIPS these method calls from the bytecode. This ensures there
# are zero log leaks and zero memory leaks (StringBuilder allocations) in the 
# production version of the app.
# =====================================================================
-assumenosideeffects class com.hasantuncay.mobsec.secure.utils.SecureLog {
    public static void d(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void e(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void i(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void w(java.lang.String, java.lang.String, java.lang.Object[]);
}