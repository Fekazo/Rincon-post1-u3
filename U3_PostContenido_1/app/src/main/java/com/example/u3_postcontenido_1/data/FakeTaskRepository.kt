package com.example.u3_postcontenido_1.data

import com.example.u3_postcontenido_1.domain.Task
import com.example.u3_postcontenido_1.domain.TaskRepository
import javax.inject.Inject

// data/FakeTaskRepository.kt — Repositorio simulado con datos en memoria
class FakeTaskRepository @Inject constructor() : TaskRepository {
    private val tasks = mutableListOf(
        Task(1, "Estudiar patrones arquitectónicos MVC, MVP y MVVM"),
        Task(2, "Implementar ViewModel con StateFlow en Android"),
        Task(3, "Configurar Hilt en el proyecto con KSP"),
        Task(4, "Escribir test unitario del ViewModel", completed = true),
    )
    override suspend fun getAllTasks(): List<Task> = tasks.toList()
    override suspend fun addTask(title: String) {
        tasks.add(Task(id = tasks.size.toLong() + 1, title = title))
    }
}