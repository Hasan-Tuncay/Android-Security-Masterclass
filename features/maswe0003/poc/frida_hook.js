/**
 * Frida Hook Suite for MASWE-0003: Cryptographic Keys Stored Outside of Platform Keystore
 * 
 * Intercepts:
 * 1. SharedPreferences.Editor.putString() - Detects storing raw cryptographic keys in XML prefs
 * 2. KeyGenerator.getInstance() - Detects keys generated outside the "AndroidKeyStore" provider
 * 3. Log.d() - Detects plaintext key material leaked into Logcat
 */

Java.perform(function () {
    console.log("[*] [MASWE-0003] Dynamic Instrumentation Hook Loaded");

    // 1. Hook KeyGenerator.getInstance to detect non-Keystore provider
    var KeyGenerator = Java.use("javax.crypto.KeyGenerator");
    KeyGenerator.getInstance.overload('java.lang.String').implementation = function (algorithm) {
        console.warn("[!] [MASWE-0003 AUDIT] KeyGenerator.getInstance called for " + algorithm + " WITHOUT hardware Keystore provider!");
        return this.getInstance(algorithm);
    };

    KeyGenerator.getInstance.overload('java.lang.String', 'java.lang.String').implementation = function (algorithm, provider) {
        if (provider === "AndroidKeyStore") {
            console.log("[+] [SECURE] KeyGenerator using hardware provider: " + provider);
        } else {
            console.warn("[!] [MASWE-0003 AUDIT] KeyGenerator using software provider: " + provider);
        }
        return this.getInstance(algorithm, provider);
    };

    // 2. Hook SharedPreferences.Editor.putString for key material
    var SharedPreferencesEditor = Java.use("android.app.SharedPreferencesImpl$EditorImpl");
    SharedPreferencesEditor.putString.implementation = function (key, value) {
        if (key.toLowerCase().indexOf("key") !== -1 || key.toLowerCase().indexOf("secret") !== -1) {
            console.error("[!] [MASWE-0003 VULNERABILITY] Cryptographic key saved to SharedPreferences XML!");
            console.error("    Key Name : " + key);
            console.error("    Raw Value: " + value);
        }
        return this.putString(key, value);
    };

    // 3. Hook Log.d for plaintext key imports
    var Log = Java.use("android.util.Log");
    Log.d.overload('java.lang.String', 'java.lang.String').implementation = function (tag, msg) {
        if (tag === "MASWE_0003_KEY_IMPORT") {
            console.error("[!] [MASWE-0003 VULNERABILITY] Plaintext key material detected in Logcat: " + msg);
        }
        return this.d(tag, msg);
    };
});
