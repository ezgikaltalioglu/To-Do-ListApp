package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.R
import com.example.to_do_listapp.UserInfo
import com.example.to_do_listapp.databinding.FragmentLoginBinding
import com.google.firebase.database.FirebaseDatabase


class FragmentLogin : Fragment() {

    private var _binding: FragmentLoginBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        var database = FirebaseDatabase.getInstance().reference

        binding.buttonLogIn.setOnClickListener {
            var etLoginUserName= binding.etLoginUserName.text.toString()
            var etLoginPassword= binding.etLoginPassword.text.toString()
            database.setValue(UserInfo(etLoginUserName,etLoginPassword))

        }

        binding.apply {
            buttonRegister.setOnClickListener{findNavController().navigate(R.id.actionLoginToRegister)}

            buttonLogIn.setOnClickListener {startActivity(Intent(requireContext(), MainActivity::class.java)) }

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}