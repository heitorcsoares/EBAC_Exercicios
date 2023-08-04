package com.example.mod12_exercicio_jokenpo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.mod12_exercicio_jokenpo.databinding.FragmentResultadoBinding

class resultadoFragment : Fragment() {
    lateinit var engine: JokenpoEngine
    lateinit var bind: FragmentResultadoBinding
    lateinit var resultText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = FragmentResultadoBinding.inflate(inflater, container, false)
        engine = JokenpoEngine(resources.getStringArray(R.array.spinners))

        val jogoAtual = arguments?.getString("jogoAtual")
        resultText = bind.resultlabel

        jogoAtual?.let {updateResulText(jogoAtual)}

        setHasOptionsMenu(true)

        return bind.root
    }

    private fun updateResulText(jogoAtual: String) {
        val jogoAtual = engine.calcularResultado(jogoAtual)

        resultText.text = when(jogoAtual) {
            Result.VITORIA  -> "O Jogador 1 \n Ganhou"
            Result.PERDEU   -> "O Jogador 1 \n Perdeu"
            else            -> "O Jogador 1 \n Empatou"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.tela2_reiniciar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }
}