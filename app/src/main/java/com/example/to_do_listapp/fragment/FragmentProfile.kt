package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.R
import com.example.to_do_listapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class FragmentProfile : Fragment() {

    private var _binding : FragmentProfileBinding?= null
    private val binding get()=_binding!!
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProfileBinding.inflate(inflater,container,false)

        auth=FirebaseAuth.getInstance()
        var currentUser=auth.currentUser
        println(currentUser?.email)
        binding.tvUserInfo2.text="Email: "+currentUser?.email.toString()


        binding.buttonLogout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(requireContext(),FragmentLogin::class.java))
        }
        binding.apply {
            //todo:hata main navdan auth nava gecerken sorun oluyor
            buttonLogout.setOnClickListener { findNavController().navigate(R.id.actionLoginToRegister) }

        }
        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}