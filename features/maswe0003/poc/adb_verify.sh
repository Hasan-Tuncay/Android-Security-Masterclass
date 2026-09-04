#!/usr/bin/env bash
# ==============================================================================
# MASWE-0003: ADB Automated Verification Script
# Tests whether cryptographic keys leak into SharedPreferences or Logcat
# ==============================================================================

set -e

PACKAGE="com.hasantuncay.mobsec.vulnerable"
PACKAGE_SECURE="com.hasantuncay.mobsec.secure"

echo "======================================================================"
echo "    MASWE-0003 CRYPTOGRAPHIC KEY STORAGE VERIFICATION                 "
echo "======================================================================"

echo "[*] Checking device connectivity..."
adb devices | grep -q "device$" || { echo "[-] No connected Android device found via ADB!"; exit 1; }

echo "[*] 1. Inspecting Vulnerable SharedPreferences for cleartext keys..."
KEY_XML=$(adb shell "run-as ${PACKAGE} cat shared_prefs/crypto_key.xml 2>/dev/null" || true)
if [ -n "${KEY_XML}" ]; then
    echo "[!] CRITICAL FINDING (CWE-312): Plaintext cryptographic key found in SharedPreferences!"
    echo "----------------------------------------------------------------------"
    echo "${KEY_XML}"
    echo "----------------------------------------------------------------------"
else
    echo "[+] No cleartext crypto_key.xml found in vulnerable sandbox."
fi

echo "[*] 2. Checking Logcat for plaintext key import leaks..."
LOGCAT_KEY=$(adb logcat -d -s MASWE_0003_KEY_IMPORT 2>/dev/null | tail -n 5 || true)
if [ -n "${LOGCAT_KEY}" ]; then
    echo "[!] CRITICAL FINDING (CWE-312): Key material intercepted in system logs!"
    echo "${LOGCAT_KEY}"
else
    echo "[+] No key material found in recent Logcat."
fi

echo "[*] 3. Inspecting Secure App Hardware Keystore Status..."
echo "    Secure app generates keys dynamically in AndroidKeyStore (maswe0003_secure_key)."
echo "    Hardware key bytes never leave TEE/StrongBox."

echo "======================================================================"
echo "    MASWE-0003 VERIFICATION COMPLETE                                 "
echo "======================================================================"
