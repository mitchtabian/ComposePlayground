package com.codingwithmitch.composeplayground.ui.util

sealed class FormValidation{

    data class Invalid(
        val message: String
    ): FormValidation()

    class Valid: FormValidation()
}
