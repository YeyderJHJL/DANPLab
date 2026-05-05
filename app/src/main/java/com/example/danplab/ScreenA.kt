package com.example.danplab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.danplab.components.GeneroCard
import com.example.danplab.components.ContadorCard

@Composable
fun ScreenA(navController: NavController) {

    var genero by remember { mutableStateOf("Hombre") }
    var altura by remember { mutableStateOf(175f) }
    var peso by remember { mutableStateOf(70) }
    var edad by remember { mutableStateOf(25) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Indice Masa Corporal", fontSize = 26.sp)
        Text("Ingrese y seleccione la información")

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            GeneroCard(
                texto = "Hombre",
                seleccionado = genero == "Hombre",
                onClick = { genero = "Hombre" },
                modifier = Modifier.weight(1f)
            )

            GeneroCard(
                texto = "Mujer",
                seleccionado = genero == "Mujer",
                onClick = { genero = "Mujer" },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Altura")

                Text(
                    text = "${altura.toInt()} cm",
                    fontSize = 30.sp,
                    color = Color(0xFF6A4FBF)
                )

                Slider(
                    value = altura,
                    onValueChange = { altura = it },
                    valueRange = 100f..220f
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            ContadorCard(
                titulo = "Peso (kg)",
                valor = peso,
                onIncrement = { peso++ },
                onDecrement = { if (peso > 1) peso-- },
                modifier = Modifier.weight(1f)
            )

            ContadorCard(
                titulo = "Edad",
                valor = edad,
                onIncrement = { edad++ },
                onDecrement = { if (edad > 1) edad-- },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("${Routes.screenB}/$peso/$altura/$genero")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("CALCULAR")
        }
    }
}