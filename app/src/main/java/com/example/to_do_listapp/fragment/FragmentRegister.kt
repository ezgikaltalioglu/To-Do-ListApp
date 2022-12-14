package com.example.to_do_listapp.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.to_do_listapp.R
import com.example.to_do_listapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class FragmentRegister : Fragment() {
    private lateinit var auth : FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private var _binding : FragmentRegisterBinding?= null
    private val binding get()=_binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        auth=FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        _binding= FragmentRegisterBinding.inflate(inflater,container,false)
        _binding.apply {
            binding.buttonSave.setOnClickListener{
                var etSaveUserName= binding.etSaveUserName.text.toString()
                var etSavePassword= binding.etSavePassword.text.toString()
                if(TextUtils.isEmpty((etSaveUserName))){
                    binding.etSaveUserName.error="Lütfen adınızı ve soyadınızı giriniz."
                    return@setOnClickListener
                }else if(TextUtils.isEmpty(etSavePassword)){
                    binding.etSavePassword.error="Parolanızı giriniz."
                    return@setOnClickListener
                }
                auth.createUserWithEmailAndPassword(etSaveUserName, etSavePassword).addOnCompleteListener{ task ->
                    if(task.isSuccessful){

                        val database = FirebaseDatabase.getInstance().reference.child(auth.uid.toString()).child("user_info").child("mail").setValue(etSaveUserName).addOnCompleteListener {
                            Toast.makeText(context, "Kayıt Oluşturuldu", Toast.LENGTH_LONG).show()
                        }
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }

            binding.apply {
                buttonBack.setOnClickListener { findNavController().navigate(R.id.action_fragmentRegister_to_fragmentLogin) }
            }


        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}