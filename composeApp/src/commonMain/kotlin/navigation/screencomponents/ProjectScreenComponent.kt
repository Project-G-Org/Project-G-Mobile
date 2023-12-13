package navigation.screencomponents

import com.arkivanov.decompose.ComponentContext

class ProjectScreenComponent(
    componentContext: ComponentContext,
    val goToProfileScreen: () -> Unit,
    val goToProjectScreen: () -> Unit,
    val goToFeedScreen: () -> Unit
): ComponentContext by componentContext {
    fun onGoToProfileScreen() {
        goToProfileScreen()
    }
    fun onGoToProjectScreen() {
        goToProjectScreen()
    }

    fun onGoToFeedScreen() {
        goToFeedScreen()
    }
}