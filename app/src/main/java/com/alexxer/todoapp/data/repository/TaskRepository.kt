package com.alexxer.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.alexxer.todoapp.data.TaskDao
import com.alexxer.todoapp.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    val getAllData:LiveData<List<Task>> = taskDao.getAllData()
    val sortByHighPriority:LiveData<List<Task>> = taskDao.sortByHighPriority()
    val sortByLowPriority:LiveData<List<Task>> = taskDao.sortByLowPriority()

    suspend fun insertData(task: Task){
        taskDao.insertData(task)
    }

    suspend fun updateData(task: Task){
        taskDao.updateData(task)
    }

    suspend fun deleteItem(task: Task){
        taskDao.deleteItem(task)
    }

    suspend fun deleteAll(){
        taskDao.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Task>> {
        return taskDao.searchDatabase(searchQuery)
    }
}