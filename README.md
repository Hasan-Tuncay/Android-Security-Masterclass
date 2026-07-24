# Android Security Masterclass 🛡️📱

> **A Comprehensive Hands-on Guide to OWASP MASVS for Android Developers**

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4CAF50.svg?logo=android)
![OWASP MASVS](https://img.shields.io/badge/OWASP-MASVS%20Compliant-red.svg?logo=owasp)

## 📖 Overview

The **Android Security Masterclass** is not just a vulnerable app; it is a **Mirror Architecture** project designed to teach Android developers and security researchers *exactly* what vulnerabilities look like and *exactly* how to fix them using modern Android development practices.

Instead of hunting for bugs in outdated Java codebases, this project uses a state-of-the-art tech stack (Kotlin, Jetpack Compose, MVVM, Material 3) and is structured around two parallel modules:

- ❌ **`:app-vulnerable`**: The "Before" state. Implements features with critical, realistic security flaws that violate OWASP MASVS standards.
- ✅ **`:app-secure`**: The "After" state. Implements the exact same UI and features, but utilizes industry best practices (e.g., Jetpack Security, Data Sanitization, R8 minification) to fully secure the data.

## 🏗️ Project Architecture

```mermaid
graph TD
    Common["/:common (Shared Models, UI, Navigation)/"] --> Vuln["/:app-vulnerable (Insecure Logic)/"]
    Common --> Sec["/:app-secure (Secure Logic)/"]
    Vuln -. exploits IPC .-> Attacker["/:app-attacker (Simulated Malware)/"]
    Data[("MasterclassData: PII, PCI-DSS, System Keys")] -. injected into .-> Common
```

The project consists of three main modules:
- **`:app-vulnerable`**: The "Before" state. Implements features with critical, realistic security flaws.
- **`:app-secure`**: The "After" state. Implements the exact same features, but fully secured using modern best practices.
- **`:app-attacker`**: A simulated malicious third-party app. Used to demonstrate live Inter-Process Communication (IPC) exploits (e.g., stealing files from `:app-vulnerable` via `FileProvider` misconfigurations) and Logcat snooping.

The `:common` module houses the `MasterclassData` object, which contains realistic dummy data representing highly sensitive payloads:
- **GDPR PII**: Names, emails, national identification numbers.
- **HIPAA PHI**: Health records and diagnosis codes.
- **PCI-DSS**: Credit card numbers (PAN), CVV, PINs.
- **System Crypto**: AES Master Keys, RSA Private Keys, OAuth Tokens.

> 💡 **Tip:** You can view all of this simulated data live on your device by clicking the **"Data Vault"** button on the Dashboard of either the vulnerable or secure app.

## 🚀 Implemented Scenarios (Vulnerability Index)

Detailed documentation for each implemented scenario, including code samples and mitigation strategies, can be found in the `docs/` directory.

### ✅ Completed
- [**MASWE-0001**: Sensitive Data Leakage via Logging (CWE-532)](./docs/maswe/MASWE-0001-Logging-Leaks.md)
- [**MASTG-BEST-0002**: Remove Logging Code (Memory Leaks)](./docs/mastg-best/MASTG-BEST-0002-ProGuard.md)

### ⏳ Upcoming
- *MASWE-0002: Insecure Local Storage (SharedPreferences & SQLite)*

## 🛠️ How to Build and Test

1. Clone the repository and open it in **Android Studio**.
2. Select either the `app-vulnerable` or `app-secure` run configuration.
3. Build Variant Testing (Crucial for MASTG-BEST-0002):
   - **Debug**: Open the `Build Variants` tool window and select `debug`. Run the app and check **Logcat**. You will see the logs (leaks in the vulnerable app, safe/generic logs in the secure app).
   - **Release**: Switch the Build Variant to `release`. R8 (ProGuard) minification will kick in. In `app-secure`, all `SecureLog` calls will be stripped out entirely!

### 😈 Setting up the Attacker App (`:app-attacker`)

To see the real consequences of these vulnerabilities, install the `:app-attacker` module alongside `:app-vulnerable` on the same device/emulator.

**Granting `READ_LOGS` Permission (For MASWE-0001):**
By default, Android does not allow apps to read system logs. To demonstrate how a malicious app *can* read logs if granted permission (or on rooted/older devices), you must grant this permission manually via ADB:

```bash
adb shell pm grant com.hasantuncay.mobsec.attacker android.permission.READ_LOGS
```

> **Note for Physical Devices:** If you are testing on a physical device (especially MIUI, ColorOS, etc.), running the command above might fail with a security exception. You must go to **Developer Options** and enable **"USB debugging (Security settings)"** or **"Disable permission monitoring"** to allow ADB to grant permissions.

## ⚠️ Disclaimer

This project is created strictly for **educational purposes**. The vulnerabilities demonstrated in the `:app-vulnerable` module are real and dangerous. Do **not** use the code from the `:app-vulnerable` module in production environments. Always refer to the `:app-secure` module for best practices.

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
