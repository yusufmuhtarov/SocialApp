package com.example.domain

import com.example.domain.model.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffect.SideEffect
import com.example.domain.use.cases.login.UserRegisterUseCaseImpl
import com.example.domain.use.cases.login.UserSignUseCase
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserRegTest {

    @MockK
    private lateinit var userSignRepository: UserAuthRepository

    @MockK
    private lateinit var showSideEffect: SideEffect

    private lateinit var userSignUseCase: UserSignUseCase

    private fun getUserSignTestModel(): UserSignDomainModel.Builder {
        return UserSignDomainModel.Builder()
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userSignUseCase = UserRegisterUseCaseImpl(
            userSignRepository,
            showSideEffect
        )
    }

    @Test
    fun `invoke should call make Toast with correct parameters when UserFirstName isNot Valid`() {
        runBlocking {
            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userSignTestModel = getUserSignTestModel()
                .setFirstName("1")
                .build()

            userSignUseCase.invoke(userSignTestModel)
            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user firstName")
            }
        }
    }

    @Test
    fun `invoke should make Toast with correct parameters when UserLastname isNot`() {
        runBlocking {

            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userSignTestModel = getUserSignTestModel()
                .setLastName("1")
                .setFirstName("yusuf")
                .build()

            userSignUseCase.invoke(userSignTestModel)
            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user lastName")
            }
        }
    }
    @Test
    fun `invoke should make Toast with correct parameters when email isNot`() =
        runBlocking {
            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userSignTestModel = getUserSignTestModel()
                .setEmail("1")
                .setFirstName("yusuf")
                .setLastName("muhtarov")
                .build()

            userSignUseCase.invoke(userSignTestModel)

            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user email")
            }
        }

    @Test
    fun `invoke should make Toast with correct parameters when password isNot`() =
        runBlocking {
            every {
                showSideEffect.makeToast(any())
            } returns Unit

            val userSignTestModel = getUserSignTestModel()
                .setPassword("uq")
                .setFirstName("yusuf")
                .setEmail("usufmuhtarov59@gmail.com")
                .setLastName("muhtarov")
                .build()

            userSignUseCase.invoke(userSignTestModel)
            verify(exactly = 1) {
                showSideEffect.makeToast("Invalid user password")
            }
        }
    @After
    fun clearAllMocks(){
        unmockkAll()
    }
}
