package com.example.todo

import androidx.lifecycle.LiveData

class todoRepo(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<todo>> = todoDao.getAllTodo()
    suspend fun insert(todo: todo){
        todoDao.insert(todo)
    }
    suspend fun delete(todo: todo){
        todoDao.delete(todo)
    }

}