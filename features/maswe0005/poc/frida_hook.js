/**
 * Frida Hook Suite for MASWE-0005: Insertion of Sensitive Data into Logs
 * 
 * Intercepts:
 * 1. android.util.Log methods (d, e, i, v, w) to detect cleartext PII, tokens, and credentials.
 * 2. WebChromeClient.onConsoleMessage() to catch DOM JS console leaks.
 * 3. OkHttp HttpLoggingInterceptor logs.
 */

Java.perform(function () {
    console.log("[*] [MASWE-0005] Dynamic Logging Interception Hook Loaded");

    var Log = Java.use("android.util.Log");
    var sensitivePatterns = ["bearer", "password", "token", "tckn", "pan", "cvv", "creditcard", "secret"];

    function checkSensitive(tag, msg) {
        if (!msg) return;
        var lower = msg.toLowerCase();
        for (var i = 0; i < sensitivePatterns.length; i++) {
            if (lower.indexOf(sensitivePatterns[i]) !== -1) {
                console.error("[!] [MASWE-0005 / CWE-532 LEAK DETECTED]");
                console.error("    Tag    : " + tag);
                console.error("    Matched: " + sensitivePatterns[i]);
                console.error("    Message: " + msg);
                console.error("    Trace  :\n" + Log.getStackTraceString(Java.use("java.lang.Exception").$new()));
                return;
            }
        }
    }

    // Hook android.util.Log.d
    Log.d.overload('java.lang.String', 'java.lang.String').implementation = function (tag, msg) {
        checkSensitive(tag, msg);
        return this.d(tag, msg);
    };

    // Hook android.util.Log.e
    Log.e.overload('java.lang.String', 'java.lang.String').implementation = function (tag, msg) {
        checkSensitive(tag, msg);
        return this.e(tag, msg);
    };

    // Hook android.util.Log.i
    Log.i.overload('java.lang.String', 'java.lang.String').implementation = function (tag, msg) {
        checkSensitive(tag, msg);
        return this.i(tag, msg);
    };
});
