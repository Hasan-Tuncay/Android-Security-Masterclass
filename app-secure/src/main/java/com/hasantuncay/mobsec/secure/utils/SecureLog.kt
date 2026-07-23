package com.hasantuncay.mobsec.secure.utils

import android.util.Log
import com.google.errorprone.annotations.CompileTimeConstant
import com.hasantuncay.mobsec.secure.BuildConfig

/**
 * OWASP MASTG-BEST-0002 & MASWE-0001 (Logging Defenses)
 *
 * EDUCATIONAL OVERVIEW:
 * This class demonstrates three different approaches to logging and their security implications.
 * As an educational Android Security Masterclass, we showcase the VULNERABLE, STRICT, and HYBRID methods.
 * 
 * WHY NOT TIMBER? (Third-Party Logging vs Custom Implementation)
 * While `Timber` is the industry standard for Android logging and safely uses `vararg` to prevent
 * StringBuilder heap allocations, it lacks a critical security feature: `@CompileTimeConstant` enforcement.
 * Timber's method signatures do not enforce compile-time constants. If a developer incorrectly writes 
 * `Timber.d("Password: " + pass)`, Timber will accept it, bypassing static analysis and leaking the data 
 * into the Heap. By owning this `SecureLog` class, we inject ErrorProne annotations directly into the 
 * method signatures, making such developer errors fail at compile-time.
 */
object SecureLog {

    /**
     * ==========================================
     * METHOD 1: VULNERABLE / UNSAFE (Bypass)
     * ==========================================
     * Allows dynamic string concatenation: `SecureLog.dUnsafe("Tag", "Pass: " + pass)`
     * - Defeats ErrorProne `@CompileTimeConstant` checks (no annotation).
     * - Causes StringBuilder Heap Memory Leaks (MASTG-BEST-0002 violation).
     * - Included here strictly for demonstration/educational purposes.
     */
    @JvmStatic
    fun dUnsafe(tag: String, message: String) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }

    /**
     * ==========================================
     * METHOD 2: STRICT CONSTANT (Maximum Security)
     * ==========================================
     * Enforces Google's strictest interpretation. Only accepts compile-time constants.
     * NO dynamic runtime data (variables, IDs) can be logged.
     * - `SecureLog.dStrict("Tag", "System initialized")` -> PASS
     * - `SecureLog.dStrict("Tag", "User: " + id)` -> ERROR PRONE COMPILER FAILURE
     */
    @JvmStatic
    fun dStrict(tag: String, @CompileTimeConstant message: String) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }

    /**
     * ==========================================
     * METHOD 3: HYBRID / SAFE PARAMETERIZED (Recommended)
     * ==========================================
     * Enforces a constant format string, but allows dynamic variables via `vararg`.
     * - Stops StringBuilder leak BEFORE the call (preventing Heap dumps).
     * - Forces structured logging.
     * - `SecureLog.d("Tag", "User ID: %s", id)` -> PASS
     */
    @JvmStatic
    fun d(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.d(tag, formatMessage(message, *args))
        }
    }

    @JvmStatic
    fun e(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.e(tag, formatMessage(message, *args))
        }
    }

    @JvmStatic
    fun i(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.i(tag, formatMessage(message, *args))
        }
    }

    @JvmStatic
    fun w(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.w(tag, formatMessage(message, *args))
        }
    }

    @JvmStatic
    fun wtf(tag: String, @CompileTimeConstant message: String, vararg args: Any?) {
        if (RemoteConfigSim.isLoggingKilled) return
        if (BuildConfig.DEBUG) {
            Log.wtf(tag, formatMessage(message, *args))
        }
    }

    private fun formatMessage(message: String, vararg args: Any?): String {
        return if (args.isNotEmpty()) {
            try {
                String.format(message, *args)
            } catch (ex: Exception) {
                message
            }
        } else {
            message
        }
    }
}
