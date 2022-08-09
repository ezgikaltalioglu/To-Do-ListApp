package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.databinding.FragmentRegisterBinding
import com.google.firebase.database.FirebaseDatabase

class FragmentRegister : Fragment() {
    private var _binding : FragmentRegisterBinding?= null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentRegisterBinding.inflate(inflater,container,false)
        binding.apply {
            buttonSave.setOnClickListener{
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }
}