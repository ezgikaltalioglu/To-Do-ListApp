package com.example.to_do_listapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.databinding.ItemTodoBinding

class RecyclerAdapter(var mContext: Context, val todoList : ArrayList<TaskDataClass>) : RecyclerView.Adapter<RecyclerAdapter.ToDoViewHolder>(){


    inner class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val item = todoList[position]
            item.apply {
                binding.apply {
                    itemTitle.text = item.etNewTaskTitle
                    Log.e("title", item.etNewTaskTitle)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(position)
        holder.binding.apply {
            iconEdit.setOnClickListener { it.findNavController().navigate(R.id.action_homeFragment_to_fragmentTask)
            }
            iconDelete.setOnClickListener { it.findNavController().navigate(R.id.action_homeFragment_to_fragmentTask) }
        }
        holder.itemView.setOnClickListener {
            
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}
