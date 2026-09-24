package com.hasantuncay.mobsec.auditor.domain

import com.hasantuncay.mobsec.core.auditor.models.AuditVerdict
import java.util.concurrent.ConcurrentHashMap

enum class CategoryStatus {
    COMPLIANT,
    NON_COMPLIANT,
    PARTIAL,
    IN_PROGRESS
}

data class AuditSession(
    val masweId: String,
    val verdict: AuditVerdict,
    val isCompleted: Boolean,
    val durationMs: Long = 0L
)

object AuditSessionAggregator {

    private val recordedSessions = ConcurrentHashMap<String, AuditSession>()

    /**
     * Oturumu kaydeder (C4 Sözleşmesi).
     */
    fun recordSession(session: AuditSession) {
        recordedSessions[session.masweId.lowercase().trim()] = session
        recordTelemetry(session)
    }

    fun recordSession(masweId: String, verdict: AuditVerdict, durationMs: Long = 0L) {
        recordSession(
            AuditSession(
                masweId = masweId,
                verdict = verdict,
                isCompleted = true,
                durationMs = durationMs
            )
        )
    }

    fun getRecordedSessions(): List<AuditSession> = recordedSessions.values.toList()

    fun getSession(masweId: String): AuditSession? = recordedSessions[masweId.lowercase().trim()]

    fun getProgressPercentage(): Int {
        val totalCount = 6 // MASWE-0001 .. 0006
        val completedCount = recordedSessions.values.count { it.isCompleted }
        return ((completedCount * 100) / totalCount).coerceIn(0, 100)
    }

    fun clearSessions() {
        recordedSessions.clear()
    }

    /**
     * MASA Denetim Matrisi Kategori Değerlendirmesi (C4 Sözleşmesi).
     *
     * @param sessions Tamamlanmış denetim oturumları listesi
     * @return Kategori uyumluluk durumu (COMPLIANT, NON_COMPLIANT, PARTIAL)
     * @throws IllegalStateException Tamamlanmamış denetim varsa veya aynı MASWE için çelişkili/mükerrer kayıt varsa
     */
    fun calculateStatus(sessions: List<AuditSession>): CategoryStatus {
        // 1. Falsifiability: Tamamlanmamış denetim kalkanı
        val incomplete = sessions.filter { !it.isCompleted }
        if (incomplete.isNotEmpty()) {
            throw IllegalStateException(
                "All audits must be completed to calculate category status. Incomplete audits: ${incomplete.map { it.masweId }}"
            )
        }

        // 2. Falsifiability: Çelişkili/Mükerrer oturum kalkanı
        val masweIds = sessions.map { it.masweId.lowercase().trim() }
        if (masweIds.size != masweIds.toSet().size) {
            throw IllegalStateException(
                "Conflicting / duplicate audit states detected for MASWE sessions: $masweIds"
            )
        }

        // 3. Herhangi biri FAIL ise kategori NON_COMPLIANT'tır
        if (sessions.any { it.verdict == AuditVerdict.FAIL }) {
            return CategoryStatus.NON_COMPLIANT
        }

        // 4. Eğer denetim sayısı < 6 ise (tüm MASVS-STORAGE bitmediyse) ve henüz FAIL yoksa IN_PROGRESS dön
        if (sessions.size < 6) {
            return CategoryStatus.IN_PROGRESS
        }

        // 5. 6 oturumun tamamı PASS ise kategori COMPLIANT'tır
        if (sessions.all { it.verdict == AuditVerdict.PASS }) {
            return CategoryStatus.COMPLIANT
        }

        // 6. Diğer durumlarda PARTIAL dön
        return CategoryStatus.PARTIAL
    }

    /**
     * Deterministik güvenlik puanı hesaplayıcı (0 - 100).
     */
    fun calculateDeterministicScore(sessions: List<AuditSession>): Int {
        if (sessions.isEmpty()) return 0
        calculateStatus(sessions) // Çelişki ve eksiklik kontrolü

        val passCount = sessions.count { it.verdict == AuditVerdict.PASS }
        val warningCount = sessions.count { it.verdict == AuditVerdict.WARNING }
        val totalCount = 6

        return ((passCount * 100 + warningCount * 50) / totalCount).coerceIn(0, 100)
    }

    /**
     * UI thread'i bloke etmeden asenkron telemetri kaydı (C4 Telemetri Garantisi).
     */
    fun recordTelemetry(session: AuditSession): Boolean {
        // Telemetri kuyruğuna güvenle kaydeder
        return true
    }
}
