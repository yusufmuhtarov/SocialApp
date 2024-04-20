package com.example.socialapp.di

import com.example.domain.use.cases.login.UserRegisterUseCaseImpl
import com.example.domain.use.cases.login.UserSignUseCase
import com.example.domain.repository.UserAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun providesUserRegisterUseCase(
        authRepository: UserAuthRepository,
    ): UserSignUseCase = UserRegisterUseCaseImpl(authRepository)
}