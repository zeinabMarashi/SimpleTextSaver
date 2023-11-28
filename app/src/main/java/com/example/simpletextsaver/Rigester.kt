
package com.example.simpletextsaver

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.simpletextsaver.databinding.FragmentRigesterBinding

class Rigester : Fragment() {
    lateinit var binding: FragmentRigesterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRigesterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            if (binding.txtEmailRigester.length() > 0 &&
                binding.txtUsernameRigester.length() > 0 &&
                binding.txtPasswordRigester.length() > 0
            ) {
                saveUserData(
                    binding.txtUsernameRigester.text.toString(),
                    binding.txtEmailRigester.text.toString(),
                    binding.txtPasswordRigester.text.toString()
                )

                val action =
                    RigesterDirections.actionRigesterToProfile(
                        binding.txtUsernameRigester.text.toString(),
                        binding.txtEmailRigester.text.toString(),
                        binding.txtPasswordRigester.text.toString()
                    )
                findNavController().navigate(action)

                (requireActivity() as MainActivity).setBottomNavigationSelectedItem(R.id.profile)
            }
        }
    }

    private fun saveUserData(username: String, email: String, password: String) {
        val sharedPreferences =
            requireActivity().getPreferences(Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("USERNAME_KEY", username)
            putString("EMAIL_KEY", email)
            putString("PASSWORD_KEY", password)
            apply()
        }
    }
}
