package com.example.to_do_listapp.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_listapp.R
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.databinding.FragmentAddBinding
import com.example.to_do_listapp.databinding.FragmentHomeBinding
import com.example.to_do_listapp.databinding.FragmentLoginBinding

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
            buttonNewAddTask.setOnClickListener { findNavController().navigate(R.id.actionFragmentAdd_to_homeFragment) }
        }

        return binding.root

    }
}