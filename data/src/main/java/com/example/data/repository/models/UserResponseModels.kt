package com.example.data.repository.models

import com.google.gson.annotations.SerializedName

data class UserResponseModels(
    @SerializedName("username") val userEmail: String,
    @SerializedName("password") val password: String,
    @SerializedName("firstName") val firstName:String,
    @SerializedName("lastName") val lastName:String,
)
