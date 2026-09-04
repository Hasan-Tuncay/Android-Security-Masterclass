package com.hasantuncay.mobsec.maswe0004.vulnerable

import app.cash.turbine.test
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector
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
class Maswe0004VulnerableViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mockk<Maswe0004VulnerableRepository>()
    private val masterclassDataRepository = mockk<MasterclassDataRepository>()
    private val testDataFlow = MutableStateFlow(MasterclassData())

    private lateinit var viewModel: Maswe0004VulnerableViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { masterclassDataRepository.masterclassData } returns testDataFlow
        viewModel = Maswe0004VulnerableViewModel(repository, masterclassDataRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Idle`() = runTest {
        assertEquals(Maswe0004VulnerableState(), viewModel.uiState.value)
    }

    @Test
    fun `execute vector exposes hardcoded secret message`() = runTest {
        val vector = Maswe0004Vector.SOURCE_CODE
        val expectedMessage = "EXPOSED IN DEX: mock_secret_payment_key_sample_insecure_12345"

        coEvery { repository.executeVector(vector, any()) } returns expectedMessage

        viewModel.uiState.test {
            assertEquals(UiState.Idle, awaitItem().executionState)

            viewModel.executeVector(vector)
            testDispatcher.scheduler.advanceUntilIdle()

            val loading = awaitItem()
            assertEquals(vector, loading.selectedVector)
            assertTrue(loading.executionState is UiState.Loading)

            val success = awaitItem()
            assertTrue(success.executionState is UiState.Success)
            assertEquals(expectedMessage, (success.executionState as UiState.Success).data)
        }
    }
}
