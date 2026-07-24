package com.hasantuncay.mobsec.common.models.data.compliance

/**
 * EDUCATIONAL DEMONSTRATION: Memory Protection (Scrubbing/Zeroing)
 * 
 * Instead of overriding `toString()` on the entire Data Class, this wrapper is applied
 * to specific sensitive fields (e.g., `val email: ToMask`).
 * 
 * WHY CharArray INSTEAD OF String?
 * - Strings in Kotlin/Java are immutable and remain in the heap until Garbage Collection (GC) runs.
 * - This leaves the application vulnerable to Memory Dump (Heap Inspection) attacks.
 * - `CharArray` is mutable. Once we are done using the sensitive data, we explicitly
 *   call `wipe()` to overwrite the characters with zeros in memory before GC even runs.
 * 
 * WHY IS THIS USEFUL?
 * - Prevents accidental logging when an error is encountered (returns "XX" instead of data).
 * - Makes it intentionally difficult for developers to invoke sensitive data (they must call `.getDataToMask()`).
 * - Protects against RAM-scraping malware and heap dumps.
 */
data class ToMask(private val data: CharArray) {
    
    // Prevents accidental logging or string interpolation leaks.
    override fun toString() = "MASKED_FIELD_XX"
    
    // Forces explicit, conscious retrieval of the sensitive data.
    fun getDataToMask(): CharArray = data

    /**
     * Overwrites the array in memory with null characters.
     * Must be called manually in a `finally` block or immediately after the data is used.
     */
    fun wipe() {
        data.fill('\u0000')
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ToMask
        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
