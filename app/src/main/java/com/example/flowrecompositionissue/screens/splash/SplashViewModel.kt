package com.example.flowrecompositionissue.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

  private val _isLoggedIn = MutableSharedFlow<Boolean>()
  val isLoggedIn = _isLoggedIn.asSharedFlow()

  fun checkUserLoggedInStatus() {
    viewModelScope.launch {
      delay(1000)
      _isLoggedIn.emit(true)
    }
  }
}