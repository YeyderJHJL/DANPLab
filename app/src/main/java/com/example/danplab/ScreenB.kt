package com.example.danplab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenB(
    peso: Float,
    altura: Float,
    genero: String,
    navController: NavController
) {

    val imc = if (altura > 0) peso / (altura * altura) else 0f

    val resultado = when {
        imc < 18.5 -> "Bajo peso"
        imc < 25 -> "Normal"
        imc < 30 -> "Sobrepeso"
        else -> "Obesidad"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Resultado IMC", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Género: $genero")
        Text("IMC: ${"%.2f".format(imc)}")
        Text("Clasificación: $resultado")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}