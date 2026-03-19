package com.example.u3_postcontenido_1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.u3_postcontenido_1.domain.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// presentation/TaskViewModel.kt — ViewModel sin referencia a la UI
@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<TaskUiState>(TaskUiState.Loading)
    val uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()
    init { loadTasks() }
    fun loadTasks() {
        viewModelScope.launch {
            _uiState.value = TaskUiState.Loading
            _uiState.value = try {
                TaskUiState.Success(repository.getAllTasks())
            } catch (e: Exception) {
                TaskUiState.Error(e.message ?: "Error al cargar tareas")
            }
        }
    }
}