package com.hasantuncay.mobsec.auditor

import androidx.lifecycle.SavedStateHandle
import com.hasantuncay.mobsec.core.auditor.models.AuditorNode
import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

/**
 * Formel Sözleşme Testleri: C2 ve C4
 *
 * Referans Doküman: analysis_report.md
 * - C2: AuditorViewModel / Navigation & Backstack Management Sözleşmesi
 * - C4: AuditSessionAggregator / MASA Denetim Matrisi Kategori Değerlendirmesi
 *
 * Bu test sınıfı, app-auditor içinde üretilecek/genişletilecek olan AuditorViewModel ve
 * AuditSessionAggregator bileşenlerini doğrudan çağırarak sözleşme şartlarını doğrular.
 */
class AuditorViewModelContractTest {

    // =========================================================================
    // C2: Effectful ViewModel & Navigation Sözleşmesi
    // =========================================================================

    @Test
    fun test_C2_falsifiability_dangling_option_leaves_viewmodel_in_null_state() {
        // C2: Tanımsız ara durum oluşamaz, geçerli bir hata/fallback düğümü emit edilmelidir.
        val viewModel = AuditorViewModel()
        val danglingOption = Option("Bozuk Seçenek", "non_existent_node_999")

        viewModel.selectOption(danglingOption)
        val currentNode = viewModel.getCurrentNode()

        assertNotNull(
            "C2 Sözleşme İhlali: Var olmayan seçeneğe tıklanınca currentNode null olamaz! Geçerli bir fallback veya hata düğümü bekleniyor.",
            currentNode
        )
    }

    @Test
    fun test_C2_backstack_navigation_pops_safely_when_depth_greater_than_zero() {
        val viewModel = AuditorViewModel()
        viewModel.loadTree("maswe-0001")

        // q1 -> q2 geçişi
        val q1Node = viewModel.getCurrentNode() as QuestionNode
        val option = q1Node.options.first { it.text.contains("Evet") }
        viewModel.selectOption(option)

        assertEquals("q2", viewModel.currentNodeId)
        assertTrue("Backstack q1 düğümünü içermeli", viewModel.backStack.contains("q1"))

        // Geri tuşu (popBackStack) çağrısı
        val popped = viewModel.popBackStack()
        assertTrue("Derinlik > 0 iken pop işlemi başarılı olmalı", popped)
        assertEquals("Geri alındığında q1 düğümüne dönmeli", "q1", viewModel.currentNodeId)
    }

    @Test
    fun test_C2_backstack_pop_at_root_returns_false_to_navigate_dashboard() {
        val viewModel = AuditorViewModel()
        viewModel.loadTree("maswe-0001")

        // Başlangıçta (q1, depth == 0) geri tuşu basıldığında
        val popped = viewModel.popBackStack()
        assertFalse("Kök düğümde popBackStack false dönerek Dashboard'a çıkışı tetiklemeli", popped)
    }

    @Test
    fun test_C2_session_persists_on_configuration_change_via_savedstatehandle() {
        val handle = SavedStateHandle(mapOf("current_node_id" to "q2", "maswe_id" to "maswe-0001"))
        val viewModel = AuditorViewModel(savedStateHandle = handle)

        assertEquals("SavedStateHandle ile başlatılan ViewModel q2 düğümünde olmalı", "q2", viewModel.currentNodeId)
        assertEquals("maswe-0001", viewModel.currentMasweId)
    }

    @Test
    fun test_C2_falsifiability_rapid_double_tap_race_condition_protection() {
        val viewModel = AuditorViewModel()
        viewModel.loadTree("maswe-0001")
        val q1Node = viewModel.getCurrentNode() as QuestionNode
        val option = q1Node.options.first { it.text.contains("Evet") }

        // Hızlı ardışık çift tıklama
        viewModel.selectOption(option)
        viewModel.selectOption(option)

        assertEquals("q2", viewModel.currentNodeId)
        assertEquals("Backstack'e aynı geçiş iki kez eklenmemeli", 1, viewModel.backStack.size)
    }

    @Test
    fun test_C2_multi_maswe_registry_resolution() {
        val viewModel = AuditorViewModel()
        viewModel.loadTree("maswe-0002")
        assertEquals("maswe-0002", viewModel.currentMasweId)
        assertNotNull(viewModel.getCurrentNode())
    }

    // =========================================================================
    // C4: Effectful Denetim Agregasyonu ve Telemetri Sözleşmesi
    // =========================================================================

    @Test
    fun test_C4_category_status_is_compliant_when_all_storage_audits_pass() {
        val allPassSessions = (1..6).map { index ->
            AuditSession(
                masweId = "maswe-000$index",
                verdict = AuditVerdict.PASS,
                isCompleted = true,
                durationMs = 2500L
            )
        }
        val status = AuditSessionAggregator.calculateStatus(allPassSessions)
        val score = AuditSessionAggregator.calculateDeterministicScore(allPassSessions)

        assertEquals(CategoryStatus.COMPLIANT, status)
        assertEquals(100, score)
    }

    @Test
    fun test_C4_category_status_is_non_compliant_when_any_storage_audit_fails() {
        val auditsWithFailure = (1..6).map { index ->
            AuditSession(
                masweId = "maswe-000$index",
                verdict = if (index == 1) AuditVerdict.FAIL else AuditVerdict.PASS,
                isCompleted = true,
                durationMs = 3000L
            )
        }
        val status = AuditSessionAggregator.calculateStatus(auditsWithFailure)
        assertEquals(CategoryStatus.NON_COMPLIANT, status)
    }

    @Test
    fun test_C4_falsifiability_incomplete_audits_cannot_produce_category_score() {
        val incompleteAudits = listOf(
            AuditSession("maswe-0001", AuditVerdict.PASS, isCompleted = true),
            AuditSession("maswe-0002", AuditVerdict.PASS, isCompleted = false)
        )
        try {
            AuditSessionAggregator.calculateStatus(incompleteAudits)
            fail("Tamamlanmamış denetim varken calculateStatus IllegalStateException fırlatmalıydı")
        } catch (e: IllegalStateException) {
            assertTrue(e.message?.contains("completed", ignoreCase = true) == true)
        }
    }

    @Test
    fun test_C4_falsifiability_conflicting_audit_states_rejected() {
        val conflictingAudits = listOf(
            AuditSession("maswe-0001", AuditVerdict.PASS, isCompleted = true),
            AuditSession("maswe-0001", AuditVerdict.FAIL, isCompleted = true)
        )
        try {
            AuditSessionAggregator.calculateStatus(conflictingAudits)
            fail("Aynı MASWE için çelişkili oturumlar IllegalStateException fırlatmalıydı")
        } catch (e: IllegalStateException) {
            assertTrue(
                e.message?.contains("conflict", ignoreCase = true) == true ||
                e.message?.contains("duplicate", ignoreCase = true) == true
            )
        }
    }

    @Test
    fun test_C4_telemetry_recorded_without_blocking_ui_thread() {
        val session = AuditSession("maswe-0001", AuditVerdict.PASS, isCompleted = true, durationMs = 1200L)
        val recorded = AuditSessionAggregator.recordTelemetry(session)
        assertTrue("Telemetri başarıyla kaydedilmeli", recorded)
    }
}
