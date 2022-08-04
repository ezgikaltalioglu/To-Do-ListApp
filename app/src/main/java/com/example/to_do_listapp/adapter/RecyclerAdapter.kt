package com.example.to_do_listapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.databinding.ItemTodoBinding

class RecyclerAdapter(var mContext: Context, val todoList : ArrayList<TaskDataClass>) : RecyclerView.Adapter<RecyclerAdapter.ToDoViewHolder>(){

    class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.itemTitle.text = todoList[position].heading
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}
