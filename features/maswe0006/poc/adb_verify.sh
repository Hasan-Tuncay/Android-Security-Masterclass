#!/usr/bin/env bash
# ==============================================================================
# MASWE-0006: ADB Automated Verification Script
# Tests whether application sandbox data can be extracted via ADB backup
# ==============================================================================

set -e

PACKAGE_VULN="com.hasantuncay.mobsec.vulnerable"
PACKAGE_SECURE="com.hasantuncay.mobsec.secure"

echo "======================================================================"
echo "    MASWE-0006 SENSITIVE DATA IN BACKUP AUDIT & VERIFICATION          "
echo "======================================================================"

echo "[*] Checking device connectivity..."
adb devices | grep -q "device$" || { echo "[-] No connected Android device found via ADB!"; exit 1; }

echo "[*] 1. Auditing FLAG_ALLOW_BACKUP in Vulnerable App..."
VULN_FLAGS=$(adb shell dumpsys package ${PACKAGE_VULN} | grep "flags=" || true)
echo "    Vulnerable flags: ${VULN_FLAGS}"

if echo "${VULN_FLAGS}" | grep -q "ALLOW_BACKUP"; then
    echo "[!] CRITICAL FINDING (MASWE-0006 / CWE-200): FLAG_ALLOW_BACKUP is enabled!"
    echo "    Attempting simulated ADB backup extraction..."
    echo "    Command: adb backup -f maswe0006_test.ab -noapk ${PACKAGE_VULN}"
    echo "    Archive can be converted via: ( printf \"\x1f\x8b\x08\x00\x00\x00\x00\x00\" ; tail -c +25 maswe0006_test.ab ) | tar -ztvf -"
else
    echo "[-] ALLOW_BACKUP flag not present on vulnerable package."
fi

echo ""
echo "[*] 2. Auditing FLAG_ALLOW_BACKUP in Secure App..."
SECURE_FLAGS=$(adb shell dumpsys package ${PACKAGE_SECURE} | grep "flags=" || true)
echo "    Secure flags: ${SECURE_FLAGS}"

if echo "${SECURE_FLAGS}" | grep -q "ALLOW_BACKUP"; then
    echo "[!] AUDIT FAILED: FLAG_ALLOW_BACKUP still present in secure package!"
else
    echo "[+] SECURE PASS: FLAG_ALLOW_BACKUP is completely disabled in Secure App (android:allowBackup=\"false\")."
fi

echo "======================================================================"
echo "    MASWE-0006 VERIFICATION COMPLETE                                 "
echo "======================================================================"
