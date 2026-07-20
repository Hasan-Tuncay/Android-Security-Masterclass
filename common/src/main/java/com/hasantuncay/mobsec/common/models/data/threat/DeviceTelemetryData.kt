package com.hasantuncay.mobsec.common.models.data.threat

/**
 * Device and OS Fingerprinting Data Model.
 * Modern threat actors target these identifiers to track devices when IMEI access is restricted.
 */
data class DeviceTelemetryData(
    /** The Android Secure Settings ID (SSAID). Unique per signing key / app. */
    val androidSsaid: String = "a1b2c3d4e5f6g7h8",
    /** The Wi-Fi MAC Address. Restricted in modern Android versions, often randomized. */
    val wlanMacAddress: String = "02:00:00:00:00:00",
    /** Firebase Cloud Messaging (FCM) Push Token. Can be abused to push malicious payloads. */
    val fcmPushToken: String = "bk3RNwTe3H0:CI2k_HHwgIpoDKCIZvvDMExUdFQ3P1...",
    /** Integrated Circuit Card Identifier. The unique serial number of the SIM card. */
    val simCardIccid: String = "8990123456789012345"
)
