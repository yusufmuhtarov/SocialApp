package com.example.socialapp.presentation.ui.screens.register

import androidx.compose.runtime.Immutable

sealed interface RegisterScreenInteraction {

    @Immutable
    data class OnUserFirstNameChanged(
        val userFirstName: String,
        ): RegisterScreenInteraction

    @Immutable
    data class OnUserLastNameChanged(
        val userLastName: String,
        ): RegisterScreenInteraction

    @Immutable
    data class OnUserEmailCnaged(
        val userEmail: String,
        ): RegisterScreenInteraction

    @Immutable
    data class OnUserPasswordChanged(
        val userPassword: String,
        ): RegisterScreenInteraction


    data object OnNavigateUp: RegisterScreenInteraction

    data object OnRedisterButtonCLick: RegisterScreenInteraction
}