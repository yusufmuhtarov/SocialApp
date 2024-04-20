package com.example.domain.repository

import com.example.domain.model.UserAnswerDomainModel
import com.example.domain.model.UserLoginDomainModel
import com.example.domain.model.UserSignDomainModel
import com.example.domain.result.status.ResultStatus

interface UserAuthRepository {
    suspend fun register(userSignModel: UserSignDomainModel): ResultStatus<UserAnswerDomainModel>

    suspend fun login(userLoginModel: UserLoginDomainModel)
}