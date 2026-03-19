package com.example.u3_postcontenido_1.domain

// domain/Task.kt — Entidad del dominio
data class Task(
    val id : Long,
    val title : String,
    val completed: Boolean = false,
)

