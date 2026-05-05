package com.example.danplab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenResultado(imc: Float, navController: NavController) {

    val estado = when {
        imc < 18.5 -> "Bajo peso"
        imc < 25 -> "Normal"
        imc < 30 -> "Sobrepeso"
        else -> "Obesidad"
    }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("IMC: $imc")
        Text("Estado: $estado")

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate("recomendaciones/$imc")
        }) {
            Text("Ver recomendaciones")
        }
    }
}