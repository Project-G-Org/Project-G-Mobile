package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import navigation.screencomponents.CadastroScreenComponent
import navigation.screencomponents.FeedScreenComponent
import navigation.screencomponents.LoginScreenComponent
import navigation.screencomponents.ProfileScreenComponent
import navigation.screencomponents.ProjectScreenComponent
import navigation.screencomponents.RecoverScreenComponent
import presentation.screens.FeedScreen

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.LoginScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ) : Child {
        return when(config) {
            Configuration.ScreenA -> Child.ScreenA(
                ScreenAComponent(
                    componentContext = context,
                    onNavigateToScreenB = { text ->
                        navigation.pushNew(Configuration.ScreenB(text))
                    }
                )
            )
            is Configuration.ScreenB -> Child.ScreenB(
                ScreenBComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )

            Configuration.LoginScreen -> Child.LoginScreen(
                LoginScreenComponent(
                    componentContext = context,
                    onNavigateToCadastroScreen = {
                        navigation.pushNew(Configuration.CadastroScreen)
                    },
                    onMakeLogin = {
                        navigation.pushNew(Configuration.FeedScreen)
                    }
                )
            )

            Configuration.CadastroScreen -> Child.CadastroScreen(
                CadastroScreenComponent(
                    componentContext = context,
                    goBackLogin = {
                        navigation.pop()
                    }
                )
            )

            Configuration.FeedScreen -> Child.FeedScreen(
                FeedScreenComponent(
                    componentContext = context,
                    goToProfileScreen = {
                        navigation.pushNew(Configuration.ProfileScreen)
                    },
                    goToProjectScreen = {
                        navigation.pushNew(Configuration.ProjectScreen)
                    }
                )
            )

            Configuration.RecoverScreen -> Child.RecoverScreen(
                RecoverScreenComponent(
                    componentContext = context
                )
            )

            Configuration.ProfileScreen -> Child.ProfileScreen(
                ProfileScreenComponent(
                    componentContext = context,
                    onGoToCadastro = {
                        Configuration.CadastroScreen
//                        navigation.push(Configuration.CadastroScreen)
                    },
                    onGoToFeed = {
                       //navigation.push(Configuration.FeedScreen)
                        //navigation.bringToFront(Configuration.FeedScreen)
                    },
                    onGoToLogin = {
                        Configuration.LoginScreen
//                        navigation.push(Configuration.LoginScreen)
                    }
                )
            )

            Configuration.ProjectScreen -> Child.ProjectScreen(
                ProjectScreenComponent(
                    componentContext = context,
                    goToProjectScreen = {
                        Configuration.ProjectScreen
                    },
                    goToProfileScreen = {
                        Configuration.ProfileScreen
                    },
                    goToFeedScreen = {
                        navigation.bringToFront(Configuration.FeedScreen)
                    }
                )
            )
        }
    }

    sealed class Child {
        data class ScreenA(val component: ScreenAComponent) : Child()
        data class ScreenB(val component: ScreenBComponent) : Child()
        data class LoginScreen(val component: LoginScreenComponent) : Child()
        data class CadastroScreen(val component: CadastroScreenComponent) : Child()
        data class FeedScreen(val component: FeedScreenComponent) : Child()
        data class RecoverScreen(val component: RecoverScreenComponent) : Child()
        data class ProfileScreen(val component: ProfileScreenComponent) : Child()
        data class ProjectScreen(val component: ProjectScreenComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object ScreenA: Configuration()

        @Serializable
        data class ScreenB(val text: String) : Configuration()

        @Serializable
        data object LoginScreen: Configuration()

        @Serializable
        data object CadastroScreen: Configuration()

        @Serializable
        data object RecoverScreen: Configuration()

        @Serializable
        data object FeedScreen: Configuration()

        @Serializable
        data object ProfileScreen: Configuration()

        @Serializable
        data object ProjectScreen: Configuration()

    }
}