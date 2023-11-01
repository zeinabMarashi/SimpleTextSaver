package com.example.simpletextsaver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpletextsaver.databinding.FragmentProfileBinding
import com.example.simpletextsaver.databinding.FragmentRigestorBinding


class Rigestor : Fragment() {
    lateinit var binding:FragmentRigestorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRigestorBinding.inflate(layoutInflater)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}