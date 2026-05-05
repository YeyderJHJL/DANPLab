package com.example.danplab.model

data class Tarea(
    val id: Int,              // KEY
    val descripcion: String,
    val completado: Boolean = false
)