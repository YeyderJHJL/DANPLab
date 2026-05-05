package com.example.danplab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.danplab.components.TareaItem
import com.example.danplab.model.Tarea

@Composable
fun ScreenTareas() {

    var tareas = remember {
        mutableStateListOf(
            Tarea(1,"Ejercicio"),
            Tarea(2,"Agua"),
            Tarea(3,"Dieta")
        )
    }

    var nueva by remember { mutableStateOf("") }

    val completadas by remember {
        derivedStateOf {
            tareas.count { it.completado }
        }
    }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Completadas: $completadas / ${tareas.size}")

        TextField(value = nueva, onValueChange = {nueva=it})

        Button(onClick = {
            if(nueva.isNotEmpty()){
                tareas.add(Tarea(tareas.size+1,nueva))
                nueva=""
            }
        }) {
            Text("Agregar")
        }

        LazyColumn {
            items(tareas, key = { it.id }) { tarea ->

                TareaItem(
                    tarea = tarea,
                    onToggle = {
                        tareas = tareas.map {
                            if(it.id==tarea.id) it.copy(completado=!it.completado)
                            else it
                        }.toMutableStateList()
                    },
                    onDelete = { tareas.remove(tarea) }
                )
            }
        }
    }
}