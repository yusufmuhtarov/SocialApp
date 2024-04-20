package com.example.domain.model

data class UserLoginDomainModel(
    val email: String,
    val password: String,
) {
    companion object {
        val NONE = UserLoginDomainModel(
            email = String(),
            password = String()
        )
    }

    constructor(builder: Builder) : this(
        email = builder.email,
        password = builder.password
    )

    class Builder {
        var email = String()
        var password = String()

        fun setEmail(email: String) = apply { this.email = email }

        fun setPassword(password: String) = apply { this.password = password }

        fun build(): UserLoginDomainModel = UserLoginDomainModel(this)
    }
}
