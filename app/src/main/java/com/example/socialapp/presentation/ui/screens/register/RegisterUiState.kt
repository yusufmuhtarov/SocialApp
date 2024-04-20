package com.example.socialapp.presentation.ui.screens.register

import com.example.socialapp.presentation.ui.screens.utils.emptyString

data class RegisterUiState(
    val userFirstName:String = emptyString(),
    val userLastName:String = emptyString(),
    val userEmail: String = emptyString(),
    val userPassword: String = emptyString()
)
