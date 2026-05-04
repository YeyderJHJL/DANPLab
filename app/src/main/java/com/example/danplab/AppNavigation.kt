package com.example.danplab

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.screenA, builder = {
        composable(Routes.screenA) {
            ScreenA(navController)
        }
        composable(Routes.screenB + "/{peso}/{altura}/{genero}") { backStackEntry ->
            val peso = backStackEntry.arguments?.getString("peso")?.toFloatOrNull() ?: 0f
            val altura = backStackEntry.arguments?.getString("altura")?.toFloatOrNull() ?: 0f
            val genero = backStackEntry.arguments?.getString("genero") ?: ""
            ScreenB(peso, altura, genero, navController)
        }
    })
}