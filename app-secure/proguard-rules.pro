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
# OWASP MASTG-BEST-0002 & MASWE-0001: R8 Log Stripping Architectures
# =====================================================================
# This configuration demonstrates the 3 official methods for stripping
# logs using R8 in Android Production environments.

# ---------------------------------------------------------------------
# OPTION 1: TOTAL STRIPPING (Paranoid Mode) - ACTIVE
# ---------------------------------------------------------------------
# Assumes NO log functions have side effects, stripping ALL log levels
# (v, d, i, w, e) from both the native Android logger and our custom SecureLog.
# Provides 100% log privacy in production.
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-assumenosideeffects class com.hasantuncay.mobsec.secure.utils.SecureLog {
    public static void d(...);
    public static void dUnsafe(...);
    public static void dStrict(...);
    public static void i(...);
    public static void w(...);
    public static void e(...);
}

# ---------------------------------------------------------------------
# OPTION 2: SELECTIVE STRIPPING (Commented Out)
# ---------------------------------------------------------------------
# Strips only Verbose, Debug, and Info. Keeps Warnings and Errors for 
# production crash reporting.
# 
# -assumenosideeffects class android.util.Log {
#     public static boolean isLoggable(java.lang.String, int);
#     public static int v(...);
#     public static int d(...);
#     public static int i(...);
# }

# ---------------------------------------------------------------------
# OPTION 3: LOG STRIPPING WITHOUT SHRINKING/OBFUSCATION (Commented Out)
# ---------------------------------------------------------------------
# For developers who do NOT want to shrink or obfuscate their app (e.g.,
# it causes bugs) but STILL want to strip logs for security.
# This disables the shrinking engine while keeping side-effect stripping.
# 
# -dontwarn **
# -dontusemixedcaseclassnames
# -dontskipnonpubliclibraryclasses
# -dontpreverify
# -verbose
# -optimizations !code/simplification/arithmetic,!code/allocation/variable
# -keep class **
# -keepclassmembers class * { *; }
# -keepattributes *