package com.hasantuncay.mobsec.secure.utils

/**
 * Educational Simulation of a Remote Configuration service (like Firebase Remote Config).
 * Used to demonstrate the "Kill Switch" (Incident Response Flag) concept.
 * WHY WAS THIS INTEGRATED?
 * 1. Incident Response (Zero-Time Mitigation): If a vulnerability is discovered in Production (e.g., 
 *    a 3rd-party SDK starts leaking PII to logs), fixing the code, recompiling, and waiting for 
 *    Play Store approval can take DAYS.
 * 2. Instant Shutdown: By utilizing this remote flag, the backend can broadcast `isLoggingKilled = true`. 
 *    This instantly paralyses the logging infrastructure across millions of devices in real-time, 
 *    stopping the data leak without requiring an app update.
 * 3. Google Security Guidelines: Official Android documentation mandates that if logging is required 
 *    in Production, a conditional "shut down" switch (Kill Switch) must be implemented for incident response.
 */
object RemoteConfigSim {
    /**
     * INCIDENT RESPONSE FLAG (Kill Switch)
     * When true, `SecureLog` will immediately drop all incoming logs.
     */
    @Volatile
    var isLoggingKilled: Boolean = false
}
