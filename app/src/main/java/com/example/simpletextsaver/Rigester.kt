package com.example.simpletextsaver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simpletextsaver.databinding.FragmentRigesterBinding


class Rigester : Fragment() {
    lateinit var binding:FragmentRigesterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRigesterBinding.inflate(layoutInflater)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val inclusive = true // Set to true to include this fragment in the pop
        navController.popBackStack(R.id.rigester, inclusive)
        }
    }
