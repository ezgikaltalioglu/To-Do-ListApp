package com.example.to_do_listapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskInfo
import com.example.to_do_listapp.databinding.FragmentAddBinding
import com.google.firebase.database.FirebaseDatabase

class FragmentAdd : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

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
            buttonNewAddTask.setOnClickListener { findNavController().navigate(R.id.actionFragmentAdd_to_homeFragment)
                var database = FirebaseDatabase.getInstance().reference
                var etNewTaskTitle= binding.etNewTaskTitle.text.toString()
                var etNewTaskCategory= binding.etNewTaskCategory.text.toString()
                var etNewTaskDetail= binding.etNewTaskDetail.text.toString()
                var etNewTaskTime= binding.etNewTaskTime.text.toString()

                database.child(etNewTaskTitle.toString()).setValue(TaskInfo(etNewTaskTitle,etNewTaskCategory,etNewTaskDetail,etNewTaskTime))
            }
        }

        return binding.root

    }
}