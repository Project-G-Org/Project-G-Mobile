package navigation.screencomponents

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class LoginScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToCadastroScreen: () -> Unit,
    private val onMakeLogin: () -> Unit
): ComponentContext by componentContext {

    private var _showAnimation = MutableValue(false)
    val showAnimation: Value<Boolean> = _showAnimation

    fun updateShowAnimation(value: Boolean) {
        _showAnimation.value = value
    }

    fun goToCadastroScreen() {
        onNavigateToCadastroScreen()
    }

    fun goToFeed() {
        onMakeLogin()
    }
}