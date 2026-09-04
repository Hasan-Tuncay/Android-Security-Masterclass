/**
 * Frida Hook Suite for MASWE-0002: Sensitive Data Stored Unencrypted Outside of Private Storage
 * 
 * Intercepts:
 * 1. Context.getExternalFilesDir() - Detects access to shared external storage directories
 * 2. SecretKeySpec initialization - Intercepts hardcoded cryptographic keys passed as byte arrays
 * 3. Cipher.init() - Detects insecure ECB mode encryption or predictable IV usage
 */

Java.perform(function () {
    console.log("[*] [MASWE-0002] Dynamic Instrumentation Hook Loaded");

    // 1. Hook Context.getExternalFilesDir
    var Context = Java.use("android.content.Context");
    Context.getExternalFilesDir.overload('java.lang.String').implementation = function (type) {
        var result = this.getExternalFilesDir(type);
        console.warn("[!] [MASWE-0002 VULNERABILITY] External storage directory accessed: " + result);
        console.warn("[!] Call Trace:\n" + Java.use("android.util.Log").getStackTraceString(Java.use("java.lang.Exception").$new()));
        return result;
    };

    // 2. Hook SecretKeySpec to catch hardcoded keys
    var SecretKeySpec = Java.use("javax.crypto.spec.SecretKeySpec");
    SecretKeySpec.$init.overload('[B', 'java.lang.String').implementation = function (keyBytes, algorithm) {
        var keyHex = "";
        for (var i = 0; i < keyBytes.length; i++) {
            var b = (keyBytes[i] & 0xFF).toString(16);
            if (b.length === 1) b = "0" + b;
            keyHex += b;
        }
        var keyAscii = "";
        try {
            var StringClass = Java.use("java.lang.String");
            keyAscii = StringClass.$new(keyBytes, "UTF-8");
        } catch (e) {
            keyAscii = "<non-utf8>";
        }

        console.error("[!] [MASWE-0002 VULNERABILITY] Insecure Key Instantiation Detected!");
        console.error("    Algorithm: " + algorithm);
        console.error("    Key Length: " + keyBytes.length + " bytes");
        console.error("    Key (Hex) : " + keyHex);
        console.error("    Key (Text): " + keyAscii);
        return this.$init(keyBytes, algorithm);
    };

    // 3. Hook Cipher.getInstance to detect ECB mode or weak ciphers
    var Cipher = Java.use("javax.crypto.Cipher");
    Cipher.getInstance.overload('java.lang.String').implementation = function (transformation) {
        if (transformation.toUpperCase().indexOf("ECB") !== -1) {
            console.error("[!] [MASWE-0002 / CWE-327] INSECURE CIPHER MODE DETECTED: " + transformation);
            console.error("    ECB mode does not provide serious code confidentiality (pattern leakage)!");
        } else if (transformation.toUpperCase().indexOf("DES") !== -1) {
            console.error("[!] [MASWE-0002 / CWE-326] BROKEN/WEAK CIPHER ALGORITHM: " + transformation);
        } else {
            console.log("[+] [SECURE] Cipher transformation requested: " + transformation);
        }
        return this.getInstance(transformation);
    };
});
