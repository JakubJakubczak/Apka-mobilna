package com.example.myapplication.ui

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.myapplication.ui.navBarItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    drawerState: DrawerState,
    onClickMenu: () -> Unit,
) {
    val scope = rememberCoroutineScope()    //for future use
    val ctx = LocalContext.current

    TopAppBar(
        title = {
            Text("My Application")
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
//        navigationIcon = {
//            IconButton(onClick = { Toast.makeText(ctx,"NOT IMPLEMENTED YET !", Toast.LENGTH_SHORT).show() })
//            {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "Navi Icon"
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = { onClickMenu }) {
//                Icon(
//                    imageVector = Icons.Filled.MoreVert,
//                    contentDescription = "Menu Icon"
//                )
//            }
//        },
    )
}

@Composable
fun AppBottomNavBar(
    navController : NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = modifier
    ) {
        navBarItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = null) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        //restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun AppFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(Icons.Default.Add, contentDescription = "Fab")
    }
}
