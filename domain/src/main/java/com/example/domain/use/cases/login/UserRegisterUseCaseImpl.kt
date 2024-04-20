package com.example.domain.use.cases.login

import com.example.domain.model.UserAnswerDomainModel
import com.example.domain.model.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.result.status.ResultStatus


class UserRegisterUseCaseImpl(
    private val repository: UserAuthRepository,
    ) : UserSignUseCase {
    override suspend fun invoke(userSignModel: UserSignDomainModel): ResultStatus<UserAnswerDomainModel> {
        return repository.register(userSignModel)
    }
}