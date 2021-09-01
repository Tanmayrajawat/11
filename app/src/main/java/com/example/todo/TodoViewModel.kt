package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    val allTodos: LiveData<List<todo>>
    private  val repo: todoRepo
    init {
        val dao = todoDatabase.getDatabase(application).gettodoDao()
        repo = todoRepo(dao)
        allTodos= repo.allTodos
    }

    fun deletetodo(todo: todo) =viewModelScope.launch(Dispatchers.IO) {
        repo.delete(todo)
    }

    fun inserttodo(todo: todo) =viewModelScope.launch(Dispatchers.IO) {
        repo.insert(todo)
    }
}