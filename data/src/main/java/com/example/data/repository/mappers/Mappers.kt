package com.example.data.repository.mappers

import com.example.data.repository.models.UserAnswerResponseModel
import com.example.domain.model.UserAnswerDomainModel

fun UserAnswerResponseModel.toDomain() = UserAnswerDomainModel(
    objectId = objectId,
    userAvatar = userAvatar
)