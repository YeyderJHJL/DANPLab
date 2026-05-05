package com.example.danplab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    val imc = peso / ((altura / 100) * (altura / 100))

    val (estado, color) = when {
        imc < 18.5 -> "BAJO PESO" to Color.Blue
        imc < 25 -> "NORMAL" to Color(0xFF4CAF50)
        imc < 30 -> "SOBREPESO" to Color.Yellow
        else -> "OBESIDAD" to Color.Red
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("RESULTADOS", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text("IMC = ${"%.2f".format(imc)}", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        Text(estado, fontSize = 22.sp, color = color)

        Spacer(modifier = Modifier.height(10.dp))

        Text("Se encuentra en los valores $estado")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("RECALCULAR")
        }
    }
}