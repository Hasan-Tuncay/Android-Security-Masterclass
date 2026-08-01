# MASWE-0002: Insecure Data Storage

## Overview
**Category:** MASVS-STORAGE
**Vulnerability:** Sensitive Data Stored With Insufficient Access Restrictions in Internal Locations
**CWEs:** CWE-922, CWE-312, CWE-200, CWE-22, CWE-284

MASWE-0002 covers vulnerabilities where sensitive data (PII, Auth Tokens, PCI-DSS) is stored locally on the device without proper encryption or access controls. Even if the data is stored within the app's internal sandbox, it can still be extracted via rooted devices, ADB backups, or malicious local apps exploiting IPC mechanisms (like Path Traversal).

---

## 🛑 Vulnerability Vectors (The "Attacker" Perspective)

Our `app-vulnerable` module demonstrates 9 distinct insecure storage anti-patterns:

1. **SharedPreferences Plaintext Leak:** Storing cleartext tokens/PII in `/shared_prefs/`. Extractable via Root or ADB Backup.
2. **DataStore Unencrypted:** Using Jetpack DataStore (Protocol Buffers) without encryption. **Binary ≠ Encrypted.**
3. **Room/SQLite Plaintext:** Storing PCI-DSS data in standard SQLite. Data is left in plaintext on disk and inside WAL (Write-Ahead Log) journals.
4. **FileProvider Root-Path Misconfiguration:** Using `<root-path>` in `file_paths.xml`. Grants external apps access to the entire sandbox.
5. **External Storage Leak (API < 29):** Writing sensitive data to `getExternalFilesDir()`. Readable by any app with `READ_EXTERNAL_STORAGE`.
6. **WebView DOM Storage:** Enabling `domStorageEnabled` allows JS to write tokens to `localStorage` (LevelDB), leaking them to the filesystem.
7. **Cache Directory Leak:** Leaving sensitive temporary files (e.g. PDFs) in `context.cacheDir` indefinitely without calling `deleteOnExit()`.
8. **Path Traversal via ContentProvider (CWE-22):** Trusting the `file` query parameter in a URI. An attacker can supply `../../../shared_prefs/session.xml` to escape the intended directory and steal arbitrary files.
9. **Third-Party SDK Shadow Leaks:** The app securely encrypts its own databases, but sends raw PII (Email, TCKN) to a 3rd party Analytics/Crash SDK. The SDK caches this data offline in a plaintext SQLite database within the app's sandbox, effectively rendering the developer's own encryption useless.

---

## 🛡️ Mitigations & Secure Implementation (The "Secure" Perspective)

Our `app-secure` module applies defense-in-depth to remediate these issues:

1. **EncryptedSharedPreferences (Tink):** AES256-SIV for keys and AES256-GCM for values. Data at rest is fully encrypted.
2. **DataStore + CryptoManager:** Wrapping Protocol Buffers serialization with a custom AES-GCM cipher before writing to disk.
3. **SQLCipher for Room:** Encrypting the entire database file, including WAL journals and temporary files, using a passphrase derived from the Android Keystore.
4. **Strict FileProvider Scopes:** Removing `<root-path>` and strictly limiting `<files-path>` or `<cache-path>` to intended subdirectories.
5. **Scoped Storage Compliance:** Migrating away from external storage or encrypting files before writing them to public directories.
6. **Path Traversal Prevention:** Validating canonical paths. `targetFile.canonicalPath.startsWith(baseDir.canonicalPath)` ensures the resolved file doesn't escape the sandbox.
7. **SDK Data Sanitization (DataMaskingUtils):** Never trust 3rd party SDKs with raw data.
   - We apply **Data Masking** (`h***n@gmail.com`) for logs/analytics.
   - We apply **One-Way Hashing** (SHA-256) for unique identifiers like TCKN before passing them to the SDK.
   - This prevents **Shadow Leaks** entirely.
