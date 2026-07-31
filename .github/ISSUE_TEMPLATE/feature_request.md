---
name: "🚀 Feature Request / New Module Proposal"
about: Suggest a new MASWE vulnerability module or feature improvement
title: "[FEATURE] "
labels: enhancement, help wanted
assignees: ''
---

## 📋 Summary

A clear and concise description of what you want to happen.

## 🎯 MASWE / MASVS Reference (if applicable)

- **MASWE ID:** (e.g., MASWE-0064)
- **MASVS Category:** (e.g., MASVS-STORAGE, MASVS-CRYPTO, MASVS-NETWORK)
- **CWE Reference:** (e.g., CWE-532)

## 💡 Proposed Implementation

### `:app-vulnerable` (Insecure Logic)
Describe what the vulnerable implementation should look like.

### `:app-secure` (Hardened Logic)
Describe the secure counterpart and which mitigation techniques should be used.

### `:app-attacker` (Exploit PoC)
If applicable, describe how the attacker app could exploit this vulnerability.

## 📚 References

- Link to OWASP documentation
- Link to relevant Android documentation
- Any other resources

## ✅ Acceptance Criteria

- [ ] Vulnerable module implemented with realistic flaws
- [ ] Secure module implemented with industry best practices
- [ ] Documentation added to `docs/` directory
- [ ] `MAPPING_MATRIX.md` updated
- [ ] All three apps build and run without errors
