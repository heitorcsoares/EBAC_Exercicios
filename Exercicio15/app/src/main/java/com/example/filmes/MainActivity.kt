package com.example.filmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContContainerView) as NavHostFragment
        navController = navHost.navController
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}