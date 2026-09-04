#!/usr/bin/env bash
# ==============================================================================
# MASWE-0007: ADB Automated Cryptographic Verification Script
# Tests whether vulnerable cryptographic algorithms and modes are executed
# ==============================================================================

set -e

PACKAGE_VULN="com.hasantuncay.mobsec.vulnerable"
PACKAGE_SECURE="com.hasantuncay.mobsec.secure"

echo "======================================================================"
echo "    MASWE-0007 IMPROPER ENCRYPTION AUDIT & VERIFICATION                "
echo "======================================================================"

echo "[*] Checking device connectivity..."
adb devices | grep -q "device$" || { echo "[-] No connected Android device found via ADB!"; exit 1; }

echo "[*] 1. Auditing Logcat for vulnerable cryptographic transformations..."
VULN_CRYPTO_LOGS=$(adb logcat -d | grep -E "MASWE_0007.*(DES|ECB|STATIC ZERO IV|KEY REUSE|NON-CRYPTO)" | tail -n 10 || true)

if [ -n "${VULN_CRYPTO_LOGS}" ]; then
    echo "[!] CRITICAL FINDING (MASWE-0007 / CWE-327): Insecure cryptographic operations detected!"
    echo "----------------------------------------------------------------------"
    echo "${VULN_CRYPTO_LOGS}"
    echo "----------------------------------------------------------------------"
else
    echo "[+] No recent insecure cryptographic logs detected in Logcat."
fi

echo ""
echo "[*] 2. Auditing Secure App for AES-256-GCM authenticated execution..."
SECURE_CRYPTO_LOGS=$(adb logcat -d | grep -E "MASWE_0007.*(AES-256-GCM|RANDOM 12-BYTE IV|NO REPEATING PATTERNS)" | tail -n 10 || true)

if [ -n "${SECURE_CRYPTO_LOGS}" ]; then
    echo "[+] SECURE PASS: AES-256-GCM and unique IV generation verified in Secure App."
    echo "${SECURE_CRYPTO_LOGS}"
fi

echo "======================================================================"
echo "    MASWE-0007 VERIFICATION COMPLETE                                 "
echo "======================================================================"
