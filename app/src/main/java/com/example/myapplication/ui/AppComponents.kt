package com.example.myapplication.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.myapplication.ui.navBarItems
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    drawerState: DrawerState,
    onClickMenu: () -> Unit,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text("Bookead", color = Color.White)
        },
        navigationIcon = @androidx.compose.runtime.Composable {
            IconButton(onClick = { /* opcjonalne */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.logo1), // <- Twoje logo
                    contentDescription = "Logo",
                    tint = Color.Unspecified // <- zachowaj oryginalne kolory logotypu
                )
            }
        },
        colors = topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
        ),
        actions = {
            Box {
                IconButton(onClick = {
                    expanded = true
                }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Options Menu",
                        tint = Color.White
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    DropdownMenuItem(
                        text = { Text("About app") },
                        onClick = {
                            expanded = false
                            navController.navigate("about_app")
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun AppDrawerContent(navController: NavController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.padding(16.dp)) {
        navBarItems.forEach { item ->
            TextButton(
                onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = item.title, color = Color.Black)
            }
        }
    }
}

@Composable
fun AppBottomNavBar(
    navController : NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White,
        modifier = modifier
    ) {
        navBarItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = null, tint = Color.White) },
                label = { Text(text = item.title, color = Color.White) },
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun AppFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick, containerColor = Color.Black) {
        Icon(Icons.Default.Add, contentDescription = "Fab", tint = Color.White)
    }
}
