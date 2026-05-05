package com.example.danplab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danplab.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.imc
    ) {

        composable(Routes.imc) {
            ScreenIMC(navController)
        }

        composable("${Routes.resultado}/{imc}") {
            val imc = it.arguments?.getString("imc")!!.toFloat()
            ScreenResultado(imc, navController)
        }

        composable("${Routes.recomendaciones}/{imc}") {
            val imc = it.arguments?.getString("imc")!!.toFloat()
            ScreenRecomendaciones(imc, navController)
        }

        composable(Routes.tareas) {
            ScreenTareas()
        }
    }
}