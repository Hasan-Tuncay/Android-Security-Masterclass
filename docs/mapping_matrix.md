# OWASP Compliance & Cross-Reference Matrix

This matrix maps every implemented vector across all **78 isolated MASWE modules** in the `Android Security Masterclass` to the official OWASP Mobile Application Security Verification Standard (MASVS), the Mobile Application Security Testing Guide (MASTG), and the Common Weakness Enumeration (CWE) root cause.

| Vulnerability Vector | MASWE ID | MASVS Standard | MASTG Test Case | CWE Root Cause | Vulnerable Target (`:features:masweXXXX`) | Secure Mitigation (`:features:masweXXXX`) |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **--- STORAGE ---** | | | | | | |
| **SharedPreferences Plaintext** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | `:features:maswe0001`<br>XML stores cleartext passwords & auth tokens | `:features:maswe0001`<br>Jetpack `EncryptedSharedPreferences` (AES-256-GCM) |
| **DataStore Unencrypted Protobuf** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-922 | `:features:maswe0001`<br>PII serialized via Protobuf without encryption | `:features:maswe0001`<br>Tink AEAD encryption layer over Preferences DataStore |
| **SQLite / Room DB Cleartext** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | `:features:maswe0001`<br>PCI-DSS PAN/CVV stored in plaintext `.db` & WAL | `:features:maswe0001`<br>SQLCipher (AES-256) integration via `SupportFactory` |
| **FileProvider Root-Path** | MASWE-0001 | MASVS-PLATFORM-2 | MASTG-TEST-0027 | CWE-284 | `:features:maswe0001`<br>`<root-path path="/" />` exposes internal dirs | `:features:maswe0001`<br>Scoped `<files-path>`, Strict Intent validation |
| **WebView DOM Storage Leak** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-312 | `:features:maswe0001`<br>JS `localStorage` synced to unencrypted LevelDB | `:features:maswe0001`<br>Disabled DOM Storage, Encrypted Cookies |
| **Temporary Cache Persistence** | MASWE-0001 | MASVS-STORAGE-1 | MASTG-TEST-0001 | CWE-200 | `:features:maswe0001`<br>Sensitive PDFs left in `getCacheDir()` indefinitely | `:features:maswe0001`<br>`deleteOnExit()`, In-Memory streaming over physical files |
| **ContentProvider Path Traversal** | MASWE-0001 | MASVS-PLATFORM-2 | MASTG-TEST-0027 | CWE-22 | `:features:maswe0001`<br>Trusting `?file=../../` query parameters | `:features:maswe0001`<br>Validating `File.canonicalPath` boundaries |
| **Third-Party SDK Shadow Leak** | MASWE-0001 | MASVS-STORAGE-2 | MASTG-TEST-0002 | CWE-200 | `:features:maswe0001`<br>3rd party SDKs saving unhashed PII to SQLite offline | `:features:maswe0001`<br>Hashing/Masking PII before sending it to analytics |
| **External Storage PII Exposure** | MASWE-0002 | MASVS-STORAGE-2 | MASTG-TEST-0006 | CWE-732 | `:features:maswe0002`<br>PII written to `getExternalFilesDir()` (World readable) | `:features:maswe0002`<br>Data isolated to `getFilesDir()`, Scoped Storage enforced |
| **Hardcoded Encryption Key** | MASWE-0002 | MASVS-STORAGE-2 | MASTG-TEST-0006 | CWE-321 | `:features:maswe0002`<br>External data encrypted with hardcoded key | `:features:maswe0002`<br>Android Keystore (Hardware Backed) generation |
| **Encryption Key on Filesystem** | MASWE-0002 | MASVS-STORAGE-2 | MASTG-TEST-0006 | CWE-312 | `:features:maswe0002`<br>Key stored alongside encrypted data externally | `:features:maswe0002`<br>Keystore encapsulation |
| **Insufficient Encryption** | MASWE-0002 | MASVS-STORAGE-2 | MASTG-TEST-0006 | CWE-326 | `:features:maswe0002`<br>Weak algorithm/config for external storage encryption | `:features:maswe0002`<br>AES-256-GCM authenticated encryption |
| **Reuse of Encryption Key** | MASWE-0002 | MASVS-STORAGE-2 | MASTG-TEST-0006 | CWE-320 | `:features:maswe0002`<br>Same key shared between devices enabling data cloning | `:features:maswe0002`<br>Device-unique hardware keys |
| *Module 0003 Scenarios (TBD)* | MASWE-0003 | MASVS-STORAGE | TBD | TBD | `:features:maswe0003` | `:features:maswe0003` |
| *Module 0004 Scenarios (TBD)* | MASWE-0004 | MASVS-STORAGE | TBD | TBD | `:features:maswe0004` | `:features:maswe0004` |
| **System Console PII Leak** | MASWE-0005 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | `:features:maswe0005`<br>Plaintext PII/Keys in Logcat (`Log.e`) | `:features:maswe0005`<br>`@CompileTimeConstant` Wrapper (`SecureLog`), ProGuard Stripping |
| **Network Interceptor Log Leak** | MASWE-0005 | MASVS-NETWORK-2 | MASTG-TEST-0002 | CWE-532 | `:features:maswe0005`<br>`HttpLoggingInterceptor` dumps OAuth Tokens | `:features:maswe0005`<br>Interceptor Redaction, Log Level downgrade to `BASIC`/`NONE` |
| **Local File Log Leak** | MASWE-0005 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | `:features:maswe0005`<br>Custom logger appends cleartext to `debug.log` | `:features:maswe0005`<br>ProGuard rule `-assumenosideeffects` removing log calls |
| **SDK Telemetry PII Leak** | MASWE-0005 | MASVS-PLATFORM-2 | MASTG-TEST-0002 | CWE-532 | `:features:maswe0005`<br>`FirebaseCrashlytics.log()` records cleartext PII | `:features:maswe0005`<br>PII Hash-masking prior to SDK ingestion |
| **WebView Console Leak** | MASWE-0005 | MASVS-STORAGE-1 | MASTG-TEST-0002 | CWE-532 | `:features:maswe0005`<br>`console.log` pushed to Logcat via WebChromeClient | `:features:maswe0005`<br>Default Deny regex whitelist on JS messages |
| *Module 0006 Scenarios (TBD)* | MASWE-0006 | MASVS-STORAGE | TBD | TBD | `:features:maswe0006` | `:features:maswe0006` |
| **--- CRYPTOGRAPHY ---** | | | | | | |
| *Module 0007 Scenarios (TBD)* | MASWE-0007 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0007` | `:features:maswe0007` |
| *Module 0008 Scenarios (TBD)* | MASWE-0008 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0008` | `:features:maswe0008` |
| *Module 0009 Scenarios (TBD)* | MASWE-0009 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0009` | `:features:maswe0009` |
| *Module 0010 Scenarios (TBD)* | MASWE-0010 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0010` | `:features:maswe0010` |
| *Module 0011 Scenarios (TBD)* | MASWE-0011 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0011` | `:features:maswe0011` |
| *Module 0012 Scenarios (TBD)* | MASWE-0012 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0012` | `:features:maswe0012` |
| *Module 0013 Scenarios (TBD)* | MASWE-0013 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0013` | `:features:maswe0013` |
| *Module 0014 Scenarios (TBD)* | MASWE-0014 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0014` | `:features:maswe0014` |
| *Module 0015 Scenarios (TBD)* | MASWE-0015 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0015` | `:features:maswe0015` |
| *Module 0016 Scenarios (TBD)* | MASWE-0016 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0016` | `:features:maswe0016` |
| *Module 0017 Scenarios (TBD)* | MASWE-0017 | MASVS-CRYPTO | TBD | TBD | `:features:maswe0017` | `:features:maswe0017` |
| **--- AUTHENTICATION ---** | | | | | | |
| *Module 0018 Scenarios (TBD)* | MASWE-0018 | MASVS-AUTH | TBD | TBD | `:features:maswe0018` | `:features:maswe0018` |
| *Module 0019 Scenarios (TBD)* | MASWE-0019 | MASVS-AUTH | TBD | TBD | `:features:maswe0019` | `:features:maswe0019` |
| *Module 0020 Scenarios (TBD)* | MASWE-0020 | MASVS-AUTH | TBD | TBD | `:features:maswe0020` | `:features:maswe0020` |
| *Module 0021 Scenarios (TBD)* | MASWE-0021 | MASVS-AUTH | TBD | TBD | `:features:maswe0021` | `:features:maswe0021` |
| *Module 0022 Scenarios (TBD)* | MASWE-0022 | MASVS-AUTH | TBD | TBD | `:features:maswe0022` | `:features:maswe0022` |
| *Module 0023 Scenarios (TBD)* | MASWE-0023 | MASVS-AUTH | TBD | TBD | `:features:maswe0023` | `:features:maswe0023` |
| *Module 0024 Scenarios (TBD)* | MASWE-0024 | MASVS-AUTH | TBD | TBD | `:features:maswe0024` | `:features:maswe0024` |
| *Module 0025 Scenarios (TBD)* | MASWE-0025 | MASVS-AUTH | TBD | TBD | `:features:maswe0025` | `:features:maswe0025` |
| **--- NETWORK ---** | | | | | | |
| *Module 0026 Scenarios (TBD)* | MASWE-0026 | MASVS-NETWORK | TBD | TBD | `:features:maswe0026` | `:features:maswe0026` |
| *Module 0027 Scenarios (TBD)* | MASWE-0027 | MASVS-NETWORK | TBD | TBD | `:features:maswe0027` | `:features:maswe0027` |
| *Module 0028 Scenarios (TBD)* | MASWE-0028 | MASVS-NETWORK | TBD | TBD | `:features:maswe0028` | `:features:maswe0028` |
| **--- PLATFORM ---** | | | | | | |
| *Module 0029 Scenarios (TBD)* | MASWE-0029 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0029` | `:features:maswe0029` |
| *Module 0030 Scenarios (TBD)* | MASWE-0030 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0030` | `:features:maswe0030` |
| *Module 0031 Scenarios (TBD)* | MASWE-0031 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0031` | `:features:maswe0031` |
| *Module 0032 Scenarios (TBD)* | MASWE-0032 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0032` | `:features:maswe0032` |
| *Module 0033 Scenarios (TBD)* | MASWE-0033 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0033` | `:features:maswe0033` |
| *Module 0034 Scenarios (TBD)* | MASWE-0034 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0034` | `:features:maswe0034` |
| *Module 0035 Scenarios (TBD)* | MASWE-0035 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0035` | `:features:maswe0035` |
| *Module 0036 Scenarios (TBD)* | MASWE-0036 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0036` | `:features:maswe0036` |
| *Module 0037 Scenarios (TBD)* | MASWE-0037 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0037` | `:features:maswe0037` |
| *Module 0038 Scenarios (TBD)* | MASWE-0038 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0038` | `:features:maswe0038` |
| *Module 0039 Scenarios (TBD)* | MASWE-0039 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0039` | `:features:maswe0039` |
| *Module 0040 Scenarios (TBD)* | MASWE-0040 | MASVS-PLATFORM | TBD | TBD | `:features:maswe0040` | `:features:maswe0040` |
| **--- CODE QUALITY ---** | | | | | | |
| *Module 0041 Scenarios (TBD)* | MASWE-0041 | MASVS-CODE | TBD | TBD | `:features:maswe0041` | `:features:maswe0041` |
| *Module 0042 Scenarios (TBD)* | MASWE-0042 | MASVS-CODE | TBD | TBD | `:features:maswe0042` | `:features:maswe0042` |
| *Module 0043 Scenarios (TBD)* | MASWE-0043 | MASVS-CODE | TBD | TBD | `:features:maswe0043` | `:features:maswe0043` |
| *Module 0044 Scenarios (TBD)* | MASWE-0044 | MASVS-CODE | TBD | TBD | `:features:maswe0044` | `:features:maswe0044` |
| *Module 0045 Scenarios (TBD)* | MASWE-0045 | MASVS-CODE | TBD | TBD | `:features:maswe0045` | `:features:maswe0045` |
| *Module 0046 Scenarios (TBD)* | MASWE-0046 | MASVS-CODE | TBD | TBD | `:features:maswe0046` | `:features:maswe0046` |
| *Module 0047 Scenarios (TBD)* | MASWE-0047 | MASVS-CODE | TBD | TBD | `:features:maswe0047` | `:features:maswe0047` |
| *Module 0048 Scenarios (TBD)* | MASWE-0048 | MASVS-CODE | TBD | TBD | `:features:maswe0048` | `:features:maswe0048` |
| *Module 0049 Scenarios (TBD)* | MASWE-0049 | MASVS-CODE | TBD | TBD | `:features:maswe0049` | `:features:maswe0049` |
| *Module 0050 Scenarios (TBD)* | MASWE-0050 | MASVS-CODE | TBD | TBD | `:features:maswe0050` | `:features:maswe0050` |
| **--- RESILIENCE ---** | | | | | | |
| *Module 0051 Scenarios (TBD)* | MASWE-0051 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0051` | `:features:maswe0051` |
| *Module 0052 Scenarios (TBD)* | MASWE-0052 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0052` | `:features:maswe0052` |
| *Module 0053 Scenarios (TBD)* | MASWE-0053 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0053` | `:features:maswe0053` |
| *Module 0054 Scenarios (TBD)* | MASWE-0054 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0054` | `:features:maswe0054` |
| *Module 0055 Scenarios (TBD)* | MASWE-0055 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0055` | `:features:maswe0055` |
| *Module 0056 Scenarios (TBD)* | MASWE-0056 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0056` | `:features:maswe0056` |
| *Module 0057 Scenarios (TBD)* | MASWE-0057 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0057` | `:features:maswe0057` |
| *Module 0058 Scenarios (TBD)* | MASWE-0058 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0058` | `:features:maswe0058` |
| *Module 0059 Scenarios (TBD)* | MASWE-0059 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0059` | `:features:maswe0059` |
| *Module 0060 Scenarios (TBD)* | MASWE-0060 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0060` | `:features:maswe0060` |
| *Module 0061 Scenarios (TBD)* | MASWE-0061 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0061` | `:features:maswe0061` |
| *Module 0062 Scenarios (TBD)* | MASWE-0062 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0062` | `:features:maswe0062` |
| *Module 0063 Scenarios (TBD)* | MASWE-0063 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0063` | `:features:maswe0063` |
| *Module 0064 Scenarios (TBD)* | MASWE-0064 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0064` | `:features:maswe0064` |
| *Module 0065 Scenarios (TBD)* | MASWE-0065 | MASVS-RESILIENCE | TBD | TBD | `:features:maswe0065` | `:features:maswe0065` |
| **--- PRIVACY ---** | | | | | | |
| *Module 0066 Scenarios (TBD)* | MASWE-0066 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0066` | `:features:maswe0066` |
| *Module 0067 Scenarios (TBD)* | MASWE-0067 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0067` | `:features:maswe0067` |
| *Module 0068 Scenarios (TBD)* | MASWE-0068 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0068` | `:features:maswe0068` |
| *Module 0069 Scenarios (TBD)* | MASWE-0069 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0069` | `:features:maswe0069` |
| *Module 0070 Scenarios (TBD)* | MASWE-0070 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0070` | `:features:maswe0070` |
| *Module 0071 Scenarios (TBD)* | MASWE-0071 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0071` | `:features:maswe0071` |
| *Module 0072 Scenarios (TBD)* | MASWE-0072 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0072` | `:features:maswe0072` |
| *Module 0073 Scenarios (TBD)* | MASWE-0073 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0073` | `:features:maswe0073` |
| *Module 0074 Scenarios (TBD)* | MASWE-0074 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0074` | `:features:maswe0074` |
| *Module 0075 Scenarios (TBD)* | MASWE-0075 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0075` | `:features:maswe0075` |
| *Module 0076 Scenarios (TBD)* | MASWE-0076 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0076` | `:features:maswe0076` |
| *Module 0077 Scenarios (TBD)* | MASWE-0077 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0077` | `:features:maswe0077` |
| *Module 0078 Scenarios (TBD)* | MASWE-0078 | MASVS-PRIVACY | TBD | TBD | `:features:maswe0078` | `:features:maswe0078` |
