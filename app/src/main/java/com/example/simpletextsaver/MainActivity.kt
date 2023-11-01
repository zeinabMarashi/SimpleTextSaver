package com.example.simpletextsaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.simpletextsaver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)
        binding.bottomNavigation.setOnItemSelectedListener {
            val navController = findNavController(R.id.fragmentContainerView)
            when (it) {
                R.id.home -> {
                    navController.navigateUp()
                    navController.navigate(R.id.home)
                }
                R.id.register -> {
                    navController.navigateUp()
                    navController.navigate(R.id.rigestor)
                }
                R.id.profile -> {
                    navController.navigateUp()
                    navController.navigate(R.id.profile)
                }
            }
        }
    }
}
