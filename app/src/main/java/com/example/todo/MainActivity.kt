package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ITodosRVAdapter {
    lateinit var viewModel: TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TodosRVAdapter(this, this)
        recyclerView.adapter= adapter

        viewModel= ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(TodoViewModel::class.java)
        viewModel.allTodos.observe(this, Observer {list ->
            list?.let{
                adapter.updateList(it)
            }

        })

    }
    override fun onItemClicked(todo: todo){
        viewModel.deletetodo(todo)
        Toast.makeText(this, "${todo.text} Deleted", Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val todoText = input.text.toString()
        if(todoText.isNotEmpty()){
            viewModel.inserttodo(todo(todoText))
            Toast.makeText(this, "$todoText Inserted", Toast.LENGTH_LONG).show()
        }
    }

}