package com.hasantuncay.mobsec.maswe0005.vulnerable

import app.cash.turbine.test
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector
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
class Maswe0005VulnerableViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mockk<Maswe0005VulnerableRepository>()
    private val masterclassDataRepository = mockk<MasterclassDataRepository>()
    private val testDataFlow = MutableStateFlow(MasterclassData())

    private lateinit var viewModel: Maswe0005VulnerableViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { masterclassDataRepository.masterclassData } returns testDataFlow
        viewModel = Maswe0005VulnerableViewModel(repository, masterclassDataRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Idle`() = runTest {
        assertEquals(Maswe0005VulnerableState(), viewModel.uiState.value)
    }

    @Test
    fun `execute vector updates state to Loading then Success`() = runTest {
        val vector = Maswe0005Vector.SYSTEM_CONSOLE
        val expectedResult = "Data logged to Logcat"

        coEvery { repository.executeVector(vector, any()) } returns expectedResult

        viewModel.uiState.test {
            val initial = awaitItem()
            assertEquals(UiState.Idle, initial.executionState)

            viewModel.processIntent(Maswe0005VulnerableIntent.ExecuteVector(vector))
            testDispatcher.scheduler.advanceUntilIdle()

            val loading = awaitItem()
            assertEquals(vector, loading.selectedVector)
            assertEquals(UiState.Loading, loading.executionState)

            val success = awaitItem()
            assertEquals(vector, success.selectedVector)
            assertTrue(success.executionState is UiState.Success)
            assertEquals(expectedResult, (success.executionState as UiState.Success).data)
        }
    }

    @Test
    fun `execute vector failure updates state to Error and emits effect`() = runTest {
        val vector = Maswe0005Vector.NETWORK_INTERCEPTOR
        val errorMessage = "Network logging failed"

        coEvery { repository.executeVector(vector, any()) } throws RuntimeException(errorMessage)

        viewModel.effect.test {
            viewModel.processIntent(Maswe0005VulnerableIntent.ExecuteVector(vector))
            testDispatcher.scheduler.advanceUntilIdle()

            val effect = awaitItem()
            assertTrue(effect is Maswe0005VulnerableEffect.ExecutionFailed)
            assertEquals(errorMessage, (effect as Maswe0005VulnerableEffect.ExecutionFailed).error.message)
        }

        assertTrue(viewModel.uiState.value.executionState is UiState.Error)
        assertEquals(errorMessage, (viewModel.uiState.value.executionState as UiState.Error).message)
    }

    @Test
    fun `reset intent clears selected vector and sets state to Idle`() = runTest {
        val vector = Maswe0005Vector.LOCAL_FILE
        coEvery { repository.executeVector(vector, any()) } returns "/path"

        viewModel.processIntent(Maswe0005VulnerableIntent.ExecuteVector(vector))
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.processIntent(Maswe0005VulnerableIntent.Reset)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(null, viewModel.uiState.value.selectedVector)
        assertEquals(UiState.Idle, viewModel.uiState.value.executionState)
    }
}
