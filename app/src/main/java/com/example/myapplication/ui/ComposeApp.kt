package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.fetch.FetchScreen
import com.example.myapplication.ui.myscreen.MyScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.FETCH
    ) {
        composable(
            route = NavigationRoute.FETCH
        ) {
            FetchScreen(
                onClick = { identifier ->
                    navController.navigate("${NavigationRoute.MY_SCREEN_UI}/${identifier}")
                }
            )
        }
        composable(
            route = "${NavigationRoute.MY_SCREEN_UI}/{${NavigationArgument.ID}}",
            arguments = listOf(
                navArgument(NavigationArgument.ID) {
                    type = NavType.LongType
                }
            )
        ) {
            MyScreen()
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
