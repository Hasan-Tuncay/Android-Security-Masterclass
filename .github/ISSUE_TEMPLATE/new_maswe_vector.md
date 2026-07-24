---
name: New MASWE Vulnerability Vector
about: Request the implementation of an unmapped MASWE vulnerability.
title: "[MASWE-XXXX] Vulnerability Name (CWE-XXX)"
labels: help wanted
assignees: ''
---

### [CONTEXT]
**Vulnerability Overview:** 
[Provide a 2-3 sentence clinical description of the weakness according to OWASP.]

**Standards Mapping:**
*   **MASWE ID:** [e.g., MASWE-0032]
*   **MASVS Requirement:** [e.g., MASVS-NETWORK-1]
*   **MASTG Test Case:** [e.g., MASTG-TEST-0020]
*   **CWE Root Cause:** [e.g., CWE-295: Improper Certificate Validation]

---

### [TECHNICAL REQUIREMENTS]

**1. Target Data (MasterclassData)**
The following existing data point(s) must be utilized in this vector to demonstrate the leak:
*   `MasterclassData.[CATEGORY].[SPECIFIC_FIELD]`

**2. Vulnerable Implementation (:app-vulnerable)**
*   **Execution Vector:** [Define precisely how the insecure code should be written. e.g., "Implement a custom TrustManager that bypasses all SSL certificate checks and ignores HostnameVerifier."]
*   **Expected Impact:** [What does this allow the attacker to do? e.g., "Allows MitM proxies like Burp Suite or Charles to intercept cleartext traffic."]

**3. Attacker Implementation (:app-attacker)**
*   [ ] **Required:** [Describe the PoC exploit. e.g., "Write a BroadcastReceiver that intercepts the implicit Intent containing the token."]
*   [ ] **Not Applicable:** [Check this if the vulnerability is passive (e.g., local storage dump via ADB) and does not require an active IPC exploit application.]

**4. Secure Implementation (:app-secure)**
*   **Required Mitigation:** [Define the exact technical solution. e.g., "Implement OkHttp CertificatePinner validating the SHA-256 hash of the target endpoint's public key."]

---

### [ACCEPTANCE CRITERIA]
- [ ] Enum vector added to `common` module.
- [ ] `:app-vulnerable` logic implemented and heavily commented with security warnings.
- [ ] `:app-secure` logic implemented and heavily commented with mitigation rationale.
- [ ] Appropriate PoC added to `:app-attacker` (if applicable).
- [ ] No raw sensitive data written to system buffers/disk in `:app-secure`.
- [ ] Documentation file added under `docs/maswe/MASWE-XXXX.md`.
