package model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUser(
    val name: String,
    val email: String,
    val password: String
)
