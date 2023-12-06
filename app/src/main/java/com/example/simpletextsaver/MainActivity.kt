package com.example.simpletextsaver

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.simpletextsaver.databinding.ActivityMainBinding
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)
        val bottomNavigationView: ChipNavigationBar = binding.bottomNavigation

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setItemSelected(R.id.register, true)

        bottomNavigationView.setOnItemSelectedListener { itemId ->
            when (itemId) {
                R.id.home -> {
                    navController.navigate(R.id.home2)
                }
                R.id.register -> {
                    navController.navigate(R.id.rigester)
                }
                R.id.profile -> {
                    navController.popBackStack(R.id.home, false)
                    navController.navigate(R.id.profile)
                }
            }
        }
    }
    fun setBottomNavigationSelectedItem(itemId: Int) {
        binding.bottomNavigation.setItemSelected(itemId, true)
    }
}
