package com.hasantuncay.mobsec.maswe0004.secure

import app.cash.turbine.test
import com.hasantuncay.mobsec.common.data.MasterclassDataRepository
import com.hasantuncay.mobsec.common.models.UiState
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation
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
class Maswe0004SecureViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mockk<Maswe0004SecureRepository>()
    private val masterclassDataRepository = mockk<MasterclassDataRepository>()
    private val testDataFlow = MutableStateFlow(MasterclassData())

    private lateinit var viewModel: Maswe0004SecureViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { masterclassDataRepository.masterclassData } returns testDataFlow
        viewModel = Maswe0004SecureViewModel(repository, masterclassDataRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Idle`() = runTest {
        assertEquals(Maswe0004SecureState(), viewModel.uiState.value)
    }

    @Test
    fun `execute mitigation confirms BFF ephemeral token protection`() = runTest {
        val mitigation = Maswe0004Mitigation.SOURCE_CODE
        val expectedMessage = "BFF PROXY ACTIVE: Zero secrets on device. Dynamic token minted: jwt_ephemeral"

        coEvery { repository.executeMitigation(mitigation, any()) } returns expectedMessage

        viewModel.uiState.test {
            assertEquals(UiState.Idle, awaitItem().executionState)

            viewModel.executeMitigation(mitigation)
            testDispatcher.scheduler.advanceUntilIdle()

            val loading = awaitItem()
            assertEquals(mitigation, loading.selectedMitigation)
            assertTrue(loading.executionState is UiState.Loading)

            val success = awaitItem()
            assertTrue(success.executionState is UiState.Success)
            assertEquals(expectedMessage, (success.executionState as UiState.Success).data)
        }
    }
}
