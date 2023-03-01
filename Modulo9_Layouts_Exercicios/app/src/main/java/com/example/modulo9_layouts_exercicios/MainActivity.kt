package com.example.modulo9_layouts_exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var celular: TextView? = null
    private var email: TextView? = null
    private var endereco: TextView? = null
    private var github: TextView? = null
    private var instagram: TextView? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celular = findViewById(R.id.textCelular)
        email = findViewById(R.id.textEmail)
        endereco = findViewById(R.id.textEndereco)
        github = findViewById(R.id.textGithub)
        instagram = findViewById(R.id.textInstagram)

        val destaque = findViewById<Switch>(R.id.switch1)

        destaque.isChecked = false

        destaque.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editarEstilo(R.style.texto2)
            } else {
                editarEstilo(R.style.texto)
            }
        }
    }

    fun editarEstilo (estilo: Int){
        celular?.setTextAppearance(estilo)
        email?.setTextAppearance(estilo)
        endereco?.setTextAppearance(estilo)
        github?.setTextAppearance(estilo)
        instagram?.setTextAppearance(estilo)
    }
}


