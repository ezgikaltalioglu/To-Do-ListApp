package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.to_do_listapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.FirebaseDatabase

class FragmentRegister : Fragment() {
    private lateinit var auth : FirebaseAuth
    private var _binding : FragmentRegisterBinding?= null
    private val binding get()=_binding!!
    var database = FirebaseDatabase.getInstance().reference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        auth=FirebaseAuth.getInstance()
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
                            var currentUser = auth.currentUser
                            var currentUserDb = currentUser?.let { it1->database?.child(it1.uid) }
                            currentUserDb?.child("UserNameInfo")?.setValue(binding.etSaveUserName.text.toString())
                            Toast.makeText(requireContext(),"Kayıt Başarılı",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(requireContext(),"Kayıt Hatalı",Toast.LENGTH_LONG).show()
                        }
                    }

                    //database.setValue(UserInfo(etSaveUserName,etSavePassword))
                    //database.child(etSaveUserName.toString()).setValue(UserInfo(etSaveUserName,etSavePassword))
                }
            binding.buttonBack.setOnClickListener {
                startActivity(Intent(requireContext(),FragmentHome::class.java))

            }


        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}