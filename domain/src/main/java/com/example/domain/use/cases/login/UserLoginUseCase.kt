package com.example.domain.use.cases.login

import com.example.domain.model.UserLoginDomainModel

interface UserLoginUseCase {
    suspend operator fun invoke(userLoginModel: UserLoginDomainModel)
}