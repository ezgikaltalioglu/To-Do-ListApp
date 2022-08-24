package com.example.to_do_listapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.databinding.FragmentAddBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FragmentAdd : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.apply {
            buttonNewAddTask.setOnClickListener {
                var database = FirebaseDatabase.getInstance().reference
                var newTaskTitle= binding.etNewTaskTitle.text.toString()
                var newTaskCategory= binding.etNewTaskCategory.text.toString()
                var newTaskDetail= binding.etNewTaskDetail.text.toString()
                var newTaskTime= binding.etNewTaskTime.text.toString()
                var user = FirebaseAuth.getInstance().currentUser?.uid.toString()
                var taskId = database.push().key.toString()

                database.child(user).child("task").child(taskId).setValue(TaskDataClass(newTaskTitle,newTaskCategory,newTaskDetail,newTaskTime))
                findNavController().navigate(R.id.actionFragmentAdd_to_homeFragment)
            }
        }

        return binding.root

    }
}