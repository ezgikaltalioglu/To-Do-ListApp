package com.example.to_do_listapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.adapter.RecyclerAdapter
import com.example.to_do_listapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth
    val taskList = ArrayList<TaskDataClass>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager =LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        var currentUser = auth.currentUser
        database= FirebaseDatabase.getInstance().reference.child(currentUser?.uid!!).child("task")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    taskList.clear()
                    for (taskSnapshot in snapshot.children){
                        val task = taskSnapshot.getValue(TaskDataClass::class.java)
                        taskList.add(task!!)
                    }
                }
                val adapter = RecyclerAdapter(requireContext(), taskList)
                binding.recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

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