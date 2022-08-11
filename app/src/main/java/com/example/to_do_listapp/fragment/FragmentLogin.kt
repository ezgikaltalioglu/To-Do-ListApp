package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.R
import com.example.to_do_listapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class FragmentLogin : Fragment() {
    var _binding: FragmentLoginBinding? = null
    lateinit var auth: FirebaseAuth
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        //     var currentUser = auth.currentUser
        //   if (currentUser != null) {
        //    startActivity(Intent(requireContext(), FragmentProfile::class.java))
        // }


        binding.buttonLogIn.setOnClickListener {
            var loginEmail = binding.etLoginUserEmail.text.toString()
            var loginPassword = binding.etLoginPassword.text.toString()
//            if (TextUtils.isEmpty(loginEmail)) {
//                binding.etLoginUserEmail.error = "Lütfen email giriniz."
//                return@setOnClickListener
//            } else if(TextUtils.isEmpty(loginPassword)) {
//                binding.etLoginPassword.error = "Lütfen parola giriniz."
//                return@setOnClickListener
//            }

            auth.signInWithEmailAndPassword(loginEmail, loginPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var currentUser = auth.currentUser
                        Toast.makeText(requireContext(), "Giris Basarili", Toast.LENGTH_LONG).show()
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                    }
                }.addOnFailureListener { exception ->
                Toast.makeText(requireContext(), exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }


        }

        binding.apply {
            buttonRegister.setOnClickListener { findNavController().navigate(R.id.actionLoginToRegister) }

            }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}