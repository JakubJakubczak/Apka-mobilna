package com.example.myapplication.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.ui.AppBottomNavBar
import com.example.myapplication.ui.AppTopBar
import com.example.myapplication.ui.Routes

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainer(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),      // for later use
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Scaffold(
        topBar = {
            AppTopBar(drawerState = drawerState, onClickMenu = {},   navController = navController )
        },
        bottomBar = {
            AppBottomNavBar(navController)
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Routes.Home.route
        ) {
            composable(route = Routes.Home.route) {
                HomeScreen()
            }
            composable(Routes.Books.route) {
                GenresScreen(navController)
            }

            composable("about_app") {
                AboutAppScreen()
            }

            composable(Routes.Favourites.route) {
                FavouriteScreen()
            }

            composable(
                route = "books/{genreId}",
                arguments = listOf(navArgument("genreId") { type = NavType.IntType })
            ) { backStackEntry ->
                val genreId = backStackEntry.arguments?.getInt("genreId") ?: 0
                BooksScreen(genreId)
            }
        }
    }
}
