package com.example.myapplication.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector


enum class Routes(val route:String) {
    Home(route = "home_route"),
    Books(route="list_route"),
    Favourites(route="favourites"),
}

sealed class NaviItem(var title:String, var icon: ImageVector, var route:String) {
    object Home : NaviItem("Home", Icons.Filled.Home, Routes.Home.route)
    object Books: NaviItem("List",Icons.Filled.List, Routes.Books.route)
    object Favourites : NaviItem("Favourites", Icons.Filled.Star, Routes.Favourites.route)
}

val navBarItems = listOf(NaviItem.Home, NaviItem.Books,  NaviItem.Favourites)

