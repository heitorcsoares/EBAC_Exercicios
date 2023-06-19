package com.example.mod12_exercicio_jokenpo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mod12_exercicio_jokenpo.databinding.FragmentHomeBinding

class homeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.button.setOnClickListener {
            val action = homeFragmentDirections.actionHomeFragmentToNavigation2()
            findNavController().navigate(action)
        }

        return binding.root
    }
}