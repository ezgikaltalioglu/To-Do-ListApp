package com.example.to_do_listapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.adapter.RecyclerAdapter
import com.example.to_do_listapp.databinding.FragmentAddBinding
import com.example.to_do_listapp.databinding.FragmentHomeBinding
import com.example.to_do_listapp.databinding.FragmentTaskBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class FragmentTask : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth
    val taskList = ArrayList<TaskDataClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        

        binding = FragmentTaskBinding.inflate(inflater, container, false)
        binding.buttonUpdate.setOnClickListener {
            val newTaskTitle= binding.etNewTaskTitle.toString()
            val newTaskCategory=binding.etNewTaskCategory.toString()
            val newTaskDetail=binding.etNewTaskDetail.toString()
            val newTaskTime=binding.etNewTaskTime.toString()

            updateData(newTaskTitle,newTaskCategory,newTaskDetail,newTaskTime)
        }


        return binding.root
    }

    private fun updateData(newTaskTitle: String, newTaskCategory: String, newTaskDetail: String, newTaskTime: String) {
        database=FirebaseDatabase.getInstance().getReference("user")
        val user= mapOf<String,String>(

        )
    }

}