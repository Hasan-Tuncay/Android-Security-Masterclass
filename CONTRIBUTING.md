# Contributing to Android Security Masterclass

Thank you for your interest in contributing to the **Android Security Masterclass** project. This document explains everything you need to know to make a meaningful, high-quality contribution.

Please read this guide carefully before opening a Pull Request. Contributions that do not follow this guide will be asked to revise before merging.

---

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Project Philosophy](#project-philosophy)
- [Project Architecture](#project-architecture)
- [How to Add a New MASWE Module](#how-to-add-a-new-maswe-module)
- [Documentation Standards](#documentation-standards)
- [Code Standards](#code-standards)
- [Security Data Model Rules](#security-data-model-rules)
- [Commit Message Convention](#commit-message-convention)
- [Pull Request Process](#pull-request-process)
- [What We Will Not Accept](#what-we-will-not-accept)

---

## Code of Conduct

This project follows the [OWASP Code of Conduct](https://owasp.org/www-policy/operational/code-of-conduct). By contributing, you agree to its terms. Be respectful, constructive, and security-minded in all communications.

---

## Project Philosophy

Before contributing, understand the core principles that every contribution must uphold:

### 1. Standards First
Every vulnerability module must be traceable to a **specific, verifiable standard**. We reference:
- **OWASP MASWE** — The weakness ID (e.g., `MASWE-0001`)
- **OWASP MASVS** — The verification standard requirement (e.g., `MASVS-STORAGE-2`)
- **OWASP MASTG-BEST** — The best practice guidance (e.g., `MASTG-BEST-0002`)
- **Android Official Documentation** — Google's own security guidelines

Do not implement a vulnerability or mitigation without citing which standard it addresses. If you cannot point to a standard, the contribution is out of scope.

### 2. Mirror Architecture — Always Both Sides
Every feature must be implemented **twice**:
- ❌ **`:app-vulnerable`** — The realistic, exploitable version with annotated explanation of why it is dangerous
- ✅ **`:app-secure`** — The production-quality, hardened version with annotated explanation of every mitigation decision

A PR that only implements one side will not be accepted.

### 3. The Code is the Textbook
Comments and KDoc are not optional. Every non-trivial security decision in the code must be explained inline. A developer reading the file for the first time — without any external context — should understand what the vulnerability is, why it is dangerous, and why the mitigation works. The code comment is the lecture.

### 4. No Assumptions, No False Claims
Do not claim a mitigation works if you have not verified it. Do not reference a standard you have not read. Quality over quantity. One thoroughly implemented module is worth more than three superficial ones.

---

## Project Architecture

```
AndroidSecurityMasterclass/
├── common/                    # Shared module: data models, UI components, navigation
│   └── models/data/
│       ├── MasterclassData.kt     # Root data wrapper injected into both apps
│       ├── compliance/            # GDPR, HIPAA, PCI-DSS data models
│       ├── threat/                # System, network, device telemetry models
│       └── classification/        # Data sensitivity classification
│
├── app-vulnerable/            # Insecure implementations
│   └── storage/
│       └── maswe0001/         # One directory per MASWE weakness ID
│
├── app-secure/                # Hardened implementations
│   └── storage/
│       └── maswe0001/
│
└── docs/
    ├── maswe/                 # One .md file per MASWE weakness
    └── mastg-best/            # One .md file per MASTG best practice
```

### The `MasterclassData` Object

Both apps receive the same `MasterclassData` object, which contains realistic dummy payloads representing every category of sensitive data a real application might handle:

| Field | Data Category | Standard |
|---|---|---|
| `gdprPii` | Names, email, national ID | GDPR Article 4 / Article 9 |
| `hipaaPhi` | ICD-10 diagnosis codes | HIPAA §164.514 |
| `pciDss` | PAN, CVV, PIN | PCI-DSS Req. 3 |
| `systemContext` | AES keys, RSA private keys | MASVS-CRYPTO |
| `networkSession` | OAuth tokens, CSRF tokens, cookies | MASVS-NETWORK |
| `deviceTelemetry` | SSAID, advertising ID, geolocation | MASVS-PRIVACY |

**Do not add new top-level fields to `MasterclassData` without discussing it in an Issue first.** Any addition affects both apps and all existing modules.

---

## How to Add a New MASWE Module

Follow these steps exactly. Do not skip any step.

### Step 1 — Open an Issue First

Before writing any code, open a GitHub Issue with:
- The MASWE weakness ID you want to implement (e.g., `MASWE-0002`)
- A brief description of the attack vectors you plan to demonstrate
- The standards you will reference (MASWE, MASVS, MASTG-BEST, Android Docs)

Wait for a maintainer to confirm the scope before starting work. This prevents duplicate effort and scope creep.

### Step 2 — Create the Vector Enum

In `common/models/`, create a new enum class following the pattern of `Maswe0001Vector.kt`:

```kotlin
// common/src/main/java/com/hasantuncay/mobsec/common/models/Maswe0002Vector.kt
enum class Maswe0002Vector(
    @StringRes val titleVulnRes: Int,
    @StringRes val titleSecureRes: Int,
    @StringRes val msgVulnRes: Int,
    @StringRes val msgSecureRes: Int,
    val icon: ImageVector
) {
    SHARED_PREFERENCES(...),
    SQLITE_UNENCRYPTED(...),
    // etc.
}
```

Each enum entry represents one distinct attack vector within the weakness.

### Step 3 — Implement the Vulnerable Logic

Create `app-vulnerable/src/.../storage/maswe0002/Maswe0002VulnerableLogic.kt`.

Rules for the vulnerable implementation:
- The code must be **realistic** — it should look like something a real developer would accidentally write, not a cartoon exploit
- Every dangerous line must have an inline comment explaining **why it is dangerous** (CWE reference, attack scenario)
- Never use actual production secrets — all data comes from `MasterclassData`

### Step 4 — Implement the Secure Logic

Create `app-secure/src/.../storage/maswe0002/Maswe0002SecureLogic.kt`.

Rules for the secure implementation:
- Every mitigation decision must be documented with a KDoc comment explaining the **"why"**, not just the "what"
- Where multiple mitigation approaches exist, document the tradeoffs
- Reference the specific standard that mandates or recommends the control
- If a third-party library is used (e.g., Jetpack Security), explain why it was chosen over alternatives

### Step 5 — Update `proguard-rules.pro` (if applicable)

If the new module introduces new classes that should be stripped in Release builds, add the corresponding `-assumenosideeffects` rules with documentation.

### Step 6 — Write the Documentation

Create two documentation files:

**`docs/maswe/MASWE-0002-[Short-Name].md`** — Must contain:
- Overview of the weakness
- Vulnerable implementation description (5 vectors max per module)
- Secure implementation description with all mitigation groups
- Summary table of all controls

**`docs/mastg-best/MASTG-BEST-XXXX-[Short-Name].md`** (if applicable) — For any corresponding MASTG best practice.

See [`docs/maswe/MASWE-0001-Logging-Leaks.md`](docs/maswe/MASWE-0001-Logging-Leaks.md) as the reference template.

### Step 7 — Update `README.md`

Move your weakness from `⏳ Upcoming` to `✅ Completed` in the vulnerability index table.

---

## Documentation Standards

- All documentation must be written in **English**
- Use standard Markdown. No HTML unless absolutely necessary
- Every code block must have a language specifier (` ```kotlin `, ` ```proguard `, etc.)
- Link directly to specific files in the repository, not to external copies
- Do not copy-paste entire sections of OWASP documentation. Summarize, cite, and link
- CWE references must include both the ID and name (e.g., `CWE-532: Insertion of Sensitive Information into Log File`)

---

## Code Standards

### Language and Tooling
- **Language:** Kotlin only. No Java
- **UI:** Jetpack Compose + Material 3 only
- **Architecture:** Follow the existing MVVM pattern
- **Min SDK:** API 26 (Android 8.0)

### Style
- Follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Do not suppress lint warnings without a documented reason
- Do not use `@SuppressWarnings` or `@Suppress` to silence security-relevant warnings

### Security-Specific Rules
- **Never use `Log.d/e/i/w` directly** in `:app-secure`. Use `SecureLog` exclusively
- **Never concatenate runtime values into log strings** — use the `vararg` parameterized form: `SecureLog.d("Tag", "Value: %s", value)`
- **All `toString()` overrides** on data classes must return a `[REDACTED_...]` string — never real data
- **Mutable sensitive data** (passwords, keys) must use `CharArray` or `ByteArray`, not `String`

---

## Security Data Model Rules

The `MasterclassData` object contains sensitive dummy data. The following rules apply to all code that handles this data:

1. **Never log raw sensitive fields directly.** Always use the parameterized `SecureLog` hybrid model
2. **Never write raw sensitive fields to disk.** Encrypt first (Jetpack Security) or mask/redact before writing
3. **Never send raw PII to third-party SDKs.** Hash or minimize first
4. **Data class `toString()` must always be overridden** to return `[REDACTED_CLASSNAME]`
5. **Fields wrapped in `ToMask<T>`** must never have their value accessed directly — always call `.getDataToMask()` consciously

Violating any of these rules in `:app-secure` is a blocking issue for PR merge.

---

## Commit Message Convention

We follow [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>(<scope>): <short description>
```

| Type | When to Use |
|---|---|
| `feat` | New vulnerability module or mitigation |
| `fix` | Bug fix in existing logic |
| `docs` | Documentation changes only |
| `build` | Gradle, ProGuard, dependency changes |
| `refactor` | Code restructuring without behavior change |
| `test` | Test-related changes |
| `chore` | Maintenance tasks |

**Examples:**
```
feat: Implement MASWE-0002 SharedPreferences insecure storage module
docs: Add MASTG-BEST-0003 secure network configuration guide
build: Update Jetpack Security to 1.1.0-beta01
fix: Correct PAN masking regex in secureLocalFileLeak
```

---

## Pull Request Process

1. **Fork** the repository and create a branch from `master`:
   ```bash
   git checkout -b feat/maswe-0002-insecure-storage
   ```

2. **Implement** your changes following all steps in this guide

3. **Self-review checklist** before opening a PR:
   - [ ] Both `:app-vulnerable` and `:app-secure` implementations are complete
   - [ ] All code has inline KDoc explaining the security rationale
   - [ ] All standards referenced (MASWE, MASVS, MASTG, Android Docs) are cited correctly
   - [ ] Documentation file created under `docs/maswe/`
   - [ ] `README.md` updated
   - [ ] No raw sensitive data logged, written to disk, or sent to third parties in `:app-secure`
   - [ ] `toString()` overridden on any new data class
   - [ ] Commit messages follow the convention

4. **Open a Pull Request** with:
   - A reference to the original Issue (`Closes #XX`)
   - A description of the attack vectors implemented
   - The MASWE/MASVS/MASTG standard references
   - A brief summary of the mitigations applied

5. A maintainer will review and may request changes. Address all review comments before re-requesting review.

---

## What We Will Not Accept

| Category | Reason |
|---|---|
| Mitigations without a cited standard | Unverifiable — could be wrong or misleading |
| Vulnerable-only PRs (no secure counterpart) | Incomplete — teaches the problem without the solution |
| Raw `Log.d/e/i/w` calls in `:app-secure` | Directly violates MASWE-0001 mitigation |
| Java code | Project is Kotlin-only |
| UI components that don't follow Material 3 | Consistency |
| PRs that modify `MasterclassData` without an Issue | High impact change requiring discussion |
| Placeholder comments ("// TODO: fix this") | Every comment must be complete and informative |
| Copied OWASP documentation | Copyright and quality concerns — summarize and link instead |

---

## Questions?

- **GitHub Discussions:** Open a Discussion for conceptual questions
- **GitHub Issues:** Open an Issue for bugs or new module proposals  
- **YouTube:** Follow the companion series at [Harpia Academy](https://www.youtube.com/@harpiaacademyofficial) for video walkthroughs of each module

---

*This project is an educational resource. Every contribution directly impacts the quality of security education for the Android development community. We take that responsibility seriously.*
