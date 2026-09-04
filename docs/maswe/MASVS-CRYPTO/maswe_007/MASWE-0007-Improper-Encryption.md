# MASWE-0007: Improper Encryption (CWE-327 / CWE-326)

> **Standard:** OWASP MASVS v2.0 `MASVS-CRYPTO-1`, `MASVS-CRYPTO-2`  
> **Test Standard:** OWASP MASTG `MASTG-TEST-0019`  
> **CVSS v4.0 Score:** 7.5 HIGH  
> **Modules:** `:features:maswe0007`, `:app-vulnerable`, `:app-secure`

---

## 📌 Overview

This document provides developer guidelines, security audit specifications, and cryptographic blueprints for **MASWE-0007: Improper Encryption**.

Encryption is only as robust as its weakest link: algorithm selection, operational mode, initialization vector uniqueness, padding strategy, and key separation all govern whether encrypted data remains secure against cryptanalysis and modern attacks.

---

## ❌ Vulnerable Implementation (`:app-vulnerable`)

The vulnerable module demonstrates seven widespread cryptographic anti-patterns:

| Vector | Failure Mode | Technical Impact |
| :--- | :--- | :--- |
| **Broken Algorithm** | Legacy DES cipher (56-bit key) | Brute-forced in < 24 hours with cloud FPGA crackers. |
| **Reused / Zero IV** | Static all-zeros IV with AES-CBC | Identical blocks reveal XOR differences between plaintexts ($C_1 \oplus C_2 = P_1 \oplus P_2$). |
| **Risky Padding** | Unauthenticated AES-CBC with PKCS#5 | Padding oracle vulnerabilities (Vaudenay attack) allow plaintext extraction. |
| **ECB Mode** | Deterministic block encryption | Identical 16-byte blocks yield identical ciphertexts (Penguin attack). |
| **Insufficient Key Length** | 56/64-bit key size | Fails minimum NIST 128-bit symmetric security requirements. |
| **Key Reuse** | Same RSA-2048 key used for Encrypt + Sign | Violates NIST SP 800-57 key separation; susceptible to cross-protocol attacks. |
| **Non-Crypto Obfuscation** | Single-byte XOR + Base64 | Trivial to reverse in 1 CPU cycle without a key. |

---

## ✅ Secure Implementation (`:app-secure`)

The secure module adheres to modern NIST SP 800-131A and OWASP MASVS-CRYPTO standards:

### 1. Authenticated AEAD Encryption (AES-256-GCM)
Replaces broken algorithms and unauthenticated CBC mode with AES-256-GCM, which provides simultaneous confidentiality and integrity verification via a 128-bit authentication tag.

### 2. Cryptographically Random IVs
Every encryption operation generates a unique 12-byte IV using `/dev/urandom` (`SecureRandom`):
```kotlin
val iv = ByteArray(12).apply { SecureRandom().nextBytes(this) }
val cipher = Cipher.getInstance("AES/GCM/NoPadding")
cipher.init(Cipher.ENCRYPT_MODE, key, GCMParameterSpec(128, iv))
```

### 3. Cryptographic Key Separation (NIST SP 800-57)
Dedicated key pairs are provisioned separately for confidentiality (encryption) and non-repudiation (digital signatures):
- `KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT`
- `KeyProperties.PURPOSE_SIGN or KeyProperties.PURPOSE_VERIFY`

---

## 🔬 PoC & Verification Suite

- **Frida Hook (`poc/frida_hook.js`):** Intercepts `Cipher.getInstance` to detect obsolete ciphers (DES, RC4) and deterministic ECB mode.
- **Semgrep Rule (`poc/semgrep_rule.yml`):** Flags insecure algorithm strings and zero-length/static IV initializations.
- **ADB Automation (`poc/adb_verify.sh`):** Validates runtime cryptographic logs.

### Automated Verification
```bash
./gradlew :features:maswe0007:testDebugUnitTest :features:maswe0007:assembleDebug
python3 scripts/protocol_maswe_compliance.py
```
