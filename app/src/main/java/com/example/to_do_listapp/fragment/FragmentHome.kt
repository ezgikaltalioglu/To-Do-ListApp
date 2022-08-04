package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_listapp.R
import com.example.to_do_listapp.TaskDataClass
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.adapter.RecyclerAdapter
import com.example.to_do_listapp.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        val taskList = ArrayList<TaskDataClass>()
        val task1 = TaskDataClass(R.drawable.ic_note, "task")
        val task2 = TaskDataClass(R.drawable.ic_note, "task")
        taskList.add(task1)
        taskList.add(task2)
        taskList.add(task2)

        val adapter = RecyclerAdapter(requireContext(), taskList)
        binding.recyclerView.adapter = adapter
        menuOnClick()
        return binding.root
    }
    private fun menuOnClick() {
        binding.toolBar.
        setOnMenuItemClickListener{
            when(it.itemId)
            {
                R.id.addItem ->
                {
                    Toast.makeText(requireContext(),"Clicked", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.actionHomeFragment_to_fragmentAdd)

                    true
                }
                else -> {false}
            }
        }
    }


}