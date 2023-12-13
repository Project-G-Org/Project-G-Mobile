import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import navigation.screencomponents.ProjectScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import presentation.screens.cadastro.CadastroScreen
import presentation.screens.FeedScreen
import presentation.screens.LoginScreen
import presentation.screens.ProfileScreen
import presentation.screens.ProjectScreen
import presentation.screens.RecoverScreen
import presentation.screens.ScreenA
import presentation.screens.ScreenB

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(root: RootComponent) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.LoginScreen -> LoginScreen(component = instance.component)
                is RootComponent.Child.ScreenA -> ScreenA(component = instance.component)
                is RootComponent.Child.ScreenB -> ScreenB(text = instance.component.text, component = instance.component)
                is RootComponent.Child.CadastroScreen -> CadastroScreen(component = instance.component)
                is RootComponent.Child.FeedScreen -> FeedScreen(component = instance.component)
                is RootComponent.Child.RecoverScreen -> RecoverScreen(component = instance.component)
                is RootComponent.Child.ProfileScreen -> ProfileScreen(component = instance.component)
                is RootComponent.Child.ProjectScreen -> ProjectScreen(component = instance.component)
            }
        }
    }
}


