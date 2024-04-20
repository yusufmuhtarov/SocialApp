package com.example.socialapp.presentation.rule

import kotlinx.coroutines.flow.Flow

interface ValidateUserInfosRule {
    fun isUserInfosValidate(): Flow<Boolean>
}