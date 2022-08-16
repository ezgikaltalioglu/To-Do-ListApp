package com.example.to_do_listapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.R
import com.example.to_do_listapp.databinding.FragmentAddBinding
import com.example.to_do_listapp.databinding.FragmentHomeBinding
import com.example.to_do_listapp.databinding.FragmentTaskBinding
import com.google.firebase.database.FirebaseDatabase

class FragmentTask : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    var database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)

        return binding.root
    }

}