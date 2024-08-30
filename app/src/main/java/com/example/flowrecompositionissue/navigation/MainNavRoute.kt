package com.example.flowrecompositionissue.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class MainNavRoute {

  @Serializable
  data object SplashScreen : MainNavRoute()

  @Serializable
  data object HomeScreen : MainNavRoute()
}