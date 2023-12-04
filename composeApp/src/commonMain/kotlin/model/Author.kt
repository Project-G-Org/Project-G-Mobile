package model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val image: String?,
    val name: String,
    val profilePic: String?
)