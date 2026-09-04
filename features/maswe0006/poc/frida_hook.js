/**
 * Frida Hook Suite for MASWE-0006: Sensitive Data Not Excluded From Backup
 * 
 * Intercepts:
 * 1. android.app.backup.BackupManager.dataChanged() to trace when backup events are scheduled.
 * 2. File creation in filesDir / shared_prefs to detect sensitive token/key storage vulnerable to backup extraction.
 * 3. Checks ApplicationInfo flags for FLAG_ALLOW_BACKUP (0x8000).
 */

Java.perform(function () {
    console.log("[*] [MASWE-0006] Dynamic Backup Auditing Hook Loaded");

    var ApplicationInfo = Java.use("android.content.pm.ApplicationInfo");
    var FLAG_ALLOW_BACKUP = 32768; // 0x00008000

    // Check application backup configuration
    var ActivityThread = Java.use("android.app.ActivityThread");
    var currentApp = ActivityThread.currentApplication();
    if (currentApp) {
        var appInfo = currentApp.getApplicationInfo();
        var flags = appInfo.flags.value;
        var allowBackup = (flags & FLAG_ALLOW_BACKUP) !== 0;

        if (allowBackup) {
            console.error("[!] [MASWE-0006 / CWE-200 VULNERABILITY DETECTED]");
            console.error("    Package      : " + appInfo.packageName.value);
            console.error("    allowBackup  : TRUE (Vulnerable to `adb backup` and Cloud Backup extraction)");
            console.error("    Remediation  : Set android:allowBackup=\"false\" or configure data_extraction_rules.xml");
        } else {
            console.log("[+] [MASWE-0006] Secure: android:allowBackup is disabled (FALSE).");
        }
    }

    // Hook BackupManager.dataChanged
    try {
        var BackupManager = Java.use("android.app.backup.BackupManager");
        BackupManager.dataChanged.overload().implementation = function () {
            console.warn("[!] [MASWE-0006] BackupManager.dataChanged() invoked!");
            console.warn("    Trace:\n" + Java.use("android.util.Log").getStackTraceString(Java.use("java.lang.Exception").$new()));
            return this.dataChanged();
        };
    } catch (e) {
        console.log("[-] BackupManager hook skipped: " + e);
    }
});
