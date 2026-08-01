# Android Security Masterclass 🛡️📱

> **A Hands-on OWASP MASVS/MASTG Security Training Lab for Android Developers & Pentesters — Mirror Architecture: Vulnerable ↔ Secure ↔ Attacker**

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4CAF50.svg?logo=android)
![OWASP MASVS](https://img.shields.io/badge/OWASP-MASVS%20Compliant-red.svg?logo=owasp)
![Platform](https://img.shields.io/badge/Platform-Android-green.svg?logo=android)
![License](https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg)
![PRs Welcome](https://img.shields.io/badge/PRs-Welcome-brightgreen.svg)

## 📖 Overview

The **Android Security Masterclass** is not just a vulnerable app; it is a **Mirror Architecture** project designed to teach Android developers and security researchers *exactly* what vulnerabilities look like and *exactly* how to fix them using modern Android development practices.

Instead of hunting for bugs in outdated Java codebases, this project uses a state-of-the-art tech stack (Kotlin, Jetpack Compose, MVVM, Material 3) and is structured around three parallel modules:

- ❌ **`:app-vulnerable`**: The "Before" state. Implements features with critical, realistic security flaws that violate OWASP MASVS standards.
- ✅ **`:app-secure`**: The "After" state. Implements the exact same UI and features, but utilizes industry best practices (e.g., Jetpack Security, Data Sanitization, R8 minification) to fully secure the data.
- 😈 **`:app-attacker`**: A simulated malicious third-party app. Demonstrates **live** IPC exploits (Logcat snooping, FileProvider URI theft) — not theoretical ADB commands, but an actual running process on the device.

## 🏗️ Project Architecture

```mermaid
graph TD
    COMMON("🧱 :common<br/>Shared Data · ViewModel<br/>Theme · Navigation")
    VULN("❌ :app-vulnerable<br/>Insecure Implementations")
    SEC("✅ :app-secure<br/>Hardened Implementations")
    ATK("😈 :app-attacker<br/>Simulated Malware")

    COMMON -- "Same Data<br/>Same UI" --> VULN
    COMMON -- "Same Data<br/>Same UI" --> SEC
    VULN -. "IPC Exploit<br/>Logcat · ContentProvider" .-> ATK

    classDef common fill:#4A90D9,stroke:#2C5F8A,color:#fff,stroke-width:2px,font-weight:bold
    classDef vuln fill:#E74C3C,stroke:#C0392B,color:#fff,stroke-width:2px,font-weight:bold
    classDef secure fill:#27AE60,stroke:#1E8449,color:#fff,stroke-width:2px,font-weight:bold
    classDef attacker fill:#8E44AD,stroke:#6C3483,color:#fff,stroke-width:2px,font-weight:bold

    class COMMON common
    class VULN vuln
    class SEC secure
    class ATK attacker
```

The project consists of **four modules** working in concert:

| Module | Role | Status |
| :--- | :--- | :--- |
| **`:common`** | Shared data models (`MasterclassData`), MASWE vector enums, ViewModel, UI theme, and navigation. Both apps receive the same high-fidelity data. | Foundation ✅ |
| **`:app-vulnerable`** | The "Before" state. Implements features with critical, realistic security flaws that violate OWASP MASVS standards. | MASWE-0001 ✅ · MASWE-0002 ✅ |
| **`:app-secure`** | The "After" state. The exact same UI and features, secured using Jetpack Security, Tink, SQLCipher, ProGuard, and SecureLog. | MASWE-0001 ✅ · MASWE-0002 ✅ |
| **`:app-attacker`** | A simulated malicious third-party app. Demonstrates **live** IPC exploits (FileProvider path traversal, Logcat snooping) — not theoretical ADB commands, but an actual running process on the device. | Active ✅ |

### 📦 The `MasterclassData` High-Fidelity Data Model
Unlike other educational projects that use trivial data ("admin:password"), our leak simulations use **regulation-grade** payloads:

```mermaid
graph TD
    ROOT("📦 MasterclassData")

    COMP("🏛️ compliance")
    THREAT("⚠️ threat")

    GDPR("GdprPiiData<br/>TCKN · Email · National ID")
    HIPAA("HipaaPhiData<br/>ICD-10 · Medical Records")
    PCI("PciDssData<br/>PAN · CVV · PIN Block")

    SYS("SystemData<br/>AES Keys · RSA Private Keys")
    SESS("SessionData<br/>OAuth · CSRF · Cookies")
    DEV("DeviceTelemetryData<br/>SSAID · Ad ID · GeoLoc")

    ROOT --> COMP
    ROOT --> THREAT
    COMP --> GDPR
    COMP --> HIPAA
    COMP --> PCI
    THREAT --> SYS
    THREAT --> SESS
    THREAT --> DEV

    classDef root fill:#2C3E50,stroke:#1A252F,color:#fff,stroke-width:2px,font-weight:bold
    classDef comp fill:#2980B9,stroke:#1F618D,color:#fff,stroke-width:2px
    classDef threat fill:#E67E22,stroke:#CA6F1E,color:#fff,stroke-width:2px
    classDef leaf fill:#ECF0F1,stroke:#BDC3C7,color:#2C3E50,stroke-width:1px

    class ROOT root
    class COMP comp
    class THREAT threat
    class GDPR,HIPAA,PCI,SYS,SESS,DEV leaf
```

| Data Layer | Contents | Regulatory Standard |
| :--- | :--- | :--- |
| `compliance/GdprPiiData` | National ID (TCKN), email, direct identifiers | GDPR Article 4 / Article 9 |
| `compliance/HipaaPhiData` | ICD-10 diagnosis codes, Medical Record Numbers | HIPAA §164.514 |
| `compliance/PciDssData` | PAN, CVV, PIN blocks, Track 2 data | PCI-DSS Requirement 3.2 |
| `threat/SystemData` | AES Master Keys, RSA Private Keys | MASVS-CRYPTO |
| `threat/SessionData` | OAuth tokens, CSRF tokens, session cookies | MASVS-NETWORK |
| `threat/DeviceTelemetryData` | SSAID, Advertising ID, geolocation | MASVS-PRIVACY |

> 💡 **Tip:** You can view all of this simulated data live on your device by clicking the **"Data Vault"** button on the Dashboard of either the vulnerable or secure app.

## 🚀 Implemented Scenarios (Vulnerability Index)

Detailed documentation for each implemented scenario, including code samples and mitigation strategies, can be found in the `docs/` directory.

```mermaid
graph LR
    subgraph BEFORE ["❌ Vulnerable"]
        direction TB
        V1("Log.d with plaintext PII")
        V2("SharedPreferences cleartext")
        V3("SQLite — no encryption")
        V4("FileProvider over-exposed")
        V5("Logging in release builds")
    end

    subgraph AFTER ["✅ Secure"]
        direction TB
        S1("SecureLog — masked output")
        S2("EncryptedSharedPreferences")
        S3("SQLCipher — AES-256")
        S4("Scoped FileProvider")
        S5("R8 strips all log calls")
    end

    V1 -- "fix" --> S1
    V2 -- "fix" --> S2
    V3 -- "fix" --> S3
    V4 -- "fix" --> S4
    V5 -- "fix" --> S5

    classDef vuln fill:#E74C3C,stroke:#C0392B,color:#fff,stroke-width:2px
    classDef secure fill:#27AE60,stroke:#1E8449,color:#fff,stroke-width:2px

    class V1,V2,V3,V4,V5 vuln
    class S1,S2,S3,S4,S5 secure
```

### ✅ Completed
- [**MASWE-0001**: Sensitive Data Leakage via Logging (CWE-532)](docs/maswe/MASVS-STORAGE/maswe_001/MASWE-0001-Logging-Leaks.md)
- [**MASTG-BEST-0002**: Remove Logging Code (Memory Leaks)](./docs/mastg-best/MASTG-BEST-0002-ProGuard.md)
- [**MASWE-0002**: Insecure Local Storage (SharedPreferences, DataStore, SQLite)](./docs/maswe/MASVS-STORAGE/maswe_002/MASWE-0002-Insecure-Storage.md) *(Attacker App PoC Ready)*

### 🚧 In Progress

### ⏳ Upcoming Scenarios
- **MASWE-0064**: Insecure ContentProvider (IPC Leakage)
- **MASWE-XXXX**: Deep Link & Intent Hijacking
- **MASWE-XXXX**: Insecure Network Communication (TLS/SSL Pinning)

## 🛠️ How to Build and Test

1. Clone the repository and open it in **Android Studio**.
2. Select either the `app-vulnerable` or `app-secure` run configuration.
3. Build Variant Testing (Crucial for MASTG-BEST-0002):
   - **Debug**: Open the `Build Variants` tool window and select `debug`. Run the app and check **Logcat**. You will see the logs (leaks in the vulnerable app, safe/generic logs in the secure app).
   - **Release**: Switch the Build Variant to `release`. R8 (ProGuard) minification will kick in. In `app-secure`, all `SecureLog` calls will be stripped out entirely!

### 😈 Setting up the Attacker App (`:app-attacker`)

To see the real consequences of these vulnerabilities, install the `:app-attacker` module alongside `:app-vulnerable` on the same device/emulator.

```mermaid
graph LR
    subgraph VICTIM ["❌ :app-vulnerable"]
        direction TB
        LOG("📋 Log.d sends PII<br/>to system Logcat")
        FP("📂 FileProvider<br/>exported paths")
    end

    subgraph MALWARE ["😈 :app-attacker"]
        direction TB
        LE("🔍 LogcatExploitScreen<br/>reads all logs")
        ER("📥 ExploitReceiverScreen<br/>steals files via URI")
    end

    LOG -- "READ_LOGS<br/>permission" --> LE
    FP -- "content:// URI<br/>interception" --> ER

    classDef victim fill:#E74C3C,stroke:#C0392B,color:#fff,stroke-width:2px
    classDef malware fill:#8E44AD,stroke:#6C3483,color:#fff,stroke-width:2px

    class LOG,FP victim
    class LE,ER malware
```

**Granting `READ_LOGS` Permission (For MASWE-0001):**
By default, Android does not allow apps to read system logs. To demonstrate how a malicious app *can* read logs if granted permission (or on rooted/older devices), you must grant this permission manually via ADB:

```bash
adb shell pm grant com.hasantuncay.mobsec.attacker android.permission.READ_LOGS
```

> **Note for Physical Devices:** If you are testing on a physical device (especially MIUI, ColorOS, etc.), running the command above might fail with a security exception. You must go to **Developer Options** and enable **"USB debugging (Security settings)"** or **"Disable permission monitoring"** to allow ADB to grant permissions.

## 🔑 Keywords

`android security` · `owasp masvs` · `owasp mastg` · `mobile application security` · `vulnerable android app` · `security training lab` · `kotlin security` · `jetpack compose security` · `CWE-532` · `insecure data storage` · `content provider exploit` · `android penetration testing` · `GDPR` · `HIPAA` · `PCI-DSS` · `mirror architecture` · `security by design`

## ⚠️ Disclaimer

This project is created strictly for **educational purposes**. The vulnerabilities demonstrated in the `:app-vulnerable` module are real and dangerous. Do **not** use the code from the `:app-vulnerable` module in production environments. Always refer to the `:app-secure` module for best practices.

## 🤝 How to Contribute

We welcome contributions from the community! Whether it's adding a new vulnerability module, improving documentation, or fixing a bug, your help is appreciated.

```mermaid
graph LR
    PR("🔀 Pull Request")
    LINT("🔍 Android Lint")
    SAST("🛡️ Detekt SAST")
    BUILD("🔨 Build<br/>3 Modules")
    REVIEW("👀 Code Review")
    MERGE("✅ Merge")

    PR --> LINT --> SAST --> BUILD --> REVIEW --> MERGE

    DEPBOT("🤖 Dependabot<br/>Weekly CVE Scan")
    DEPBOT -. "auto PR" .-> BUILD

    classDef step fill:#4A90D9,stroke:#2C5F8A,color:#fff,stroke-width:2px
    classDef bot fill:#E67E22,stroke:#CA6F1E,color:#fff,stroke-width:2px
    classDef done fill:#27AE60,stroke:#1E8449,color:#fff,stroke-width:2px

    class PR,LINT,SAST,BUILD,REVIEW step
    class MERGE done
    class DEPBOT bot
```

Please read our comprehensive [**Contributing Guide (`CONTRIBUTING.md`)**](./CONTRIBUTING.md) before opening a Pull Request. It covers our project philosophy (Mirror Architecture), coding standards, and the step-by-step process for adding new MASWE modules.

---

## 🦅 Contact & Community

**Instructor: Hasan Tunçay**
- [LinkedIn](https://www.linkedin.com/in/hasantuncay2635)
- [X (Twitter)](https://x.com/yacnutnasah)

<div align="center">
  <img src="assets/harpia_logo.png" alt="Harpia Academy" width="300"/>
</div>

**Harpia Academy**
- [LinkedIn](https://www.linkedin.com/company/harpiaacademyofficial)
- [YouTube](https://www.youtube.com/@harpiaacademyofficial)
- [Instagram](https://www.instagram.com/harpiaacademyofficial)
- [X (Twitter)](https://x.com/harpiaacademy)
