package uk.ac.tees.mad.stepeasy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.ac.tees.mad.stepeasy.ui.splash.SplashScreen

@Composable
fun AppNavigationHost(
    startDestination: String,
    navController: NavHostController,
    modifier: Modifier = Modifier
){

    NavHost(
        startDestination = startDestination ,
        navController = navController,
        modifier = modifier
    ) {
        composable(route = NavigationRoutes.Splash.route){
            SplashScreen(
                onNavigateLogin = {

                } ,
                onNavigateHome = {

                }
            )
        }

        composable(route = NavigationRoutes.Home.route){

        }

        composable(route = NavigationRoutes.Setting.route){

        }

        composable(route = NavigationRoutes.Login.route){

        }

        composable(route = NavigationRoutes.Signup.route){

        }

    }

}