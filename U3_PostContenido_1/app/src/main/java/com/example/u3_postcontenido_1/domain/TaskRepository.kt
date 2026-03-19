package com.example.u3_postcontenido_1.domain

// domain/TaskRepository.kt — Contrato de acceso a datos
interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun addTask(title: String)
}