## 🚀 Pull Request Overview

**Issue Link:** Resolves # (issue number)

**Description:**
<!-- Please include a detailed summary of the changes. What does this PR achieve? -->

---

## 🛠 Type of Change

Please check the relevant options:

- [ ] 🐛 Bug fix (non-breaking change which fixes an issue)
- [ ] ✨ New Vulnerability Module (Implements a new MASWE/CWE standard)
- [ ] 🛡️ Security Enhancement (Improves a mitigation in `:app-secure`)
- [ ] ♻️ Refactor (Code restructuring without behavior change, e.g., UI updates)
- [ ] 📚 Documentation update (README, CONTRIBUTING, or docs/maswe/ updates)

---

## ✅ Masterclass Quality Checklist

Before requesting a review, you **must** ensure you have completed the following checks according to our [CONTRIBUTING.md](../CONTRIBUTING.md) guidelines:

### 🏛 Architecture & Standards
- [ ] I have read the `CONTRIBUTING.md` guide completely.
- [ ] My code strictly follows the **Kotlin idiomatic style** and uses **Jetpack Compose (Material 3)** for the UI.
- [ ] I have implemented the vulnerability/mitigation in **BOTH** the `:app-vulnerable` and `:app-secure` modules (Mirror Architecture).
- [ ] My implementation specifically targets a defined CWE and MASVS standard.

### 🔒 Security & Data Models
- [ ] I have used the `MasterclassData` object for all dummy data.
- [ ] I am **NOT** logging raw sensitive data via `Log.d/e/w/i` in the `:app-secure` module. (I used `SecureLog` with redaction).
- [ ] I am **NOT** writing unencrypted sensitive data to the disk in the `:app-secure` module without explicit Jetpack Security (AES-GCM) protections.
- [ ] I have verified that any new data classes handling PII/PCI/PHI override `toString()` to return a `[REDACTED_...]` string.

### 🧪 Verification & Documentation
- [ ] I have verified the attack vectors using `adb logcat` or `adb shell run-as` and updated the UI Result Cards accordingly.
- [ ] I have added appropriate **KDoc** and inline comments explaining the *security rationale* (The "Why", not just the "How").
- [ ] I have tested these changes on an emulator/device running **API 26 or higher**.
- [ ] My commit messages follow the **Semantic Commit** format (`feat:`, `fix:`, `refactor:`).

---

## 📸 Screenshots / ADB Proof (If applicable)

<!-- For new MASWE modules or UI changes, please provide a screenshot of the "Vector Triggered" card or the ADB verification command output below. -->
