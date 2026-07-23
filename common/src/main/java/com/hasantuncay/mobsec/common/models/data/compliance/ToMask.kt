package com.hasantuncay.mobsec.common.models.data.compliance

/**
 * EDUCATIONAL DEMONSTRATION: Google's Official Field-Level Masking Wrapper
 * 
 * Instead of overriding `toString()` on the entire Data Class, this wrapper is applied
 * to specific sensitive fields (e.g., `val email: ToMask<String>`).
 * 
 * WHY IS THIS USEFUL?
 * - Prevents accidental logging when an error is encountered (returns "XX" instead of data).
 * - Makes it intentionally difficult for developers to invoke sensitive data (they must call `.getDataToMask()`).
 * - Facilitates Sensitive Data Usage Tracking via IDE Find Usages on `getDataToMask()`.
 */
data class ToMask<T>(private val data: T) {
    
    // Prevents accidental logging or string interpolation leaks.
    override fun toString() = "MASKED_FIELD_XX"
    
    // Forces explicit, conscious retrieval of the sensitive data.
    fun getDataToMask(): T = data
}
