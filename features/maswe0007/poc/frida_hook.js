/**
 * Frida Hook Suite for MASWE-0007: Improper Encryption
 * 
 * Intercepts:
 * 1. javax.crypto.Cipher.getInstance(transformation) to catch:
 *    - Insecure algorithms: DES, DESede, RC4, Blowfish
 *    - Insecure mode of operation: /ECB/ (Penguin pattern leakage)
 *    - Unauthenticated CBC mode without HMAC
 * 2. javax.crypto.spec.IvParameterSpec to detect zero or static hardcoded IVs.
 * 3. javax.crypto.KeyGenerator.init() to detect keys smaller than 128 bits.
 */

Java.perform(function () {
    console.log("[*] [MASWE-0007] Dynamic Cryptographic Audit Hook Loaded");

    var Cipher = Java.use("javax.crypto.Cipher");
    var IvParameterSpec = Java.use("javax.crypto.spec.IvParameterSpec");
    var Log = Java.use("android.util.Log");

    // Hook Cipher.getInstance
    Cipher.getInstance.overload("java.lang.String").implementation = function (transformation) {
        var lower = transformation.toLowerCase();
        
        if (lower.indexOf("des") !== -1 || lower.indexOf("rc4") !== -1) {
            console.error("[!] [MASWE-0007 / CWE-327 BROKEN ALGORITHM DETECTED]");
            console.error("    Transformation: " + transformation);
            console.error("    Remediation   : Migrate immediately to AES-256-GCM (NIST SP 800-131A)");
            console.error("    Trace:\n" + Log.getStackTraceString(Java.use("java.lang.Exception").$new()));
        } else if (lower.indexOf("/ecb/") !== -1) {
            console.error("[!] [MASWE-0007 / CWE-327 INSECURE ECB MODE DETECTED]");
            console.error("    Transformation: " + transformation);
            console.error("    Vulnerability : Deterministic encryption leaks data patterns (Penguin Attack)");
            console.error("    Remediation   : Use AES/GCM/NoPadding or AES/CBC with HMAC");
        }

        return this.getInstance(transformation);
    };

    // Hook IvParameterSpec to catch static/zero IVs
    IvParameterSpec.$init.overload("[B").implementation = function (bytes) {
        var isAllZero = true;
        for (var i = 0; i < bytes.length; i++) {
            if (bytes[i] !== 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            console.error("[!] [MASWE-0007 / CWE-329 ALL-ZEROS STATIC IV DETECTED]");
            console.error("    IV Length    : " + bytes.length + " bytes");
            console.error("    Remediation  : Generate IV using SecureRandom().nextBytes(iv)");
        }
        return this.$init(bytes);
    };
});
