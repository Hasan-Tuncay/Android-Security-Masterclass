package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasantuncay.mobsec.common.models.data.threat.AnalyticsLogData
import com.hasantuncay.mobsec.common.models.data.threat.DeviceTelemetryData
import com.hasantuncay.mobsec.common.models.data.threat.SessionData
import com.hasantuncay.mobsec.common.models.data.threat.SystemData
import com.hasantuncay.mobsec.common.models.data.threat.UserData

@Composable
fun SystemDataCard(data: SystemData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "System & Crypto", modifier = modifier) {
        ReadOnlyDataField("Master Key Alias", data.masterKeyAlias)
        ReadOnlyDataField("RSA Private Key", data.rsaPrivateKeyPem, isSensitive = true)
        ReadOnlyDataField("Initialization Vector (IV)", data.hardcodedIv)
        ReadOnlyDataField("Cryptographic Salt", data.cryptographicSalt)
    }
}

@Composable
fun DeviceTelemetryCard(data: DeviceTelemetryData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Device Telemetry", modifier = modifier) {
        ReadOnlyDataField("Android SSAID", data.androidSsaid)
        ReadOnlyDataField("MAC Address", data.macAddress)
        ReadOnlyDataField("FCM Push Token", data.fcmPushToken)
        ReadOnlyDataField("Current GPS Location", data.currentGpsLocation)
    }
}

@Composable
fun SessionDataCard(data: SessionData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Network Session", modifier = modifier) {
        ReadOnlyDataField("OAuth2 Bearer Token", data.oAuth2BearerToken, isSensitive = true)
        ReadOnlyDataField("Refresh Token", data.refreshToken, isSensitive = true)
        ReadOnlyDataField("WebView Cookie", data.webViewSessionCookie)
        ReadOnlyDataField("CSRF Token", data.antiCsrfToken)
    }
}

@Composable
fun AnalyticsLogCard(data: AnalyticsLogData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Analytics & Logs", modifier = modifier) {
        ReadOnlyDataField("Mixpanel Payload", data.mixpanelEventPayload)
        ReadOnlyDataField("Firebase Crash Dump", data.firebaseCrashDump)
    }
}

@Composable
fun UserDataCard(data: UserData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "User Context", modifier = modifier) {
        ReadOnlyDataField("Password (Plain Text)", data.plainTextPasswordInHeap, isSensitive = true)
        ReadOnlyDataField("Password Hash", data.passwordHashPbkdf2)
        ReadOnlyDataField("Security Question", data.securityQuestionAnswer)
        ReadOnlyDataField("Preferences", data.userPreferencesJson)
    }
}
