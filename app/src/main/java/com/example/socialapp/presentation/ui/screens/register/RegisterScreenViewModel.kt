package com.example.socialapp.presentation.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use.cases.login.UserSignUseCase
import com.example.domain.model.UserSignDomainModel
import com.example.domain.result.status.ResponseStatus
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenInteraction.OnNavigateUp
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenInteraction.OnUserEmailCnaged
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenInteraction.OnUserFirstNameChanged
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenInteraction.OnUserLastNameChanged
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenInteraction.OnUserPasswordChanged
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val userSignUseCase: UserSignUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    private val _navigateUpFlow: MutableStateFlow<Unit> = MutableStateFlow(Unit)
    val navigateupFlow: StateFlow<Unit> = _navigateUpFlow.asStateFlow()
    fun onInteraction(interaction: RegisterScreenInteraction) {
        when (interaction) {
            is OnNavigateUp -> _navigateUpFlow.tryEmit(Unit)
            is OnUserEmailCnaged -> onUpdateEmail(interaction)
            is OnUserFirstNameChanged -> onUpdateUser(interaction)
            is OnUserLastNameChanged -> onUpdateLastName(interaction)
            is OnUserPasswordChanged -> onUpdatePassword(interaction)
            is RegisterScreenInteraction.OnRedisterButtonCLick -> doClickOnRegisterButton()
        }
    }

    private fun doClickOnRegisterButton(): Unit = with(uiState.value) {
        if (!validateUserInfoTexts(listOf(userFirstName, userLastName, userEmail, userPassword))) {
            return
        }
        viewModelScope.launch {
            val request = userSignUseCase(
                UserSignDomainModel(
                    userEmail = userEmail,
                    userFirstName = userFirstName,
                    userPassword = userPassword,
                    userLastName = userLastName,
                )
            )
            if (request.status == ResponseStatus.SUCCES){

            }
        }
    }


    private fun validateUserInfoTexts(list: List<String>): Boolean {
        var isValidate = false
        list.forEach {
            if (it.isNotEmpty()) {
                isValidate = true
            }
        }
        return isValidate
    }

    private fun onUpdateUser(interaction: OnUserFirstNameChanged) {
        _uiState.update { newState ->
            newState.copy(userFirstName = interaction.userFirstName)
        }
    }

    private fun onUpdateLastName(interaction: OnUserLastNameChanged) {
        _uiState.update { newState ->
            newState.copy(userLastName = interaction.userLastName)
        }
    }

    private fun onUpdateEmail(interaction: OnUserEmailCnaged) {
        _uiState.update { newState ->
            newState.copy(userEmail = interaction.userEmail)
        }
    }

    private fun onUpdatePassword(interaction: OnUserPasswordChanged) {
        _uiState.update { newState ->
            newState.copy(userPassword = interaction.userPassword)
        }
    }
}