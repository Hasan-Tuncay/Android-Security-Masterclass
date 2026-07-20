package com.hasantuncay.mobsec.common.models.data.threat

/**
 * User Vector Data Model.
 * Represents critical data generated or owned by the application's user.
 */
data class UserData(
    /** A plaintext password residing in the Heap memory (In-Use state). */
    val plainTextPasswordInHeap: String = "P@ssw0rd_Super_Secret_2026!",
    /** A cryptographically secure hashed password derived using PBKDF2-HMAC-SHA256. */
    val pbkdf2PasswordHash: String = "pbkdf2:sha256:29000:D8H9...:F9A2...",
    /** Data copied to the device's global clipboard, accessible by other applications. */
    val clipboardCache: String = "Copied 2FA Code: 849201",
    /** Private messages stored locally in a SQLite database (e.g., Room). */
    val draftMessagesDb: List<String> = listOf("The corporate merger will be announced tomorrow, buy the stock.")
)
