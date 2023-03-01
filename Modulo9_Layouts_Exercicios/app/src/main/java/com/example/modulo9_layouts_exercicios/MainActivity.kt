package com.example.modulo9_layouts_exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var celular: TextView? = null
    var email: TextView? = null
    var endereco: TextView? = null
    var github: TextView? = null
    var instagram: TextView? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celular = findViewById<TextView>(R.id.textCelular)
        email = findViewById<TextView>(R.id.textEmail)
        endereco = findViewById<TextView>(R.id.textEndereco)
        github = findViewById<TextView>(R.id.textGithub)
        instagram = findViewById<TextView>(R.id.textInstagram)

        val destaque = findViewById<Switch>(R.id.switch1)

        destaque.isChecked = false

        destaque.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                EditarEstilo(R.style.texto2)
            } else {
                EditarEstilo(R.style.texto)
            }
        }
    }

    fun EditarEstilo (estilo: Int){
        celular?.setTextAppearance(estilo)
        email?.setTextAppearance(estilo)
        endereco?.setTextAppearance(estilo)
        github?.setTextAppearance(estilo)
        instagram?.setTextAppearance(estilo)
    }
}


