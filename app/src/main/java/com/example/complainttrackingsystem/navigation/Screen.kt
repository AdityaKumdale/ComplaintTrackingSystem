package com.example.complainttrackingsystem.navigation

sealed class Screen(val route: String) {
     object Welcome : Screen(route = "welcome_screen")
     object Home : Screen(route = "home_screen")
     object Login: Screen(route = "login_screen")

     object SeeAll: Screen(route = "see_all")
     object NewComplaint: Screen(route = "new_complaint")
}