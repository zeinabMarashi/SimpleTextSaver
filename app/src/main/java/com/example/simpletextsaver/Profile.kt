

package com.example.simpletextsaver

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simpletextsaver.databinding.FragmentProfileBinding

class Profile : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences =
            requireActivity().getPreferences(Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("USERNAME_KEY", "")
        val email = sharedPreferences.getString("EMAIL_KEY", "")
        val password = sharedPreferences.getString("PASSWORD_KEY", "")

        binding.txtUsernameProfile.text = userName
        binding.txtEmailProfile.text = email
        binding.txtPasswordProfile.text = password
    }
}
