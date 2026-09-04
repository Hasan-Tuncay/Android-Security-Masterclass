package com.hasantuncay.mobsec.common.architecture

import androidx.annotation.StringRes
import com.hasantuncay.mobsec.common.R

sealed class AppError(
    open val message: String? = null,
    @StringRes open val messageRes: Int? = null,
    open val cause: Throwable? = null
) {
    data class SecurityError(
        override val message: String,
        override val cause: Throwable? = null
    ) : AppError(message = message, cause = cause)

    data class StorageError(
        override val message: String,
        override val cause: Throwable? = null
    ) : AppError(message = message, cause = cause)

    data class CryptoError(
        override val message: String,
        override val cause: Throwable? = null
    ) : AppError(message = message, cause = cause)

    data class ExecutionError(
        override val message: String,
        override val cause: Throwable? = null
    ) : AppError(message = message, cause = cause)

    data class UnknownError(
        override val message: String? = null,
        override val cause: Throwable? = null
    ) : AppError(message = message, messageRes = R.string.format_error, cause = cause)
}
