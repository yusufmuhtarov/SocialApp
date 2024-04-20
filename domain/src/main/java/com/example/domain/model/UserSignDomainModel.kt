package com.example.domain.model

data class UserSignDomainModel(
    val userName: String = String(),
    val userPassword: String,
    val userEmail: String,
    val userFirstName: String,
    val userLastName: String,
    val userBio: String  = String(),
    val userAvatar: String = String(),
    val userLocation: String = String(),
) {
    companion object {
        val NONE = UserSignDomainModel(
            userAvatar = String(),
            userBio = String(),
            userEmail = String(),
            userFirstName = String(),
            userLastName = String(),
            userLocation = String(),
            userName = String(),
            userPassword = String()
        )
    }

    constructor(builder: Builder) : this(
        userName = String(),
        userPassword = builder.password,
        userEmail = builder.email,
        userFirstName = builder.userFirstName,
        userLastName = builder.userLastName,
        userBio = String(),
        userAvatar = String(),
        userLocation = String(),
    )

    class Builder {
        var userFirstName = String()
        var userLastName = String()
        var email = String()
        var password = String()

        fun setFirstName(userFirstName: String) = apply { this.userFirstName = userFirstName }

        fun setLastName(userLastName: String) = apply { this.userLastName = userLastName }

        fun setEmail(email: String) = apply { this.email = email }

        fun setPassword(password: String) = apply { this.password = password }

        fun build(): UserSignDomainModel = UserSignDomainModel(this)
    }
}
