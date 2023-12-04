package model

import kotlinx.serialization.Serializable

@Serializable
data class Pins(
    val id: Int,
    val userId: String
)