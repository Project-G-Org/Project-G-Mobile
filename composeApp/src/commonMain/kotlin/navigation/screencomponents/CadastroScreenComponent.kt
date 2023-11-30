package navigation.screencomponents

import com.arkivanov.decompose.ComponentContext

class CadastroScreenComponent(
    componentContext: ComponentContext,
    private val goBackLogin: () -> Unit
): ComponentContext by componentContext {
    fun goBack() {
        goBackLogin()
    }
}