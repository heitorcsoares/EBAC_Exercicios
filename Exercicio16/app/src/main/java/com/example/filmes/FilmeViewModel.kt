package com.example.filmes

import androidx.constraintlayout.widget.Placeholder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmes.placeholder.DataState
import com.example.filmes.placeholder.PlaceholderContent

class FilmeViewModel : ViewModel(){

    /** LiveData - Criação de Variavel - Title */
    private val _filmeTitleLiveData = MutableLiveData<FilmeItemFragment>()
    val hqTitleLiveData: LiveData<FilmeItemFragment>
        get() = _filmeTitleLiveData

    /** LiveData - Criação de Variavel - Details */
    private val _filmeDetailsLiveData = MutableLiveData<FilmeDetalhes>()
    val hqDetailsLiveData: LiveData<FilmeDetalhes>
        get() = _filmeDetailsLiveData

    /** LiveData - Criação de Variavel - STATE */
    private val _dataStateListLiveData = MutableLiveData<DataState<List<PlaceholderContent.PlaceholderItem>>>()
    val dataStateListLiveData: LiveData<DataState<List<PlaceholderContent.PlaceholderItem>>>
        get() = _dataStateListLiveData

    private val _dataStateDetailsLiveData = MutableLiveData<DataState<FilmeDetalhes>>()
    val dataStateDetailsLiveData: LiveData<DataState<FilmeDetalhes>>
        get() = _dataStateDetailsLiveData


    /**Função para carregar conteudo. Tipo [FilmesDetalhes.kt]*/
    fun loadFilmeDetalhes(): FilmeDetalhes {
        return FilmeDetalhes("Meus Filmes", "Este é apenas um conteúdo Fixo!")
    }

}