package com.hasantuncay.mobsec.common.models.data.threat

/**
 * Analytics and Telemetry Data Model.
 * Specifically designed for testing MASWE-0001 (Logging Vulnerabilities), representing
 * data payloads accidentally sent to 3rd party SDKs like Firebase, Crashlytics, or Mixpanel.
 */
data class AnalyticsLogData(
    /** A simulated fatal crash trace containing leaked PII (User Email) in the stack dump. */
    val crashDumpTrace: String = "Fatal signal 11 (SIGSEGV) at 0x00000000 (code=1) - UserEmail: john.doe@example.com",
    /** A simulated Mixpanel/Amplitude event payload containing leaked PCI data (Credit Card Last 4). */
    val mixpanelEventPayload: String = "{\"event\": \"Checkout_Failed\", \"properties\": {\"cc_last_four\": \"5566\", \"error\": \"INSUFFICIENT_FUNDS\"}}"
)
