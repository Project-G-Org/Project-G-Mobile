package model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Posts(
    val id: String,
    val author: Author,
    val authorId: String,
    val comments: List<Comment>,
    val content: String,
    val contributor: List<String?>,
    val createdAt: String,
    val images: List<String?>,
    val likes: List<Like?>,
    val pins: List<Pins>,
    val published: Boolean,
    val tags: List<String?>,
    val updatedAt: String
)