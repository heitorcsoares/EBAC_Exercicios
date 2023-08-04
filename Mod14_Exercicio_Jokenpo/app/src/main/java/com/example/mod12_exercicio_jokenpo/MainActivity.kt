package com.example.mod12_exercicio_jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var drawer: DrawerLayout                               //activity_main.xml tem que estar <androidx.drawerlayout.widget.DrawerLayout xmlns:... na primeira linha como tipo de layout.
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView                    //(barra de navegação - inferior da tela)
    lateinit var navController : NavController
    lateinit var appBarConfiguration : AppBarConfiguration
    var jogoAtual: String = "Pedra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)   //infla o layoutl.xml  [ActivityMainBinding] Classe gerada automaticamente  [layoutInflater] Objeto

        setContentView(binding.root)                                //[setContentView] Define o conteudo da Activity  [binding.root] Visualização Raiz de um Layout que é inflado usando vinculação de dados.
        setSupportActionBar(binding.toolbar)                        //toolbar -> configura para ter acesso direto (supportActionBar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.jogadorFragment, R.id.resultadoFragment), drawer)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment   -> bottomNav.visibility = View.GONE
                else                -> bottomNav.visibility = View.VISIBLE
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.resultadoFragment -> {
                    val args = Bundle()
                    args.putString("jogoAtual", jogoAtual)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }

        navDrawer.setupWithNavController(navController)
        navDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.resultadoFragment -> {
                    val args = Bundle()
                    args.putString("jogoAtual", jogoAtual)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }
    }

    //Configuração Ação botão voltar nativo Android
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val jogadasDisponiveis = resources.getStringArray(R.array.spinners)
        jogoAtual = jogadasDisponiveis[position]

        Toast.makeText(this, "Jogada Selecionada: $jogoAtual", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}