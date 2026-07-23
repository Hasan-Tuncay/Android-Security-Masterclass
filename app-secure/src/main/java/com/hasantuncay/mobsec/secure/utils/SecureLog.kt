package com.hasantuncay.mobsec.secure.utils

import android.util.Log
import com.google.errorprone.annotations.CompileTimeConstant
import com.hasantuncay.mobsec.secure.BuildConfig

/**
 * OWASP MASTG-BEST-0002: Remove Logging Code
 * 
 * WHY DID WE WRITE THIS CLASS?
 * In standard logging (e.g., Log.d("Tag", "Password: " + password)), even if the `Log.d` call
 * is stripped by ProGuard/R8, the Android compiler still compiles this line into a StringBuilder:
 * `new StringBuilder("Password: ").append(password).toString()`.
 * Stripping the `Log.d` method DOES NOT GUARANTEE the removal of the StringBuilder allocation.
 * 
 * As a result, the sensitive password is loaded into RAM (Memory) as plaintext. When hackers
 * capture a Memory Dump of the application, they will find the password in RAM, even though
 * it was never printed to the Logcat.
 * 
 * HOW DID WE SOLVE THIS?
 * 1. We DO NOT USE String Interpolation (`$password` or `"Password: " + password`).
 * 2. We pass the sensitive data strictly as a variable argument (`vararg`). E.g.: `SecureLog.d("Tag", "Password: %s", password)`
 * 3. On the ProGuard/R8 side (`proguard-rules.pro`), we specified that the `SecureLog` class
 *    has no side-effects (`-assumenosideeffects`). Thus, in Release builds, calls to these methods
 *    are COMPLETELY STRIPPED, preventing any String from being allocated in memory.
 */
object SecureLog {

    /**
     * Secure logging at the Debug level.
     * @param tag Log tag
     * @param message Message to be formatted (e.g., "User ID: %s")
     * @param args Arguments to be inserted into the formatted message
     */
    @JvmStatic
    fun d(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        // The String is only allocated in DEBUG mode.
        // Thanks to the ProGuard R8 rule, the LINE calling this method is completely stripped from the Release APK.
        if (BuildConfig.DEBUG) {
            Log.d(tag, formatMessage(message, *args))
        }
    }

    /**
     * Secure logging at the Error level.
     */
    @JvmStatic
    fun e(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, formatMessage(message, *args))
        }
    }

    /**
     * Secure logging at the Info level.
     */
    @JvmStatic
    fun i(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, formatMessage(message, *args))
        }
    }

    /**
     * Secure logging at the Warning level.
     */
    @JvmStatic
    fun w(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, formatMessage(message, *args))
        }
    }

    /**
     * Centralized message formatting. Returns the original message if no arguments are provided.
     */
    private fun formatMessage(message: String, vararg args: Any?): String {
        return if (args.isNotEmpty()) {
            try {
                String.format(message, *args)
            } catch (e: Exception) {
                // If String.format fails, print the original unformatted message as a fallback
                message
            }
        } else {
            message
        }
    }
}
