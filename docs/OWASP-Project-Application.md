# OWASP Project Application — Android Security Masterclass

---

## Project Name
**Android Security Masterclass**

## Project Description

Android Security Masterclass is an open-source, dual-application Android project built as a hands-on educational resource for mobile security engineers, Android developers, and security researchers.

The project ships two fully functional Android applications side by side:
- **`:app-vulnerable`** — A deliberately insecure application that demonstrates real-world attack vectors with annotated, exploitable code.
- **`:app-secure`** — A hardened counterpart that implements the corresponding OWASP-aligned mitigations for each vulnerability, with inline documentation explaining the "why" behind every security decision.

The project is directly mapped to the **OWASP Mobile Application Security Verification Standard (MASVS)**, **OWASP Mobile Application Security Testing Guide (MASTG)**, and the **OWASP Mobile Application Security Weakness Enumeration (MASWE)** catalog.

---

## Problem Being Solved

The Android security ecosystem lacks a practical, standards-aligned educational resource that:
1. Shows **both** the vulnerable and secure implementation of the same feature in a single, runnable codebase.
2. Maps each implementation **directly** to an OWASP MASWE weakness ID (e.g., MASWE-0001).
3. Goes beyond theoretical description — every mitigation is **compiler-enforced, runtime-validated, and documented** at the code level.

Most existing Android security tutorials either demonstrate vulnerabilities without showing mitigations, or describe mitigations without showing what the vulnerable code looked like. This project closes that gap.

---

## Standards Coverage

This project is cross-referenced against **two authoritative pillars**:

### Pillar 1 — OWASP Mobile Security Standards

| Standard | ID | Coverage |
|---|---|---|
| MASVS | MASVS-STORAGE-2 | Sensitive data must not be logged |
| MASTG Best Practices | MASTG-BEST-0002 | Remove logging code using R8/ProGuard |
| MASWE | MASWE-0001 | Sensitive Data Leakage via Logging (CWE-532 / CWE-359) |

### Pillar 2 — Android Official Documentation

| Android Guide | Coverage |
|---|---|
| [Log Info Disclosure](https://developer.android.com/privacy-and-security/risks/log-info-disclosure) | Log stripping, R8 rules, Incident Response flags, READ_LOGS risk |
| [Android Keystore System](https://developer.android.com/privacy-and-security/keystore) | Hardware-backed key storage for encrypted local files |
| [Jetpack Security (EncryptedFile)](https://developer.android.com/reference/androidx/security/crypto/EncryptedFile) | AES-256-GCM encrypted diagnostic file storage |
| [R8 Code Shrinking](https://developer.android.com/build/shrink-code) | Compiler-level log stripping via `-assumenosideeffects` |

> Every mitigation in this project was cross-checked against both pillars. Where OWASP and Android documentation align, both references are cited in the inline code documentation (KDoc).

---

## Key Technical Mitigations Implemented

### MASWE-0001 — Sensitive Data Leakage via Logging (9 Security Groups)

1. **Custom Logging Gateway (`SecureLog`)** — Three logging models (Vulnerable/Strict/Hybrid) with Google ErrorProne `@CompileTimeConstant` enforcement at compile time.
2. **Static Analysis (ErrorProne v2.50.0)** — Prevents developers from accidentally concatenating runtime values into log statements, blocking Heap memory leaks.
3. **R8 / ProGuard Log Stripping** — Three documented ProGuard configurations (Total, Selective, No-Shrink) that remove all log calls from Release APK bytecode.
4. **Incident Response Kill Switch** — Remote Config simulation allowing all logging to be disabled across all user devices in real-time without an app update (per Google's incident response guidelines).
5. **Network Redacting Interceptor** — OkHttp interceptor that strips `Authorization` and `X-CSRF-Token` headers from logs.
6. **PCI-DSS Compliant Local File Handling** — CVV/PIN exclusion, PAN masking, and AES-256-GCM encryption via Jetpack Security.
7. **GDPR-Compliant Telemetry Sanitization** — SHA-256 salted hashing of PII before sending to analytics SDKs; data minimization.
8. **WebView Console Whitelist Filter** — Positive Security Model (Default Deny) for JavaScript console messages bridging into native Logcat.
9. **Domain Layer Data Sanitization** — Class-level `toString()` override + Google-recommended `ToMask<T>` generic wrapper + Memory Scrubbing (`CharArray.fill`).

---

## Target Audience

- Android developers learning secure coding practices
- Mobile security engineers preparing for MASVS assessments
- Penetration testers needing a legal, local Android target application
- Security instructors building curriculum aligned with OWASP MASTG

---

## Project Type
- **Open Source:** Yes
- **License:** Apache 2.0
- **Language:** Kotlin
- **Platform:** Android
- **Repository:** https://github.com/Hasan-Tuncay/Android-Security-Masterclass

---

## Project Maturity
- Active development with regular commits
- Companion YouTube educational series published alongside the codebase
- All code inline-documented with security rationale (KDoc format)
- Integrated with OWASP MASWE weakness IDs throughout the codebase

> **Note on Test Coverage:** A dedicated test methodology guide (MASTG-TEST-0011 aligned) is planned for a future release. The current project scope focuses on **secure development practices** and **vulnerability demonstration**. Test tooling documentation (ADB logcat inspection, Frida runtime hooks) will be added in a subsequent module.

---

## A Note on Project Sustainability

This project is currently being developed and maintained by a **single developer**, entirely outside of working hours, alongside a full-time engineering position.

Every line of code, every piece of documentation, and every educational video is produced independently, without institutional backing or a team. The accompanying YouTube series is recorded in Turkish (the developer's native language) to serve the underrepresented Turkish-speaking security community. English subtitles and dubbing are planned to reach a global audience — however, the AI tooling required for high-quality multilingual audio production carries a real cost, and doing it manually would consume a disproportionate amount of time that currently goes into actual development.

The honest reality is: **building something of this depth takes an enormous amount of sustained effort.** Balancing a full-time job, active development, and content production simultaneously means progress is slower than the project deserves.

**What we are asking for is not a specific budget — it is a conversation.**

Once the next major module (Insecure Data Storage) is complete, we would welcome any guidance from the OWASP community on whether sponsorship, a grant, or any other form of support might be available. Even modest support — enough to allow transitioning to part-time employment for a defined period — would meaningfully accelerate the project's completion and allow it to serve the global mobile security community far sooner.

If OWASP sees value in this work, we would be grateful to discuss what that support might look like.

---

## Project Leader Contact

**Name:** Hasan Tuncay  
**Email:** hasantuncay2635@gmail.com 
**GitHub:**https://github.com/Hasan-Tuncay/Android-Security-Masterclass
 

---

 