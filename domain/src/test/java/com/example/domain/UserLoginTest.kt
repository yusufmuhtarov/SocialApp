package com.example.domain

import com.example.domain.use.cases.login.UserLoginImpl
import com.example.domain.use.cases.login.UserLoginUseCase
import com.example.domain.model.UserLoginDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffect.SideEffect
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserLoginTest {
    @MockK
    private lateinit var userSignRepository: UserAuthRepository

    @MockK
    private lateinit var showSideEffect: SideEffect

    private lateinit var userLoginUseCase: UserLoginUseCase


    private fun getUserLoginTestModel(): UserLoginDomainModel.Builder {
        return UserLoginDomainModel.Builder()
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userLoginUseCase = UserLoginImpl(
            userSignRepository,
            showSideEffect
        )
    }

    @Test
    fun `invoke should call make Toast with correct parameters when email isNot Valid`() {
        runBlocking {
            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userLoginTestModel = getUserLoginTestModel()
                .setEmail("i")
                .build()

            userLoginUseCase.invoke(userLoginTestModel)
            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user email")
            }
        }
    }

    @Test
    fun `invoke should make Toast with correct parameters when password isNot`() =
        runBlocking {
            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userSignTestModel = getUserLoginTestModel()
                .setPassword("us")
                .setEmail("usufmuhtarov@59gmail.com")
                .build()

            userLoginUseCase.invoke(userSignTestModel)
            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user password")
            }
        }
}