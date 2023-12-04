package model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val `data`: List<Posts>
)