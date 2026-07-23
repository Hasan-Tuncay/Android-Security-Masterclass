# MASWE-0001: Sensitive Data Leakage via Logging (CWE-532 / CWE-359)

> **Standard:** OWASP MASVS-STORAGE-2 | **Test:** MASTG-TEST-0011 | **Best Practice:** MASTG-BEST-0002

## 📌 Overview

This document serves as the **developer reference guide** for all security mitigations implemented in `:app-secure` for the MASWE-0001 (Sensitive Data Leakage via Logging) vulnerability class.

Sensitive data — including PII (Personally Identifiable Information), PCI-DSS cardholder data, system cryptographic keys, and OAuth tokens — must **never** cross trust boundaries unencrypted, especially not into system logs, local files, or third-party telemetry pipelines.

The mitigations below are organized into **9 security groups**, each targeting a distinct attack vector.

---

## ❌ Vulnerable Implementation (`:app-vulnerable`)

The insecure application violates multiple OWASP MASVS requirements by directly logging and persisting unredacted data. Key violations:

| Vector | Vulnerability |
|---|---|
| System Console | Master Key, TCKN, and Plaintext Password dumped to Logcat with string concatenation (Heap leak) |
| Network Interceptor | `Authorization: Bearer <token>` and `X-CSRF-Token` printed in cleartext via OkHttp |
| Local File Dump | PAN, CVV, and PIN written to a plaintext JSON file on disk |
| SDK Telemetry | Raw email, clipboard data, and draft messages sent to third-party Analytics SDKs |
| WebView Console | OAuth Refresh Token and Session Cookie forwarded from JavaScript to native Logcat |

---

## ✅ Secure Implementation (`:app-secure`) — Mitigation Reference

### Group 1 — Custom Logging Infrastructure

**File:** [`SecureLog.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/utils/SecureLog.kt)

Instead of using Android's native `android.util.Log` directly (which allows arbitrary string concatenation), a custom logging gateway is implemented. This is the **"silver bullet" solution** recommended by OWASP MASTG-BEST-0002.

| # | Method | Security Level | Description |
|---|---|---|---|
| 1.1 | `dUnsafe(tag, message)` | ❌ Vulnerable (Demo Only) | No `@CompileTimeConstant`. Allows string concatenation → Heap leak. Included for educational comparison only. |
| 1.2 | `dStrict(tag, @CompileTimeConstant message)` | ✅ Maximum Security | Accepts only compile-time constants. Any runtime variable in the message triggers a **compile-time error** via ErrorProne. |
| 1.3 | `d/e/i/w/wtf(tag, @CompileTimeConstant message, vararg args)` | ✅ Recommended | Hybrid model. Format string is constant (`@CompileTimeConstant`). Dynamic data is passed via `vararg`, preventing `StringBuilder` Heap allocation. |

> **Why not Timber?** Timber uses `vararg` to prevent Heap leaks but does **not** enforce `@CompileTimeConstant`. A developer writing `Timber.d("Password: " + pass)` would bypass static analysis silently. `SecureLog` enforces this at compile time.

---

### Group 2 — Static Analysis Enforcement (ErrorProne)

**Files:** [`libs.versions.toml`](../../gradle/libs.versions.toml) · [`build.gradle.kts`](../../app-secure/build.gradle.kts) · [`SecureLog.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/utils/SecureLog.kt)

| # | Implementation | Mechanism |
|---|---|---|
| 2.1 | `com.google.errorprone:error_prone_annotations:2.50.0` dependency added | `libs.versions.toml` |
| 2.2 | `@CompileTimeConstant` annotation enforced on all safe log method signatures | Produces a **compiler error** if a runtime value is passed as the message |

```kotlin
// ✅ PASS — Compile-time constant
SecureLog.dStrict("Tag", "System initialized successfully.")

// ❌ COMPILE ERROR — Runtime value rejected by ErrorProne
SecureLog.dStrict("Tag", "User: " + userId)
```

---

### Group 3 — R8 / ProGuard Log Stripping

**File:** [`proguard-rules.pro`](../../app-secure/proguard-rules.pro)

R8 uses `-assumenosideeffects` to treat log calls as dead code and **completely removes them from the Release APK bytecode**. A reverse-engineered APK will contain zero log statements.

Three configurations are provided:

#### Option 1 — Total Stripping (Paranoid Mode) ✅ ACTIVE

Strips **all** log levels from both the native Android logger and `SecureLog`:

```proguard
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int d(...);
    public static int i(...);
    public static int w(...);
    public static int e(...);
    public static int wtf(...);
}

-assumenosideeffects class com.hasantuncay.mobsec.secure.utils.SecureLog {
    public static void d(...);
    public static void dUnsafe(...);
    public static void dStrict(...);
    public static void i(...);
    public static void w(...);
    public static void e(...);
    public static void wtf(...);
}
```

#### Option 2 — Selective Stripping (commented out)

Strips `v`, `d`, `i` only. Keeps `w` and `e` for production crash reporting.

#### Option 3 — Log Stripping Without Shrinking (commented out)

For apps that disable obfuscation/shrinking (e.g., to avoid R8 bugs) but still need log stripping. Disables the shrinking engine while keeping `-assumenosideeffects` active.

---

### Group 4 — Incident Response Kill Switch

**File:** [`RemoteConfigSim.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/utils/RemoteConfigSim.kt)

Per Google's official Android Security Guidelines: *"If you're going to log in Production, prepare flags you can use to shut down logging conditionally in case of an incident."*

| # | Implementation | Mechanism |
|---|---|---|
| 4.1 | `RemoteConfigSim` — simulates Firebase Remote Config | `@Volatile` Boolean flag (`isLoggingKilled`) |
| 4.2 | Every `SecureLog` method checks the flag as its **first instruction** | `if (RemoteConfigSim.isLoggingKilled) return` |
| 4.3 | Live kill-switch demonstration in `secureSystemConsoleLeak()` | Demonstration 4 block |

**Why this matters:** Fixing code, recompiling, and waiting for Play Store approval can take **days**. With a kill switch, the backend broadcasts `isLoggingKilled = true` and all logging across millions of devices stops **instantly**, with zero app update required.

---

### Group 5 — Network Traffic Logging

**File:** [`Maswe0001SecureLogic.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/storage/maswe0001/Maswe0001SecureLogic.kt) — `secureNetworkLeak()`

| # | Implementation | Mechanism |
|---|---|---|
| 5.1 | `HttpLoggingInterceptor.Level.NONE` forced in all builds | OkHttp — no headers or body ever printed |
| 5.2 | **Redacting Interceptor** — logs existence of sensitive headers, never their values | Custom `Interceptor` (Defense-in-Depth) |

```kotlin
// ✅ SAFE: Only signals that sensitive headers exist, not their content
SecureLog.d("SecureNetwork", "Outgoing request with REDACTED sensitive headers.")
```

---

### Group 6 — Local File Dumping (PCI-DSS Compliance)

**File:** [`Maswe0001SecureLogic.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/storage/maswe0001/Maswe0001SecureLogic.kt) — `secureLocalFileLeak()`

| # | Implementation | Mechanism |
|---|---|---|
| 6.1 | CVV and PIN **completely excluded** from the diagnostic payload | Explicit field omission (PCI-DSS DSS Req. 3.2) |
| 6.2 | Primary Account Number (PAN) **masked** → `123456******7890` | `pan.take(6) + "******" + pan.takeLast(4)` |
| 6.3 | Diagnostic file **AES-256-GCM encrypted** via hardware-backed Keystore | Jetpack Security `EncryptedFile` |

---

### Group 7 — Third-Party SDK Telemetry (GDPR)

**File:** [`Maswe0001SecureLogic.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/storage/maswe0001/Maswe0001SecureLogic.kt) — `secureSdkTelemetryLeak()`

| # | Implementation | Mechanism |
|---|---|---|
| 7.1 | User email replaced with a **one-way salted SHA-256 hash** before sending to analytics | `MessageDigest("SHA-256")` + SSAID salt (Rainbow Table mitigation) |
| 7.2 | Draft message content replaced with a **boolean flag** (`has_drafts`) | Data Minimization (GDPR Article 5.1.c) |

---

### Group 8 — WebView Console Filtering

**File:** [`Maswe0001SecureLogic.kt`](../../app-secure/src/main/java/com/hasantuncay/mobsec/secure/storage/maswe0001/Maswe0001SecureLogic.kt) — `secureWebViewConsoleLeak()`

| Approach | Model | Verdict |
|---|---|---|
| **Blacklist** (block known bad terms: `cookie`, `token`) | Negative Security | ❌ Bypassable via obfuscation (`c00kie`, `SessionID`) |
| **Whitelist** (allow only `UI_STATE:` and `ANALYTICS_EVENT:` prefixes) | Positive Security / Zero Trust | ✅ Default Deny — anything unknown is silently dropped |

```kotlin
// Default Deny: only explicitly allowlisted prefixes pass through
val safeWhitelistRegex = Regex("^(UI_STATE|ANALYTICS_EVENT):.*")
if (!safeWhitelistRegex.matches(msg)) {
    SecureLog.w("SecureWebView", "Blocked unknown WebView console message (Not in Whitelist).")
    return true
}
```

---

### Group 9 — Domain Layer Data Sanitization

**Files:**
- [`GdprPiiData.kt`](../../common/src/main/java/com/hasantuncay/mobsec/common/models/data/compliance/GdprPiiData.kt) — Class-level redaction
- [`ToMask.kt`](../../common/src/main/java/com/hasantuncay/mobsec/common/models/data/compliance/ToMask.kt) — Field-level masking
- All domain data classes (`SystemData`, `UserData`, `NetworkSessionData`, etc.)

#### 9.1 — Class-Level Redaction (`toString()` Override)

Every domain data class overrides `toString()` to return a static redacted label:

```kotlin
data class SystemData(...) {
    override fun toString() = "[REDACTED_SYSTEM_DATA]"
}
```

This ensures that even if a developer accidentally logs an entire object (`SecureLog.d("Tag", "%s", obj)`), the output is always `[REDACTED_SYSTEM_DATA]` — never real data.

#### 9.2 — Field-Level Masking (`ToMask<T>` Generic Wrapper)

Based on Google's official recommendation. Applied to the most critical GDPR fields (TCKN, Email):

```kotlin
data class DirectIdentifiers(
    val nationalIdentificationNumber: ToMask<String> = ToMask("10987654321"),
    val personalEmail: ToMask<String> = ToMask("john.doe@personal.domain.com")
)
```

```kotlin
// Accidental logging → always safe
Log.d("Tag", person.email.toString()) // prints: "MASKED_FIELD_XX"

// Intentional access → explicit, traceable, auditable
val email = person.email.getDataToMask()
```

**Defense comparison:**

| Approach | Risk if developer forgets |
|---|---|
| `ToMask<T>` field wrapper | Only that specific field leaks |
| Class-level `toString()` override | Entire object is always safe |

Both layers are applied simultaneously for maximum defense-in-depth.

#### 9.3 — Memory Scrubbing (CWE-226)

Passwords are stored in a mutable `CharArray` instead of an immutable `String`. When the password is no longer needed, it is **immediately zeroed out** without waiting for the Garbage Collector:

```kotlin
// Wipe sensitive data from Heap RAM immediately
appData.userContext.scrubPassword() // internally: Arrays.fill(passwordArray, '0')
```

This prevents the password from being discoverable via a Heap Dump or debugger memory inspection.

---

## 📊 Summary

| Group | Category | Controls Applied |
|---|---|---|
| 1 | Custom Logging | 3 logging models (`dUnsafe`, `dStrict`, `d/vararg`) |
| 2 | Static Analysis | ErrorProne `@CompileTimeConstant` (v2.50.0) |
| 3 | R8 / ProGuard | Total, Selective, and No-Shrink stripping options |
| 4 | Kill Switch | Remote Config Incident Response flag |
| 5 | Network | `Level.NONE` + Redacting Interceptor |
| 6 | Local File | CVV/PIN exclusion, PAN masking, AES-256-GCM encryption |
| 7 | SDK Telemetry | SHA-256 hashing + Data Minimization |
| 8 | WebView | Whitelist-based Default Deny filter |
| 9 | Domain Layer | Class-level `toString()`, `ToMask<T>`, Memory Scrubbing |

**Total: 9 security groups · 24 individual controls**

---

## 📚 References

- [OWASP MASWE-0001](https://mas.owasp.org/MASWE/MASWE-0001/)
- [OWASP MASTG-BEST-0002](https://mas.owasp.org/MASTG/best-practices/MASTG-BEST-0002/)
- [Android Log Info Disclosure — Google](https://developer.android.com/privacy-and-security/risks/log-info-disclosure)
- [ErrorProne CompileTimeConstant](https://errorprone.info/bugpattern/CompileTimeConstant)
- [Jetpack Security EncryptedFile](https://developer.android.com/reference/androidx/security/crypto/EncryptedFile)
- [PCI-DSS Data Security Standard v4.0](https://www.pcisecuritystandards.org/)
- [GDPR Article 5.1.c — Data Minimization](https://gdpr-info.eu/art-5-gdpr/)
