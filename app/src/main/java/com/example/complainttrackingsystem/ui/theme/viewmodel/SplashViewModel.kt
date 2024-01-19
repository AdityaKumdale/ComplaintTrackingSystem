package com.example.complainttrackingsystem.ui.theme.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.complainttrackingsystem.data.DataStoreRepository
import com.example.complainttrackingsystem.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//If the SplashViewModel is more application-wide and not closely tied to a specific UI component, it may not need to be injected with Hilt's ViewModel injection.
//ViewModels that are shared across multiple UI components or have a broader scope might not require Hilt's injection for ViewModels.

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    //State type is typically used in Compose to represent observable state that can be observed by Compose components, triggering recomposition when the state changes.
    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading //read-only property

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect{ completed ->
                if (completed) {
                    _startDestination.value = Screen.Login.route
                } else {
                    _startDestination.value = Screen.Welcome.route
                }
            }
            _isLoading.value = false //after collecting the onboarding status value we no longer need splash screen
        }
    }

}