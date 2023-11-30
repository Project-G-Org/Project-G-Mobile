import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.screens.CadastroScreen
import presentation.screens.FeedScreen
import presentation.screens.LoginScreen
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
            }
        }
    }
}