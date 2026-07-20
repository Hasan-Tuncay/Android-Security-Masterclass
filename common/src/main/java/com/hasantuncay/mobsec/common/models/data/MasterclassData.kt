package com.hasantuncay.mobsec.common.models.data

import com.hasantuncay.mobsec.common.models.data.classification.*
import com.hasantuncay.mobsec.common.models.data.compliance.*
import com.hasantuncay.mobsec.common.models.data.threat.*

/**
 * The Global Root Data Wrapper for all vulnerability screens.
 * This class will be injected via CompositionLocal into the entire application tree.
 * It contains every single theoretical piece of data required to demonstrate MASVS concepts.
 */
data class MasterclassData(
    // Compliance Standards
    val gdprPii: GdprPiiData = GdprPiiData(),
    val hipaaPhi: HipaaPhiData = HipaaPhiData(),
    val pciDss: PciDssData = PciDssData(),
    
    // System and Threat Models
    val userContext: UserData = UserData(),
    val systemContext: SystemData = SystemData(),
    val deviceTelemetry: DeviceTelemetryData = DeviceTelemetryData(),
    val networkSession: SessionData = SessionData(),
    val analyticsLogs: AnalyticsLogData = AnalyticsLogData(),
    
    // Data Classification
    val dataClassification: SensitivityClassificationData = SensitivityClassificationData()
)
