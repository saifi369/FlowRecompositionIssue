package com.example.flowrecompositionissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowrecompositionissue.navigation.MainNavRoute
import com.example.flowrecompositionissue.screens.home.HomeScreen
import com.example.flowrecompositionissue.screens.splash.SplashScreen
import com.example.flowrecompositionissue.ui.theme.FlowRecompositionIssueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      FlowRecompositionIssueTheme {

        val rootNavController = rememberNavController()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          NavHost(
            modifier = Modifier
              .padding(innerPadding),
            navController = rootNavController,
            startDestination = MainNavRoute.SplashScreen
          ) {
            composable<MainNavRoute.SplashScreen> {
              SplashScreen {
                rootNavController.navigate(MainNavRoute.HomeScreen)
              }
            }
            composable<MainNavRoute.HomeScreen> {
              HomeScreen()
            }
          }
        }
      }
    }
  }
}