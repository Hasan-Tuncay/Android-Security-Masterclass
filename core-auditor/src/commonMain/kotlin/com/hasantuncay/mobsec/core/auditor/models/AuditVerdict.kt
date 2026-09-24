package com.hasantuncay.mobsec.core.auditor.models

import kotlinx.serialization.Serializable

@Serializable
enum class AuditVerdict {
    PASS,
    FAIL,
    WARNING,
    INFO
}
