package com.example.u3_postcontenido_1.di

import com.example.u3_postcontenido_1.data.FakeTaskRepository
import com.example.u3_postcontenido_1.domain.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// di/RepositoryModule.kt — Hilt: vincula interfaz con implementación
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        impl: FakeTaskRepository
    ): TaskRepository
}