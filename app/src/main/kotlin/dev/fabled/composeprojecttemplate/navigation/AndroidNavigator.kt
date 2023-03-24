package dev.fabled.composeprojecttemplate.navigation

import androidx.navigation.NavOptionsBuilder
import dev.fabled.navigation.navigation_core.Navigator
import dev.fabled.navigation.navigation_core.NavigatorEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class AndroidNavigator : Navigator {

    private val navigationEvent = Channel<NavigatorEvent>()
    override val destinations = navigationEvent.receiveAsFlow()

    override fun navigateUp(): Boolean =
        navigationEvent.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvent.trySend(NavigatorEvent.Direction(route, builder)).isSuccess
}