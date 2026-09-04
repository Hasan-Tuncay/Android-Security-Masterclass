package com.hasantuncay.mobsec.maswe0006.secure

import app.cash.turbine.test
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class Maswe0006SecureViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mockk<Maswe0006SecureRepository>()
    private val masterclassDataRepository = mockk<MasterclassDataRepository>()
    private val testDataFlow = MutableStateFlow(MasterclassData())

    private lateinit var viewModel: Maswe0006SecureViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { masterclassDataRepository.masterclassData } returns testDataFlow
        viewModel = Maswe0006SecureViewModel(repository, masterclassDataRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Idle`() = runTest {
        assertEquals(Maswe0006SecureState(), viewModel.uiState.value)
    }

    @Test
    fun `execute vector updates state to Loading then Success`() = runTest {
        val vector = Maswe0006Mitigation.AUTOMATIC_SYSTEM_BACKUP
        val expectedResult = "BACKUP RULES ENFORCED: Sensitive prefs excluded via backup_rules.xml"

        coEvery { repository.executeMitigation(vector, any()) } returns expectedResult

        viewModel.uiState.test {
            val initial = awaitItem()
            assertEquals(UiState.Idle, initial.executionState)

            viewModel.processIntent(Maswe0006SecureIntent.ExecuteMitigation(vector))
            testDispatcher.scheduler.advanceUntilIdle()

            val loading = awaitItem()
            assertEquals(vector, loading.selectedMitigation)
            assertEquals(UiState.Loading, loading.executionState)

            val success = awaitItem()
            assertEquals(vector, success.selectedMitigation)
            assertTrue(success.executionState is UiState.Success)
            assertEquals(expectedResult, (success.executionState as UiState.Success).data)
        }
    }

    @Test
    fun `execute vector failure updates state to Error and emits effect`() = runTest {
        val vector = Maswe0006Mitigation.LOCAL_BACKUP
        val errorMessage = "Failed to enforce allowBackup mitigation"

        coEvery { repository.executeMitigation(vector, any()) } throws RuntimeException(errorMessage)

        viewModel.effect.test {
            viewModel.processIntent(Maswe0006SecureIntent.ExecuteMitigation(vector))
            testDispatcher.scheduler.advanceUntilIdle()

            val effect = awaitItem()
            assertTrue(effect is Maswe0006SecureEffect.ExecutionFailed)
            assertEquals(errorMessage, (effect as Maswe0006SecureEffect.ExecutionFailed).error.message)
        }

        assertTrue(viewModel.uiState.value.executionState is UiState.Error)
        assertEquals(errorMessage, (viewModel.uiState.value.executionState as UiState.Error).message)
    }

    @Test
    fun `reset intent clears selected mitigation and sets state to Idle`() = runTest {
        val vector = Maswe0006Mitigation.UNENCRYPTED_BACKUP_DATA
        coEvery { repository.executeMitigation(vector, any()) } returns "result"

        viewModel.processIntent(Maswe0006SecureIntent.ExecuteMitigation(vector))
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.processIntent(Maswe0006SecureIntent.Reset)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(null, viewModel.uiState.value.selectedMitigation)
        assertEquals(UiState.Idle, viewModel.uiState.value.executionState)
    }
}
