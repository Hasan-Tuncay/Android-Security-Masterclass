package com.hasantuncay.mobsec.common.models.data.threat

/**
 * Network and Session Management Data Model.
 * Represents tokens and cookies used to maintain authenticated states and prevent spoofing.
 */
data class SessionData(
    /** JWT Bearer token used for authorization headers in API requests. */
    val oAuth2BearerToken: String = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
    /** A long-lived token used to generate new short-lived Bearer tokens. Highly sensitive. */
    val oAuth2RefreshToken: String = "dGhpcyBpcyBhIHJlZnJlc2ggdG9rZW4gc2FtcGxl",
    /** Cross-Site Request Forgery (CSRF) token to prevent state-changing malicious requests. */
    val csrfToken: String = "8a7b6c5d4e3f2a1b9c8d7e6f5a4b3c2d",
    /** A session identifier cookie stored in the application's WebView CookieManager. */
    val webViewSessionCookie: String = "JSESSIONID=DF345GHT1289XC; Path=/; HttpOnly"
)
