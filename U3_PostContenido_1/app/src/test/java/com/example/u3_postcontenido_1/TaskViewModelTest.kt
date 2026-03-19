package com.example.u3_postcontenido_1

import com.example.u3_postcontenido_1.data.FakeTaskRepository
import com.example.u3_postcontenido_1.presentation.TaskUiState
import com.example.u3_postcontenido_1.presentation.TaskViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


// test/TaskViewModelTest.kt
@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule() // Reemplaza Main dispatcher con TestDispatcher
    private lateinit var fakeRepo: FakeTaskRepository
    private lateinit var viewModel: TaskViewModel
    @Before
    fun setUp() {
        fakeRepo = FakeTaskRepository()
        viewModel = TaskViewModel(fakeRepo)
    }
    @Test
    fun `carga de tareas produce estado Success con datos del repositorio`(): Unit = runTest {
        viewModel.loadTasks()
        val state = viewModel.uiState.value
        assertTrue(state is TaskUiState.Success)
        assertEquals(4, (state as TaskUiState.Success).tasks.size)
    }
}