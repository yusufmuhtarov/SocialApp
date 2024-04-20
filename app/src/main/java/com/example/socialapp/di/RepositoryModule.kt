package com.example.socialapp.di

import com.example.data.repository.repository.UserAuthRepositoryImpl
import com.example.domain.repository.UserAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindUserAuthRepository(
        impl: UserAuthRepositoryImpl
    ) : UserAuthRepository
}