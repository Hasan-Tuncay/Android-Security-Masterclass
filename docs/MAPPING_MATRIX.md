## OWASP Compliance & Cross-Reference Matrix

This matrix maps every implemented vector in the `Android Security Masterclass` to the official OWASP Mobile Application Security Verification Standard (MASVS), the Mobile Application Security Testing Guide (MASTG), and the Common Weakness Enumeration (CWE) root cause.

| Vulnerability Vector | MASWE ID | MASVS Standard | MASTG Test Case | CWE Root Cause | Vulnerable Target (`:app-vulnerable`) | Secure Mitigation (`:app-secure`) |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **System Console PII Leak** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | Plaintext PII/Keys in Logcat (`Log.e`) | `@CompileTimeConstant` Wrapper (`SecureLog`), ProGuard Stripping |
| **Network Interceptor Log Leak** | MASWE-0001 | MASVS-NETWORK-2 | MASTG-TEST-0002 | CWE-532 | `HttpLoggingInterceptor` dumps OAuth Tokens | Interceptor Redaction, Log Level downgrade to `BASIC`/`NONE` |
| **Local File Log Leak** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | Custom logger appends cleartext to `debug.log` | ProGuard rule `-assumenosideeffects` removing log calls |
| **SDK Telemetry PII Leak** | MASWE-0001 | MASVS-PLATFORM-2 | MASTG-TEST-0002 | CWE-532 | `FirebaseCrashlytics.log()` records cleartext PII | PII Hash-masking prior to SDK ingestion |
| **WebView Console Leak** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | `console.log` pushed to Logcat via WebChromeClient | Default Deny regex whitelist on JS messages |
| **SharedPreferences Plaintext** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | XML stores cleartext passwords & auth tokens | Jetpack `EncryptedSharedPreferences` (AES-256-GCM) |
| **DataStore Unencrypted Protobuf** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-922 | PII serialized via Protobuf without encryption | Tink AEAD encryption layer over Preferences DataStore |
| **SQLite / Room DB Cleartext** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | PCI-DSS PAN/CVV stored in plaintext `.db` & WAL | SQLCipher (AES-256) integration via `SupportFactory` |
| **FileProvider Path Traversal** | MASWE-0002 | MASVS-PLATFORM-2 | MASTG-TEST-0027 | CWE-22 | `<root-path path="/" />` exposes internal dirs | Scoped `<files-path>`, Strict Intent validation |
| **External Storage PII Exposure** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0006 | CWE-732 | PII written to `getExternalFilesDir()` (World readable) | Data isolated to `getFilesDir()`, Scoped Storage enforced |
| **WebView DOM Storage Leak** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | JS `localStorage` synced to unencrypted LevelDB | Disabled DOM Storage, Encrypted Cookies |
| **Temporary Cache Persistence** | MASWE-0002 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-200 | Sensitive PDFs left in `getCacheDir()` indefinitely | `deleteOnExit()`, In-Memory streaming over physical files |
