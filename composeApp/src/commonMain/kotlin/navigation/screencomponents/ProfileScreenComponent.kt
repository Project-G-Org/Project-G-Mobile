package navigation.screencomponents

import com.arkivanov.decompose.ComponentContext

class ProfileScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoToFeed: () -> Unit,
    private val onGoToLogin: () -> Unit,
    private val onGoToCadastro: () -> Unit
): ComponentContext by componentContext {
    fun goToFeed() {
        onGoToFeed()
    }

    fun goToLogin() {
        onGoToLogin()
    }

    fun goToCadastro() {
        onGoToCadastro()
    }


}