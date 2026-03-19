package com.example.u3_postcontenido_1.presentation

import com.example.u3_postcontenido_1.domain.Task

// presentation/TaskUiState.kt — Estados posibles de la pantalla
sealed class TaskUiState {
    object Loading : TaskUiState()
    data class Success(val tasks: List<Task>) : TaskUiState()
    data class Error (val message: String) : TaskUiState()
}