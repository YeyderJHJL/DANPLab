package com.example.danplab.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.danplab.model.Tarea

@Composable
fun TareaItem(
    tarea: Tarea,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Checkbox(
                checked = tarea.completado,
                onCheckedChange = { onToggle() }
            )
            Text(tarea.descripcion)
        }

        IconButton(onClick = onDelete) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
        }
    }
}