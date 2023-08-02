package com.example.mod12_exercicio_jokenpo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.mod12_exercicio_jokenpo.databinding.ActivityMainBinding
import com.example.mod12_exercicio_jokenpo.databinding.FragmentJogadorBinding
import com.google.android.material.snackbar.Snackbar

class jogadorFragment : Fragment() {
    lateinit var root: View
    lateinit var selecionarJogada: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifeCycle","onCreate - OK")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentJogadorBinding.inflate(inflater,container,false)
        root = binding.root

        selecionarJogada = binding.spinner

        configSelecaoSpinner()

        setHasOptionsMenu(true)

        Log.d("LifeCycle","onCreateView - OK")

        return root
    }

    private fun configSelecaoSpinner(){
        val adapter = ArrayAdapter.createFromResource(requireContext(), R.array.spinners, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        selecionarJogada.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.tela2_reiniciar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }


    //**
    override fun onResume() {
        super.onResume()

        Log.d("LifeCycle","onResume - OK")
    }

    override fun onStop() {
        super.onStop()

        Log.d("LifeCycle","onStop - OK")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("LifeCycle","onDestroy - OK")
    }

    override fun onDetach() {
        super.onDetach()

        Log.d("LifeCycle","onDetach - OK")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d("LifeCycle","onAttach - OK")
    }

}
