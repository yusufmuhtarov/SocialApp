package com.example.data.repository.repository

import com.example.data.repository.mappers.toDomain
import com.example.data.repository.models.UserResponseModels
import com.example.data.repository.service.UserService
import com.example.domain.model.UserAnswerDomainModel
import com.example.domain.model.UserLoginDomainModel
import com.example.domain.model.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.result.status.BasedDataSource
import com.example.domain.result.status.ResultStatus
import javax.inject.Inject

class UserAuthRepositoryImpl @Inject constructor(
    private val userService: UserService,
) : UserAuthRepository, BasedDataSource() {
    override suspend fun register(userSignModel: UserSignDomainModel): ResultStatus<UserAnswerDomainModel> {
        val response = invokeResponseRequest {
            userService.registerNewUser(
                UserResponseModels(
                    userEmail = userSignModel.userEmail,
                    password = userSignModel.userPassword,
                    firstName = userSignModel.userFirstName,
                    lastName = userSignModel.userLastName,
                )
            )
        }
        return ResultStatus(
            data = response.data?.toDomain(),
            errorThrowable = response.errorThrowable,
            status = response.status
        )
    }

    override suspend fun login(userLoginModel: UserLoginDomainModel) {
        TODO("Not yet implemented")
    }
}