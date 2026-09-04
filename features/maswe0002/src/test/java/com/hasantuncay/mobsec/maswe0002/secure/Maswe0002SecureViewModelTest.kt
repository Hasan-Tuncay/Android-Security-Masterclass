package com.hasantuncay.mobsec.maswe0002.secure

import app.cash.turbine.test
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
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
class Maswe0002SecureViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mockk<Maswe0002SecureRepository>()
    private val masterclassDataRepository = mockk<MasterclassDataRepository>()
    private val testDataFlow = MutableStateFlow(MasterclassData())

    private lateinit var viewModel: Maswe0002SecureViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { masterclassDataRepository.masterclassData } returns testDataFlow
        viewModel = Maswe0002SecureViewModel(repository, masterclassDataRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Idle`() = runTest {
        assertEquals(Maswe0002SecureState(), viewModel.uiState.value)
    }

    @Test
    fun `execute mitigation updates state to Loading then Success`() = runTest {
        val mitigation = Maswe0002Mitigation.EXTERNAL_STORAGE
        val expectedPath = "/data/user/0/com.hasantuncay.mobsec/files/maswe0002_internal.json"

        coEvery { repository.executeMitigation(mitigation, any()) } returns expectedPath

        viewModel.uiState.test {
            val initial = awaitItem()
            assertEquals(UiState.Idle, initial.executionState)

            viewModel.processIntent(Maswe0002SecureIntent.ExecuteMitigation(mitigation))
            testDispatcher.scheduler.advanceUntilIdle()

            val loading = awaitItem()
            assertEquals(mitigation, loading.selectedMitigation)
            assertEquals(UiState.Loading, loading.executionState)

            val success = awaitItem()
            assertEquals(mitigation, success.selectedMitigation)
            assertTrue(success.executionState is UiState.Success)
            assertEquals(expectedPath, (success.executionState as UiState.Success).data)
        }
    }

    @Test
    fun `execute mitigation failure updates state to Error and emits effect`() = runTest {
        val mitigation = Maswe0002Mitigation.EXTERNAL_STORAGE
        val errorMessage = "Keystore encryption failed"

        coEvery { repository.executeMitigation(mitigation, any()) } throws RuntimeException(errorMessage)

        viewModel.effect.test {
            viewModel.processIntent(Maswe0002SecureIntent.ExecuteMitigation(mitigation))
            testDispatcher.scheduler.advanceUntilIdle()

            val effect = awaitItem()
            assertTrue(effect is Maswe0002SecureEffect.ExecutionFailed)
            assertEquals(errorMessage, (effect as Maswe0002SecureEffect.ExecutionFailed).error.message)
        }

        assertTrue(viewModel.uiState.value.executionState is UiState.Error)
        assertEquals(errorMessage, (viewModel.uiState.value.executionState as UiState.Error).message)
    }

    @Test
    fun `reset intent clears selected mitigation and sets state to Idle`() = runTest {
        val mitigation = Maswe0002Mitigation.EXTERNAL_STORAGE
        coEvery { repository.executeMitigation(mitigation, any()) } returns "/path"

        viewModel.processIntent(Maswe0002SecureIntent.ExecuteMitigation(mitigation))
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.processIntent(Maswe0002SecureIntent.Reset)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(null, viewModel.uiState.value.selectedMitigation)
        assertEquals(UiState.Idle, viewModel.uiState.value.executionState)
    }
}
