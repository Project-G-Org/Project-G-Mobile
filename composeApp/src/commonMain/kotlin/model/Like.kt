package model

import kotlinx.serialization.Serializable

@Serializable
data class Like(
    val id: Int,
    val userId: String
)