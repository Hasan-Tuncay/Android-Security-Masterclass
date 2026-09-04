#!/usr/bin/env bash
# ==============================================================================
# MASWE-0001: Terminal Proof-of-Concept & Private Storage Leak Audit
# ==============================================================================
set -euo pipefail

TARGET_PKG="com.hasantuncay.mobsec.vulnerable"

echo "======================================================================"
echo " [MASWE-0001] Insecure Private Storage Verification (adb shell)"
echo "======================================================================"

echo "[*] Checking SharedPreferences XML files for cleartext tokens..."
adb shell "su -c 'ls -la /data/data/$TARGET_PKG/shared_prefs/'" 2>/dev/null || \
adb shell "run-as $TARGET_PKG ls -la /data/data/$TARGET_PKG/shared_prefs/" 2>/dev/null || {
    echo "[-] Cannot access internal sandbox directly without root or debuggable flag."
    echo "    Attempting adb backup extraction..."
    exit 1
}

echo "[*] Dumping SharedPreferences XML content:"
adb shell "su -c 'cat /data/data/$TARGET_PKG/shared_prefs/*.xml'" 2>/dev/null || \
adb shell "run-as $TARGET_PKG cat /data/data/$TARGET_PKG/shared_prefs/*.xml" 2>/dev/null || true

echo "======================================================================"
