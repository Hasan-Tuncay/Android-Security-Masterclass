package com.hasantuncay.mobsec.attacker.navigation

import android.net.Uri

object DashboardRoute

data class ExploitReceiverRoute(
    val uriString: String?,
    val exploitId: String,
    val exploitDesc: String
)

object LogcatExploitRoute
