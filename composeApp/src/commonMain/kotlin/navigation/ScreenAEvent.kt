package navigation

sealed interface ScreenAEvent {
    data object ClickButtonA: ScreenAEvent
    data class updateText(val text: String) : ScreenAEvent
}