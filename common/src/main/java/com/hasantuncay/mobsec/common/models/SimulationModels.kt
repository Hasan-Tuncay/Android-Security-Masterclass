package com.hasantuncay.mobsec.common.models

/**
 * A "Safe" DTO that only contains non-sensitive data.
 * Used in secure logging demonstrations.
 */
data class SafeUserDto(
    val username: String
)

/**
 * A vulnerable model that includes PII (credit card).
 * Used in vulnerable logging demonstrations.
 */
data class DomainUser(
    val username: String,
    val creditCard: String
)
