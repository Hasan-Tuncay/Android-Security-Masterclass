package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.data.threat.AnalyticsLogData
import com.hasantuncay.mobsec.common.models.data.threat.DeviceTelemetryData
import com.hasantuncay.mobsec.common.models.data.threat.SessionData
import com.hasantuncay.mobsec.common.models.data.threat.SystemData
import com.hasantuncay.mobsec.common.models.data.threat.UserData

@Composable
fun SystemDataCard(data: SystemData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_system), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_keystore_alias), data.androidKeystoreAlias)
        ReadOnlyDataField(stringResource(id = R.string.label_master_key_aes), data.masterCryptoKeyAesGcm, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_rsa_private_key), data.rsaPrivateKeyPem, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_static_iv), data.staticInitializationVector)
        ReadOnlyDataField(stringResource(id = R.string.label_crypto_salt), data.cryptographicSalt)
    }
}

@Composable
fun DeviceTelemetryCard(data: DeviceTelemetryData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_device), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_android_ssaid), data.androidSsaid)
        ReadOnlyDataField(stringResource(id = R.string.label_wlan_mac), data.wlanMacAddress)
        ReadOnlyDataField(stringResource(id = R.string.label_fcm_token), data.fcmPushToken)
        ReadOnlyDataField(stringResource(id = R.string.label_sim_iccid), data.simCardIccid)
    }
}

@Composable
fun SessionDataCard(data: SessionData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_session), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_oauth_bearer), data.oAuth2BearerToken, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_oauth_refresh), data.oAuth2RefreshToken, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_webview_cookie), data.webViewSessionCookie)
        ReadOnlyDataField(stringResource(id = R.string.label_csrf_token), data.csrfToken)
    }
}

@Composable
fun AnalyticsLogCard(data: AnalyticsLogData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_analytics), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_mixpanel_payload), data.mixpanelEventPayload)
        ReadOnlyDataField(stringResource(id = R.string.label_crash_dump), data.crashDumpTrace)
    }
}

@Composable
fun UserDataCard(data: UserData, modifier: Modifier = Modifier) {
    ExpandableDataCard(title = stringResource(id = R.string.card_title_user), modifier = modifier) {
        ReadOnlyDataField(stringResource(id = R.string.label_password_plain), data.plainTextPasswordInHeap, isSensitive = true)
        ReadOnlyDataField(stringResource(id = R.string.label_password_hash), data.pbkdf2PasswordHash)
        ReadOnlyDataField(stringResource(id = R.string.label_clipboard_cache), data.clipboardCache)
        ReadOnlyDataField(stringResource(id = R.string.label_draft_messages), data.draftMessagesDb.joinToString())
    }
}
