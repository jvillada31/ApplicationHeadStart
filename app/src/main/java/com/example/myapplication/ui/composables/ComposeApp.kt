package com.example.myapplication.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.FETCH
    ) {
        composable(NavigationRoute.FETCH) { backStackEntry ->
            FetchScreen(
                onUserClick = { username ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate("${NavigationRoute.SERVER_DRIVEN_UI}/$username")
                    }
                }
            )
        }
        composable(
            route = "${NavigationRoute.SERVER_DRIVEN_UI}/{${NavigationArgument.ID}}",
            arguments = listOf(
                navArgument(NavigationArgument.ID) {
                    type = NavType.StringType
                }
            ),
        ) {
            ServerDrivenUiScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeAppPreview() {
    MyApplicationTheme {
        ComposeApp()
    }
}
