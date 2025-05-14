package com.example.myapplication.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector


enum class Routes(val route:String) {
    Home(route = "home_route"),
    List(route="list_route"),
    ImagePager(route="imagepager_route"),

    // Nowe ekrany planówa
    PlanAScreen(route = "plan_a_route"),
    PlanBScreen(route = "plan_b_route"),
    PlanCScreen(route = "plan_c_route")
}

sealed class NaviItem(var title:String, var icon: ImageVector, var route:String) {
    object Home : NaviItem("Home", Icons.Filled.Home, Routes.Home.route)
    object List: NaviItem("List",Icons.Filled.List, Routes.List.route)

    object PlanAScreen : NaviItem("Plan A", Icons.Filled.Warning, Routes.PlanAScreen.route)
    object PlanBScreen : NaviItem("Plan B", Icons.Filled.Warning, Routes.PlanBScreen.route)
    object PlanCScreen : NaviItem("Plan C", Icons.Filled.Warning, Routes.PlanCScreen.route)
}

val navBarItems = listOf(NaviItem.Home, NaviItem.List)
val planItems= listOf(NaviItem.PlanAScreen, NaviItem.PlanBScreen, NaviItem.PlanCScreen)     //for future use
