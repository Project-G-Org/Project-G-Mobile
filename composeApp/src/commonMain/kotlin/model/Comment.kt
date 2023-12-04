package model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int,
    val author: Author,
    val authorId: String,
    val content: String,
    val createdAt: String,
    val isEdited: Boolean,
    val likes: List<Like?>,
    val parentCommentId: Int?,
    val postId: String?,
    val projectId: Int?,
    val replies: List<Reply>
)