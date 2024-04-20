package com.example.domain.use.cases.login

import com.example.domain.model.UserAnswerDomainModel
import com.example.domain.model.UserSignDomainModel
import com.example.domain.result.status.ResultStatus

interface UserSignUseCase {
     suspend operator fun invoke(
          userSignDomainModel: UserSignDomainModel
     ): ResultStatus<UserAnswerDomainModel>
}