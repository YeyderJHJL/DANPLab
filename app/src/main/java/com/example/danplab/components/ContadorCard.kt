package com.example.danplab.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column

@Composable
fun ContadorCard(
    titulo: String,
    valor: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .height(150.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(titulo)

            Text(valor.toString(), fontSize = 28.sp)

            Row {

                Button(onClick = onDecrement) {
                    Text("-")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = onIncrement) {
                    Text("+")
                }
            }
        }
    }
}