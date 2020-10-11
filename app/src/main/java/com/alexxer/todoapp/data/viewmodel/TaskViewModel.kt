package com.alexxer.todoapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alexxer.todoapp.data.TaskDao
import com.alexxer.todoapp.data.TaskDatabase
import com.alexxer.todoapp.data.model.Task
import com.alexxer.todoapp.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val taskDao = TaskDatabase.getDatabase(
        application
    ).taskDao()
    private val repository: TaskRepository

    val getAllData: LiveData<List<Task>>
    val sortByHighPriority: LiveData<List<Task>>
    val sortByLowPriority: LiveData<List<Task>>

    init {
        repository = TaskRepository(taskDao)
        getAllData = repository.getAllData
        sortByHighPriority = repository.sortByHighPriority
        sortByLowPriority = repository.sortByLowPriority
    }

    fun insertData(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(task)
        }
    }

    fun updateData(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(task)
        }
    }

    fun deleteItem(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(task)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Task>>{
        return repository.searchDatabase(searchQuery)
    }

}