package com.example.flowrecompositionissue.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onCheckComplete: () -> Unit) {

  val viewModel: SplashViewModel = hiltViewModel()

  SplashScreenContent(viewModel, onCheckComplete)
}

@Composable
fun SplashScreenContent(viewModel: SplashViewModel, onCheckComplete: () -> Unit) {

  val isUserLogged by viewModel.isLoggedIn.collectAsStateWithLifecycle(initialValue = null)

  if (isUserLogged == true) {
    onCheckComplete()
  }

  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Splash Screen", style = MaterialTheme.typography.titleLarge)
    Button(onClick = { viewModel.checkUserLoggedInStatus() }) {
      Text(text = "Check User Status")
    }
  }
}