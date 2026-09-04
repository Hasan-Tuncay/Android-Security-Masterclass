# MASWE-0006: Sensitive Data Not Excluded From Backup (CWE-200 / CWE-312)

> **Standard:** OWASP MASVS v2.0 `MASVS-STORAGE-2`  
> **Test Standard:** OWASP MASTG `MASTG-TEST-0006`  
> **CVSS v4.0 Score:** 7.5 HIGH  
> **Modules:** `:features:maswe0006`, `:app-vulnerable`, `:app-secure`

---

## 📌 Overview

This document provides a developer reference guide and security audit specifications for **MASWE-0006: Sensitive Data Not Excluded From Backup**.

Android provides automatic backup capabilities to facilitate device migrations and cloud synchronization. However, when an application enables backups without defining explicit exclusion rules, sensitive credentials (OAuth tokens, encryption keys, PII, and financial records) are transferred outside the application sandbox into cloud archives or local extraction dumps (`adb backup`), completely bypassing application sandbox protections.

---

## ❌ Vulnerable Implementation (`:app-vulnerable`)

The vulnerable application fails to restrict backup mechanisms, enabling data extraction through several platform channels:

| Vector | Failure Mode | Technical Impact |
| :--- | :--- | :--- |
| **Automatic System Backup** | No `backup_rules.xml` exclusion rules | Cloud backup includes all files in `/data/data/<pkg>/` uploaded to Google Drive. |
| **Local ADB Backup** | `android:allowBackup="true"` declared | Attackers with USB debugging access extract the full database via `adb backup`. |
| **Device-to-Device Migration** | No `data_extraction_rules.xml` `<device-transfer>` tag | Session keys clone unrestricted during setup wizard phone migrations. |
| **Unencrypted Backup Data** | Database stored in plaintext SQLite | Unpacked backup archive (`.ab` -> `.tar`) exposes tables directly. |

### Vulnerable Code Example
```xml
<!-- In AndroidManifest.xml -->
<application
    android:allowBackup="true"
    android:fullBackupContent="@xml/backup_rules"> <!-- Empty rules -->
</application>
```

---

## ✅ Secure Implementation (`:app-secure`)

The secure application implements a multi-layered defense strategy according to OWASP MASVS-STORAGE-2:

### 1. Global Disabling via AndroidManifest.xml
Where backups are not required, backups are disabled completely:
```xml
<application
    android:allowBackup="false"
    android:dataExtractionRules="@xml/data_extraction_rules"
    android:fullBackupContent="@xml/backup_rules">
</application>
```

### 2. Granular Exclusion Rules (API < 31: `backup_rules.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<full-backup-content>
    <!-- Exclude sensitive SharedPreferences -->
    <exclude domain="sharedpref" path="maswe0006_secure_prefs.xml"/>
    <exclude domain="sharedpref" path="maswe0006_tink_keyset.xml"/>
    
    <!-- Exclude Room / SQLite databases -->
    <exclude domain="database" path="maswe0006_secure.db"/>
    <exclude domain="database" path="maswe0006_secure.db-wal"/>
    <exclude domain="database" path="maswe0006_secure.db-shm"/>
    
    <!-- Exclude DataStore & confidential files -->
    <exclude domain="file" path="datastore/"/>
    <exclude domain="file" path="maswe0006_encrypted_vault.bin"/>
</full-backup-content>
```

### 3. Android 12+ Cloud & Migration Controls (API 31+: `data_extraction_rules.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<data-extraction-rules>
    <cloud-backup>
        <exclude domain="sharedpref" path="."/>
        <exclude domain="database" path="."/>
        <exclude domain="file" path="."/>
    </cloud-backup>
    <device-transfer>
        <exclude domain="sharedpref" path="."/>
        <exclude domain="database" path="."/>
        <exclude domain="file" path="."/>
    </device-transfer>
</data-extraction-rules>
```

### 4. Cryptographic Pre-Encryption (Defense-in-Depth)
Before writing any data to persistent storage, encrypt sensitive payloads with AES-256-GCM backed by hardware Keystore keys. Even in the event of an inadvertent backup inclusion, the stored data remains computationally infeasible to decrypt.

---

## 🔬 PoC & Verification Suite

The `:features:maswe0006` module includes automated verification tools:

- **Frida Hook (`poc/frida_hook.js`):** Intercepts `FLAG_ALLOW_BACKUP` and monitors `BackupManager.dataChanged()`.
- **Semgrep Rules (`poc/semgrep_rule.yml`):** Identifies `android:allowBackup="true"` and missing extraction configs in CI/CD.
- **ADB Automation (`poc/adb_verify.sh`):** Tests package dump and verifies zero-byte extraction rejection on `:app-secure`.

### Automated Test Verification
```bash
./gradlew :features:maswe0006:testDebugUnitTest :features:maswe0006:assembleDebug
python3 scripts/protocol_maswe_compliance.py
```
