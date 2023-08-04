package com.example.mod12_exercicio_jokenpo

import kotlin.random.Random

enum class Result{VITORIA, EMPATE, PERDEU}

class JokenpoEngine(private val jogadasDisponíveis: Array<String>){

    fun calcularResultado(jogadaJogador: String): Result{
        val jogadaIA = getAIPlay()

        return when{
            jogadaJogador == jogadaIA                           -> Result.EMPATE
            jogadaJogador == "Pedra" && jogadaIA == "Tesoura"   -> Result.VITORIA
            jogadaJogador == "Pedra" && jogadaIA == "Papel"     -> Result.PERDEU
            jogadaJogador == "Papel" && jogadaIA == "Pedra"     -> Result.VITORIA
            jogadaJogador == "Papel" && jogadaIA == "Tesoura"   -> Result.PERDEU
            jogadaJogador == "Tesoura" && jogadaIA == "Papel"   -> Result.VITORIA
            else                                                -> Result.PERDEU
        }
    }

    private fun getAIPlay() : String{
        val playIndex = Random.nextInt(0,2)
        return jogadasDisponíveis[playIndex]
    }
}