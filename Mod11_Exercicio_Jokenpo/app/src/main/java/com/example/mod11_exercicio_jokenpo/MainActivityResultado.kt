package com.example.mod11_exercicio_jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mod11_exercicio_jokenpo.databinding.ActivityMainJogadorBinding
import com.example.mod11_exercicio_jokenpo.databinding.ActivityMainResultadoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivityResultado : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarResultado
        setSupportActionBar(binding.toolbarResultado)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.menuNav

        setupToolBar()
        setupDrawer()
        setupBottomNavigation()
    }


    // Bottom Navigation Bar (barra de navegação - inferior da tela)
    private fun setupBottomNavigation() {

        bottomNav.setOnItemSelectedListener {
                menuItem -> when(menuItem.itemId){
            R.id.bottom_option1 -> {
                val intent = Intent(this, MainActivityJogador::class.java)
                startActivity(intent)
                true
            }
            R.id.bottom_option2 -> {
                val intent = Intent(this, MainActivityResultado::class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
        }
    }


    // Configura Toolbar (barra de ferramentas superior)
    private fun setupToolBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_inicial)
    }


    // Configuração Ação botão voltar nativo Android
    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }


    // Define Menu Barra de Ação (ActionBar) Superior/Direita
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {         //configura arquivo de Menu no Activity
        menuInflater.inflate(R.menu.screen_menu,menu)
        return true
    }


    // Define ação dos Itens (ActionBar) Superior/Direita
    override fun onOptionsItemSelected(item: MenuItem): Boolean {   //configura ação do Click no menu
        return when(item.itemId){
            R.id.menu_inicial -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
    }


    // Navigation Drawer (menu lateral aberto arrastando a tela da esquerda para a direita)
    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener {
                menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                R.id.drawer_jogador -> {
                    val intent = Intent(this, MainActivityJogador::class.java)
                    startActivity(intent)
                    true
                }
                R.id.drawer_resultado -> {
                    val intent = Intent(this, MainActivityResultado::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

}