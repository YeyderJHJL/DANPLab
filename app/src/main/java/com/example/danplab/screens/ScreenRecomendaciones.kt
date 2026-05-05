package com.example.danplab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenRecomendaciones(imc: Float, navController: NavController) {

    val lista = when {
        imc < 18.5 -> listOf("Comer más", "Ejercicio ligero")
        imc < 25 -> listOf("Mantener dieta", "Ejercicio regular")
        imc < 30 -> listOf("Reducir calorías", "Cardio")
        else -> listOf("Dieta estricta", "Ejercicio diario")
    }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        LazyColumn {
            items(lista) {
                Text(it)
            }
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = { navController.navigate("tareas") }) {
            Text("Ir a tareas")
        }
    }
}