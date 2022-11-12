package com.example.dadocomimagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botão1: Button = findViewById(R.id.rolar1)
        botão1.setOnClickListener { rolarDado(); rolarDado2()}

        //isso é só para o aplicativo ja abrir mostrando um dado aleatorio
        rolarDado()
        rolarDado2()

    }

    private fun rolarDado() {
        val numLados = 6
        val dadoJogado = Dado(numLados)
        val resultado = dadoJogado.jogado()
        val imagemDado: ImageView = findViewById(R.id.fotododado1)


        //não necessáriamente era preciso fazer como função, dava pra ser when direto
        val drawbleResource = when (resultado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imagemDado.setImageResource(drawbleResource)
        //isso ta aqui só por questão de acessibilidade, o app pode ler o numero que saiu
        imagemDado.contentDescription = resultado.toString()

    }

    private fun rolarDado2() {
        val numLados = 6
        val dadoJogado = Dado(numLados)
        val resultado2 = dadoJogado.jogado()
        val imagemDado2: ImageView = findViewById(R.id.fotododado2)


        //não necessáriamente era preciso fazer como função, dava pra ser when direto
        val drawbleResource2 = when (resultado2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imagemDado2.setImageResource(drawbleResource2)
        //isso ta aqui só por questão de acessibilidade, o app pode ler o numero que saiu
        imagemDado2.contentDescription = resultado2.toString()

    }

}

class Dado(private val lados: Int) {

    fun jogado(): Int {
        return (1..lados).random()
    }
}