package com.hasantuncay.mobsec.auditor

import com.hasantuncay.mobsec.auditor.domain.AuditSession as DomainAuditSession
import com.hasantuncay.mobsec.auditor.domain.AuditSessionAggregator as DomainAuditSessionAggregator
import com.hasantuncay.mobsec.auditor.domain.CategoryStatus as DomainCategoryStatus
import com.hasantuncay.mobsec.core.auditor.models.AuditVerdict as CoreAuditVerdict

typealias AuditSession = DomainAuditSession
typealias AuditSessionAggregator = DomainAuditSessionAggregator
typealias CategoryStatus = DomainCategoryStatus
typealias AuditVerdict = CoreAuditVerdict
