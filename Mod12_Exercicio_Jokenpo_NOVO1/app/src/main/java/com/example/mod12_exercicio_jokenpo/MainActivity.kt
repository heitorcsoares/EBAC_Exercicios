package com.example.mod12_exercicio_jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mod12_exercicio_jokenpo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout                               //Activity_main2.xml tem que estar <androidx.drawerlayout.widget.DrawerLayout xmlns:... na primeira linha
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView                   //(barra de navegação - inferior da tela)
    lateinit var navController : NavController
    lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)   //infla o layoutl.xml  [ActivityMainBinding] Classe gerada automaticamente  [layoutInflater] Objeto
        val toolbar = binding.toolbar

        setContentView(binding.root)                                //[setContentView] Define o conteudo da Activity  [binding.root] Visualização Raiz de um Layout que é inflado usando vinculação de dados.
        setSupportActionBar(binding.toolbar)                       //toolbar -> configura para ter acesso direto (supportActionBar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.jogadorFragment,R.id.resultadoFragment),drawer)

        navController.addOnDestinationChangedListener {_ , destination, _ ->
            when(destination.id){
                R.id.homeFragment ->  bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)
    }

    //Configuração Ação botão voltar nativo Android
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}