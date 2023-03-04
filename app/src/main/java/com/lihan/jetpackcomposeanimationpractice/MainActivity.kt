package com.lihan.jetpackcomposeanimationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lihan.jetpackcomposeanimationpractice.animation.domain.Route
import com.lihan.jetpackcomposeanimationpractice.animation.presentation.AnimateVisibilityScreen
import com.lihan.jetpackcomposeanimationpractice.animation.presentation.drawer.DrawerBody
import com.lihan.jetpackcomposeanimationpractice.animation.presentation.drawer.DrawerHeader
import com.lihan.jetpackcomposeanimationpractice.ui.theme.JetpackComposeAnimationPracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldStateRemember = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val navigation = rememberNavController()

            JetpackComposeAnimationPracticeTheme {
                Scaffold(
                    scaffoldState = scaffoldStateRemember,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                            Route.ANIMATE_VISIBILITY
                            ),
                            onItemClicked = {
                                navigation.navigate(it)
                            }
                        )
                    },
                    drawerGesturesEnabled = scaffoldStateRemember.drawerState.isOpen,
                    topBar = {
                        Row{
                           IconButton(onClick = {
                               scope.launch {
                                   if (scaffoldStateRemember.drawerState.isOpen){
                                       scaffoldStateRemember.drawerState.close()
                                   }else{
                                       scaffoldStateRemember.drawerState.open()
                                   }
                               }
                           }) {
                               Icon(
                                   imageVector = Icons.Default.Menu,
                                   contentDescription = "menu"
                               )
                           }
                        }
                    }
                ) {
                    NavHost(navController =navigation, startDestination = Route.ANIMATE_VISIBILITY){
                        composable(
                            route = Route.ANIMATE_VISIBILITY
                        ){
                            AnimateVisibilityScreen()
                        }
                    }
                }



            }
        }
    }
}
