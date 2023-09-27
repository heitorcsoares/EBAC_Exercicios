package com.example.hqawasomeapp

import androidx.lifecycle.ViewModel

class HQViewModel : ViewModel() {

    /**Função para carregar conteudo. Tipo [HQDetails.kt]*/
    fun loadHQDetails(): HQDetails {
        return HQDetails("Minha HQ", "Este apenas contéudo fixo")
    }
}