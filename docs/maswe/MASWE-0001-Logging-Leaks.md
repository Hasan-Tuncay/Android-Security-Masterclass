# MASWE-0001: Sensitive Data Leakage via Logging (CWE-532)

## 📌 Overview
This scenario demonstrates how highly sensitive data (PII, PCI-DSS, System Keys) can unintentionally leak into local and remote locations if proper data sanitization and logging policies are not enforced.

## ❌ Vulnerable Implementation (`:app-vulnerable`)
The insecure application violates multiple OWASP MASVS requirements by directly logging and persisting unredacted data.

1. **System Console**: 
   - A massive JSON/Text block ("CRITICAL APP STATE DUMP") is created inside `Maswe0001VulnerableLogic.kt`. 
   - The **Master Key**, **National ID (TCKN)**, and **Plaintext Password** are directly logged to Logcat. 
   - Introduces a `StringBuilder` memory leak vulnerability (e.g., `"Password: ${appData.userContext.password}"`).
   
2. **Network Interceptor**: 
   - Uses a custom OkHttp Interceptor that explicitly logs HTTP Request Headers, including `Authorization: Bearer <token>` and `X-CSRF-Token` in plaintext.

3. **Local File Dump**: 
   - Creates a `diagnostics_vulnerable.json` file in plaintext under `context.filesDir`. 
   - Writes extremely sensitive PCI-DSS data (PAN, CVV, PIN) and HIPAA diagnosis information to the disk.

4. **SDK Telemetry**: 
   - Simulates sending the user's email, clipboard data, and draft messages as a single raw payload to third-party Analytics SDKs (e.g., Crashlytics).

5. **WebView Console**: 
   - Leaks the OAuth Refresh Token and Session Cookie by moving them from JavaScript to the native layer directly via `console.log`.

---

## ✅ Secure Implementation (`:app-secure`)
The mitigated application implements defense-in-depth strategies to ensure data confidentiality.

1. **System Console Mitigation**: 
   - Uses generic error messages without dumping domain objects. 
   - Avoids string interpolation. (See [MASTG-BEST-0002](../mastg-best/MASTG-BEST-0002-ProGuard.md) for detailed Memory Leak prevention).

2. **Network Interceptor Mitigation**: 
   - Disables `HttpLoggingInterceptor` for production (`Level.NONE`). 
   - Implements a custom **Redacting Interceptor** that replaces the content of the `Authorization` header with `REDACTED` before it is printed (even in Debug mode).

3. **Local File Dump Mitigation**: 
   - **Data Filtering**: CVV and PIN are completely stripped out (they must never be stored per PCI-DSS).
   - **Data Masking**: The Primary Account Number (PAN) is masked (e.g., `123456******7890`).
   - **Encryption**: Uses Jetpack Security's `EncryptedFile` (AES256-GCM) to write the remaining diagnostic data to a cryptographically secure file (`diagnostics_secure.json`).

4. **SDK Telemetry Mitigation**: 
   - **Data Sanitization**: The user's email is hashed with the SHA-256 algorithm (`MessageDigest`) before being sent. 
   - Instead of sending the actual draft messages, it only sends a boolean flag (e.g., `has_drafts: true`).

5. **WebView Console Mitigation**: 
   - Implements a regex/keyword-based filter inside the `WebChromeClient`. 
   - Any JS console messages containing keywords like `token`, `cookie`, `auth`, or `password` are instantly blocked and not forwarded to Logcat.
