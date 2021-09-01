package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class TodosRVAdapter(private val context: Context, private val listener: MainActivity) :RecyclerView.Adapter<TodosRVAdapter.TodoViewHolder>() {
    val allTodos = ArrayList<todo>()

    inner  class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton =itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val viewHolder= TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked((allTodos[viewHolder.adapterPosition]))
        }
        return  viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val currentTodo = allTodos[position]
        holder.textView.text= currentTodo.text
    }

    override fun getItemCount(): Int {

        return  allTodos.size
    }
    fun updateList(newList: List<todo>){
        allTodos.clear()
        allTodos.addAll(newList)

        notifyDataSetChanged()
    }
}

interface ITodosRVAdapter{
    fun onItemClicked(todo: todo)
}