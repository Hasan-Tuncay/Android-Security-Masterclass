package com.hasantuncay.mobsec.common.models.data.threat

/**
 * User Vector Data Model.
 * Represents critical data generated or owned by the application's user.
 */
data class UserData(
    /** A plaintext password residing in the Heap memory (In-Use state). VULNERABLE. */
    val plainTextPasswordInHeap: String = "P@ssw0rd_Super_Secret_2026!",
    /** 
     * SECURE (CWE-226/316): Stored in a mutable CharArray instead of an immutable String.
     * This allows us to overwrite the memory block deterministically. 
     */
    val securePasswordInHeap: CharArray = charArrayOf('P', '@', 's', 's', 'w', '0', 'r', 'd', '1', '2', '3'),
    /** A cryptographically secure hashed password derived using PBKDF2-HMAC-SHA256. */
    val pbkdf2PasswordHash: String = "pbkdf2:sha256:29000:D8H9...:F9A2...",
    /** Data copied to the device's global clipboard, accessible by other applications. */
    val clipboardCache: String = "Copied 2FA Code: 849201",
    val draftMessagesDb: List<String> = listOf("The corporate merger will be announced tomorrow, buy the stock.")
) {
    /**
     * MASVS-CODE (Memory Scrubbing / CWE-226)
     * Deterministik bellek temizliği (Zeroization).
     * JVM Garbage Collector'ı beklemeden veriyi RAM üzerinde sıfırlar.
     */
    fun scrubPassword() {
        securePasswordInHeap.fill('0')
    }

    override fun toString() = "[REDACTED_USER_DATA]"
    
    // Arrays used in data classes require overriding equals/hashCode
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as UserData
        if (!securePasswordInHeap.contentEquals(other.securePasswordInHeap)) return false
        return true
    }

    override fun hashCode(): Int {
        return securePasswordInHeap.contentHashCode()
    }
}
