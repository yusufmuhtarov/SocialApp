package com.example.data.repository.service

import com.example.data.repository.models.UserAnswerResponseModel
import com.example.data.repository.models.UserResponseModels
import com.example.domain.model.UserAnswerDomainModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("classes/_User")
    suspend fun registerNewUser(
        @Body userResponseModel: UserResponseModels
    ): Response<UserAnswerResponseModel>
}