package com.eightbitstechnology.todolistapp


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    val db = TodoDatabase.getDatabase(application)
    private val taskDao = db.taskDao()

    val allTasks : Flow<List<Task>> = taskDao.getAllTasks()

    fun insert(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        taskDao.insert(task)
    }

    fun update(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        taskDao.update(task)
    }

    fun delete(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        taskDao.delete(task)
    }
}