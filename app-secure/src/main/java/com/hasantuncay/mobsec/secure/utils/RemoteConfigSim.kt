package com.hasantuncay.mobsec.secure.utils

/**
 * Educational Simulation of a Remote Configuration service (like Firebase Remote Config).
 * Used to demonstrate the "Kill Switch" (Incident Response Flag) concept.
 */
object RemoteConfigSim {
    /**
     * INCIDENT RESPONSE FLAG (Kill Switch)
     * If a security incident is detected in production (e.g., a 3rd party SDK starts leaking PII to logs),
     * the backend can instantly set this flag to `true` without requiring an App Store update.
     * When true, `SecureLog` will immediately drop all incoming logs.
     */
    @Volatile
    var isLoggingKilled: Boolean = false
}
