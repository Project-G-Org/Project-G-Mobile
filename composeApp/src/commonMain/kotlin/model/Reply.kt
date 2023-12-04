package model

import kotlinx.serialization.Serializable

@Serializable
data class Reply(
    val author: Author,
    val authorId: String,
    val content: String,
    val createdAt: String,
    val id: Int,
    val isEdited: Boolean,
    val likes: List<Like?>,
    val parentCommentId: String?,
    val postId: String?,
    val projectId: String?
)