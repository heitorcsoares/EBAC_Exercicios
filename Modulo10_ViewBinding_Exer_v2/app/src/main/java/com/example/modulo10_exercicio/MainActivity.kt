package com.example.modulo10_exercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.modulo10_exercicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ListAdapter.ListAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private val itemList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.lista
        val button = findViewById<Button>(R.id.button)                                   //Variavel Recebe Botão

        createMockDate()                                                                //Chama função para: Povoa dados na lista

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = ListAdapter(itemList, this)

        button.setOnClickListener {                                              //evento de click no Botão Gravar
            adicionar()                                                                 //chama função para incluir dados na lista
        }
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }

    private fun adicionar() {
        var editName: EditText? = findViewById<EditText>(R.id.editName)
        var editBirth: EditText? = findViewById<EditText>(R.id.editBirth)
        var editPhonee: EditText? = findViewById<EditText>(R.id.editPhonee)

        var name: String = editName?.text.toString()
        var birth: String = editBirth?.text.toString()
        var phonee: String = editPhonee?.text.toString()

        itemList.add(ListItem(name, birth, phonee))
        //notifyDataSetChanged()

        val listUltimo = itemList.last().name

        Toast.makeText(this, "Contato: $listUltimo", Toast.LENGTH_SHORT).show()

        editName?.setText("")
        editBirth?.setText("")
        editPhonee?.setText("")
    }

    private fun createMockDate(){                                                       //Adicioando Itens a lista(itemList).
        itemList.add(ListItem("Heitor",     "01/01/2023",   "(21)99645-1569"))
        itemList.add(ListItem("Luciano",    "01/01/2023",   "(21)99645-1569"))
    }
}