package com.codingwithmitch.composeplayground.ui.state

data class UiState<T>(
    val loading: Boolean = false,
    val exception: Exception? = null,
    val data: T? = null
) {
    /**
     * True if this contains an error
     */
    val hasError: Boolean
        get() = exception != null

    /**
     * True if this represents a first load
     */
    val initialLoad: Boolean
        get() = data == null && loading && !hasError

    companion object{
        fun<T> Success(data: T?): UiState<T> {
            return UiState(
                data=data,
                loading = false
            )
        }

        fun<T> Loading(): UiState<T> {
            return UiState(loading = true)
        }
    }
}