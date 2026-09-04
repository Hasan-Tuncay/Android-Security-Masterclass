package com.hasantuncay.mobsec.common.architecture

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlin.coroutines.cancellation.CancellationException

interface UiStateMarker

interface UiIntentMarker

interface UiEffectMarker

abstract class MviViewModel<State : UiStateMarker, Intent : UiIntentMarker, Effect : UiEffectMarker>(
    initialState: State
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    private val _effect = Channel<Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    protected val currentState: State
        get() = _uiState.value

    protected fun updateState(reducer: (State) -> State) {
        _uiState.update(reducer)
    }

    protected suspend fun sendEffect(builder: () -> Effect) {
        _effect.send(builder())
    }

    abstract fun processIntent(intent: Intent)

    protected inline fun <T> runSafeCatching(block: () -> T): Result<T> {
        return try {
            Result.success(block())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}
