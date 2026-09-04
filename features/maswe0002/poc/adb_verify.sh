#!/usr/bin/env bash
# ==============================================================================
# MASWE-0002: ADB Automated Verification Script
# Tests whether external files directory leaks sensitive data or plaintext keys
# ==============================================================================

set -e

PACKAGE="com.hasantuncay.mobsec.vulnerable"
PACKAGE_SECURE="com.hasantuncay.mobsec.secure"
EXTERNAL_PATH="/sdcard/Android/data/${PACKAGE}/files"
EXTERNAL_PATH_SECURE="/sdcard/Android/data/${PACKAGE_SECURE}/files"

echo "======================================================================"
echo "    MASWE-0002 EXTERNAL STORAGE & KEY LEAKAGE VERIFICATION            "
echo "======================================================================"

echo "[*] Checking device connectivity..."
adb devices | grep -q "device$" || { echo "[-] No connected Android device found via ADB!"; exit 1; }

echo "[*] 1. Inspecting Vulnerable External Storage Directory..."
adb shell "ls -la ${EXTERNAL_PATH} 2>/dev/null" || echo "[!] Directory not yet created or inaccessible."

echo "[*] 2. Checking for plaintext JSON credential dumps..."
PLAINTEXT_DUMP=$(adb shell "cat ${EXTERNAL_PATH}/maswe0002_plaintext.json 2>/dev/null" || true)
if [ -n "${PLAINTEXT_DUMP}" ]; then
    echo "[!] CRITICAL FINDING (CWE-732): Plaintext credentials dumped in external storage!"
    echo "----------------------------------------------------------------------"
    echo "${PLAINTEXT_DUMP}"
    echo "----------------------------------------------------------------------"
else
    echo "[+] No plaintext file found in ${EXTERNAL_PATH}."
fi

echo "[*] 3. Checking for filesystem cryptographic key leaks (secret.key)..."
KEY_DUMP=$(adb shell "cat ${EXTERNAL_PATH}/secret.key 2>/dev/null" || true)
if [ -n "${KEY_DUMP}" ]; then
    echo "[!] CRITICAL FINDING (CWE-312): Cryptographic key stored on external filesystem!"
    echo "    Leaked key bytes: ${KEY_DUMP}"
else
    echo "[+] No cleartext secret.key file exposed."
fi

echo "[*] 4. Inspecting Secure App sandbox..."
echo "    Secure app uses internal private sandbox: /data/user/0/${PACKAGE_SECURE}/files/"
adb shell "ls -la ${EXTERNAL_PATH_SECURE} 2>/dev/null" || echo "[+] No files leaked in external storage for secure package."

echo "======================================================================"
echo "    MASWE-0002 VERIFICATION COMPLETE                                 "
echo "======================================================================"
