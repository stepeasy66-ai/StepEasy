package uk.ac.tees.mad.stepeasy.navigation

sealed class NavigationRoutes(val route : String) {
    object Home : NavigationRoutes("home")
    object Splash : NavigationRoutes("splash")
    object Login : NavigationRoutes("login")
    object Signup : NavigationRoutes("signup")
    object Setting : NavigationRoutes("setting")
    object History : NavigationRoutes("history")
}