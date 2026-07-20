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
        ReadOnlyDataField("Keystore Alias", data.androidKeystoreAlias)
        ReadOnlyDataField("Master Key (AES)", data.masterCryptoKeyAesGcm, isSensitive = true)
        ReadOnlyDataField("RSA Private Key", data.rsaPrivateKeyPem, isSensitive = true)
        ReadOnlyDataField("Static IV", data.staticInitializationVector)
        ReadOnlyDataField("Cryptographic Salt", data.cryptographicSalt)
    }
}

@Composable
fun DeviceTelemetryCard(data: DeviceTelemetryData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Device Telemetry", modifier = modifier) {
        ReadOnlyDataField("Android SSAID", data.androidSsaid)
        ReadOnlyDataField("WLAN MAC", data.wlanMacAddress)
        ReadOnlyDataField("FCM Push Token", data.fcmPushToken)
        ReadOnlyDataField("SIM ICCID", data.simCardIccid)
    }
}

@Composable
fun SessionDataCard(data: SessionData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Network Session", modifier = modifier) {
        ReadOnlyDataField("OAuth2 Bearer", data.oAuth2BearerToken, isSensitive = true)
        ReadOnlyDataField("OAuth2 Refresh", data.oAuth2RefreshToken, isSensitive = true)
        ReadOnlyDataField("WebView Cookie", data.webViewSessionCookie)
        ReadOnlyDataField("CSRF Token", data.csrfToken)
    }
}

@Composable
fun AnalyticsLogCard(data: AnalyticsLogData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "Analytics & Logs", modifier = modifier) {
        ReadOnlyDataField("Mixpanel Payload", data.mixpanelEventPayload)
        ReadOnlyDataField("Crash Dump Trace", data.crashDumpTrace)
    }
}

@Composable
fun UserDataCard(data: UserData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = "User Context", modifier = modifier) {
        ReadOnlyDataField("Password (Plain)", data.plainTextPasswordInHeap, isSensitive = true)
        ReadOnlyDataField("Password Hash", data.pbkdf2PasswordHash)
        ReadOnlyDataField("Clipboard Cache", data.clipboardCache)
        ReadOnlyDataField("Draft Messages", data.draftMessagesDb.joinToString())
    }
}
