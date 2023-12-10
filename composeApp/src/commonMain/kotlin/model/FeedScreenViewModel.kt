package model

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import helpers.URLS
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.mybirdapp.BuildKonfig.API_KEY
import org.example.mybirdapp.BuildKonfig.NAME_KEY

data class FeedUiState(
    val posts: List<Posts> = emptyList()
)

class FeedScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState = _uiState.asStateFlow()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    init {
        updatePosts()
    }

    fun updatePosts() {
        viewModelScope.launch {
            val posts = getPosts()
            _uiState.update {
                it.copy(posts = posts)
            }
        }
    }

    private suspend fun getPosts() : List<Posts> {
        val url = "${URLS.BASE_URL}services/posts"
        val posts = httpClient.get(url) {
            header(
                NAME_KEY,
                API_KEY
            )
        }
            .body<Data>()
        return posts.data
    }

    override fun onCleared() {
        httpClient.close()
    }
}