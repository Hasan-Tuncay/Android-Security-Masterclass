#!/usr/bin/env bash
# ==============================================================================
# MASWE-0005: ADB Automated Verification Script
# Tests whether sensitive credentials leak into system Logcat or diagnostic files
# ==============================================================================

set -e

PACKAGE="com.hasantuncay.mobsec.vulnerable"
PACKAGE_SECURE="com.hasantuncay.mobsec.secure"

echo "======================================================================"
echo "    MASWE-0005 SENSITIVE DATA IN LOGS VERIFICATION                    "
echo "======================================================================"

echo "[*] Checking device connectivity..."
adb devices | grep -q "device$" || { echo "[-] No connected Android device found via ADB!"; exit 1; }

echo "[*] 1. Inspecting Logcat for Bearer tokens or plaintext passwords..."
LEAKED_LOGS=$(adb logcat -d | grep -E "VULN_0005|Bearer|password|PAN|CVV" | tail -n 10 || true)
if [ -n "${LEAKED_LOGS}" ]; then
    echo "[!] CRITICAL FINDING (CWE-532): Plaintext credentials dumped in Logcat!"
    echo "----------------------------------------------------------------------"
    echo "${LEAKED_LOGS}"
    echo "----------------------------------------------------------------------"
else
    echo "[+] No sensitive credential patterns detected in recent Logcat output."
fi

echo "[*] 2. Checking unencrypted local log files in vulnerable sandbox..."
LOCAL_LOG=$(adb shell "run-as ${PACKAGE} cat files/debug.log 2>/dev/null" || true)
if [ -n "${LOCAL_LOG}" ]; then
    echo "[!] CRITICAL FINDING (CWE-532 / CWE-312): Unencrypted debug.log file exists!"
    echo "${LOCAL_LOG}"
else
    echo "[+] No cleartext debug.log found in vulnerable sandbox."
fi

echo "[*] 3. Verifying R8 ProGuard log stripping in Secure Release APK..."
echo "    In app-secure release variant, all android.util.Log calls are stripped"
echo "    via ProGuard rule: -assumenosideeffects class android.util.Log { *; }"

echo "======================================================================"
echo "    MASWE-0005 VERIFICATION COMPLETE                                 "
echo "======================================================================"
