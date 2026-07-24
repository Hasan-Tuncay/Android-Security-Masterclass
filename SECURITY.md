# Security Policy

## Supported Versions
Only the latest release candidate or stable version in the `main` branch is currently supported with security updates.

| Version | Supported          |
| ------- | ------------------ |
| > 1.0.0 | :white_check_mark: |
| < 1.0.0 | :x:                |

## Scope
This repository contains intentionally vulnerable code for educational purposes. 

*   **OUT OF SCOPE:** Any vulnerabilities identified within the `:app-vulnerable` and `:app-attacker` modules. Do NOT report these. They are functioning as designed.
*   **IN SCOPE:** Unintended security flaws, cryptographic bypasses, or true 0-day vulnerabilities discovered in the `:app-secure` module, `common` module, or CI/CD pipelines.

## Reporting a Vulnerability
We take the security of the `:app-secure` reference implementations seriously. 

If you discover a legitimate security flaw within the in-scope modules, **do NOT open a public GitHub Issue.** 

Please report it via email directly to the maintainers: **[GÜVENLİK_EPOSTA_ADRESİNİZİ_YAZIN]**

### Response SLA
*   You will receive an initial acknowledgment within **48 hours**.
*   We will triage and validate the report within **7 days**.
*   If a patch is required, a security advisory will be drafted and credited to you prior to the public release.
