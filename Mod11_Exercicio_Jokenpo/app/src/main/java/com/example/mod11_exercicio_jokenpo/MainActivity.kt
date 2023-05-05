package com.example.mod11_exercicio_jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mod11_exercicio_jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val activity_main_jogador = Intent(this, MainActivityJogador::class.java)

        binding.buttonIniciar.setOnClickListener {
            startActivity(activity_main_jogador)
        }

    }
}