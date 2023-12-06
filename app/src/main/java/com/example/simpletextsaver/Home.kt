package com.example.simpletextsaver

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.simpletextsaver.databinding.DialogNewTextBinding
import com.example.simpletextsaver.databinding.FragmentHomeBinding


class home : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val inclusive = true
        navController.popBackStack(R.id.home, inclusive)

        binding.addNewText.setOnClickListener{
            val dialog = AlertDialog.Builder(requireContext()).create()
            val view = DialogNewTextBinding.inflate(layoutInflater)
            dialog.setView(view.root)
            dialog.setCancelable(true)
            dialog.show()
        }

    }
}