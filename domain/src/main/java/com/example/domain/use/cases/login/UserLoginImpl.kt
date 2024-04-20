package com.example.domain.use.cases.login

import com.example.domain.isValidEmail
import com.example.domain.model.UserLoginDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffect.SideEffect
import com.example.domain.validatePassword

class UserLoginImpl(
    private val repository: UserAuthRepository,
    private val sideEffect: SideEffect,
) : UserLoginUseCase {
    override suspend fun invoke(userLoginModel: UserLoginDomainModel) {
        if (!userLoginModel.email.isValidEmail()) {
            sideEffect.makeToast("Invalid user email")
            return
        }
        if (!userLoginModel.password.validatePassword()) {
            sideEffect.makeToast("Invalid user password")
            return
        }
        repository.login(userLoginModel)
    }
}