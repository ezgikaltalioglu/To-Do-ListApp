package com.example.to_do_listapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do_listapp.UserInfo
import com.example.to_do_listapp.activity.MainActivity
import com.example.to_do_listapp.databinding.FragmentRegisterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentRegister : Fragment() {
    private var _binding : FragmentRegisterBinding?= null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentRegisterBinding.inflate(inflater,container,false)
        _binding.apply {
                binding.buttonSave.setOnClickListener{
                    var database = FirebaseDatabase.getInstance().reference
                    var etSaveUserName= binding.etSaveUserName.text.toString()
                    var etSavePassword= binding.etSavePassword.text.toString()
                    //database.setValue(UserInfo(etSaveUserName,etSavePassword))
                    startActivity(Intent(requireContext(), MainActivity::class.java))

                    database.child(etSaveUserName.toString()).setValue(UserInfo(etSaveUserName,etSavePassword))
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}