package com.example.to_do_listapp.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.adapter.RecyclerAdapter
import com.example.to_do_listapp.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val taskList = ArrayList<TaskDataClass>()

        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    var etNewTaskTitle = i.child("etNewTaskTitle").getValue().toString()
                    var etNewTaskCategory = i.child("etNewTaskCategory").getValue().toString()
                    var etNewTaskDetail = i.child("etNewTaskDetail").getValue().toString()
                    var etNewTaskTime = i.child("etNewTaskTime").getValue().toString()
                    val task = TaskDataClass(
                        R.drawable.ic_note,
                        etNewTaskTitle,
                        etNewTaskCategory,
                        etNewTaskDetail,
                        etNewTaskTime
                    )
                    taskList.add(task)
                }
                //todo hata
                val adapter = RecyclerAdapter(requireContext(), taskList)
                binding.recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }
        database.addValueEventListener(getData)
        menuOnClick()
        return binding.root
    }

    private fun menuOnClick() {
        binding.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.addItem -> {
                    Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.actionHomeFragment_to_fragmentAdd)

                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}