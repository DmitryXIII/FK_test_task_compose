package ru.avacodo.fktesttaskcompose.ui.screens.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

sealed class Screens {
    abstract fun name(): String

    object Navigation : Screens() {
        override fun name() = "Navigation_screen"
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetupNavHost(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.Navigation.name()
    ) {
        routeToDestination(Screens.Navigation.name()) {
            NavigationScreen()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.routeToDestination(
    destination: String,
    content: @Composable (AnimatedVisibilityScope.(NavBackStackEntry) -> Unit)
) {
    this.composable(
        route = destination,
        enterTransition = TransitionAnimator.enterTransition,
        exitTransition = TransitionAnimator.exitTransition,
        popEnterTransition = TransitionAnimator.popEnterTransition,
        popExitTransition = TransitionAnimator.popExitTransition
    ) {
        content.invoke(this@composable, it)
    }
}

private class TransitionAnimator {
    companion object {
        private const val TRANSITION_DURATION = 400

        val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?) =
            {
                fadeIn(animationSpec = tween(TRANSITION_DURATION))
            }

        val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?) =
            {
                fadeOut(animationSpec = tween(TRANSITION_DURATION))
            }

        val popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?) =
            {
                fadeIn(animationSpec = tween(TRANSITION_DURATION))
            }

        val popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?) =
            {
               fadeOut(animationSpec = tween(TRANSITION_DURATION))
            }
    }
}