package com.example.danplab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danplab.components.*

@Composable
fun ScreenIMC(navController: NavController) {

    var genero by remember { mutableStateOf("Hombre") }
    var altura by remember { mutableStateOf(170f) }
    var peso by remember { mutableStateOf(70) }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Row {
            GeneroCard("Hombre", genero=="Hombre", {genero="Hombre"}, Modifier.weight(1f))
            Spacer(Modifier.width(10.dp))
            GeneroCard("Mujer", genero=="Mujer", {genero="Mujer"}, Modifier.weight(1f))
        }

        Spacer(Modifier.height(20.dp))

        Slider(value = altura, onValueChange = {altura=it}, valueRange = 100f..220f)

        Spacer(Modifier.height(20.dp))

        Row {
            ContadorCard("Peso", peso, {peso++},{peso--}, Modifier.weight(1f))
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            val imc = peso / ((altura/100)*(altura/100))
            navController.navigate("resultado/$imc")
        }) {
            Text("Calcular IMC")
        }
    }
}