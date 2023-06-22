package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.domain.Type1Model
import com.example.myapplication.ui.fetch.FetchScreen
import com.example.myapplication.ui.serverdriven.ServerDrivenScreen
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
                onClick = { message ->
                    navController.navigate("${NavigationRoute.SERVER_DRIVEN_UI}/$message")
                },
                onClickServerDriven = { serverDrivenModel ->
                    when (serverDrivenModel) {
                        is Type1Model -> {
                            navController.navigate("${NavigationRoute.SERVER_DRIVEN_UI}/${serverDrivenModel.content?.title}")
                        }

                        else -> {
                            TODO("Lazy af")
                        }
                    }
                }
            )
        }
        composable(
            route = "${NavigationRoute.SERVER_DRIVEN_UI}/{${NavigationArgument.MESSAGE}}",
            arguments = listOf(
                navArgument(NavigationArgument.MESSAGE) {
                    type = NavType.StringType
                }
            ),
        ) {
            ServerDrivenScreen()
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
