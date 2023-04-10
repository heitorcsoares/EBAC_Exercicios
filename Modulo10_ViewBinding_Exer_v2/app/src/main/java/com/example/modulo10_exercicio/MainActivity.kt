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
    private lateinit var listAdapter: ListAdapter

    var editName: EditText? = null
    var editBirth: EditText? = null
    var editPhonee: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.lista
        val button = findViewById<Button>(R.id.button)                                   //Variavel Recebe Botão

        iniciarEdit()
        createMockDate()                                                                //Chama função para: Povoa dados na lista

        listView.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(itemList, this)
        listView.adapter = listAdapter

        button.setOnClickListener {                                              //evento de click no Botão Gravar
            adicionar()                                                                 //chama função para incluir dados na lista
        }
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }

    private fun adicionar() {
        var name: String = editName?.text.toString()
        var birth: String = editBirth?.text.toString()
        var phonee: String = editPhonee?.text.toString()

        itemList.add(ListItem(name, birth, phonee))

        listAdapter.notifyDataSetChanged()

        val listUltimo = itemList.last().name
        Toast.makeText(this, "Contato: $listUltimo", Toast.LENGTH_SHORT).show()

        editName?.setText("")
        editBirth?.setText("")
        editPhonee?.setText("")
    }

    private fun createMockDate(){                                                                    //Adicioando Itens a lista(itemList).
        itemList.add(ListItem("Heitor",     "01/01/2023",   "(21)99991-1234"))
        itemList.add(ListItem("Luciano",    "02/02/2023",   "(21)91234-5555"))
        itemList.add(ListItem("Gabriel",    "01/01/2023",   "(21)99991-1234"))
        itemList.add(ListItem("Henrique",   "02/02/2023",   "(21)91234-7788"))
        itemList.add(ListItem("Pedro",      "05/01/2023",   "(21)99988-1234"))
        itemList.add(ListItem("Medeiros",   "07/02/2023",   "(21)96666-5555"))
        itemList.add(ListItem("Paulo",      "09/01/2023",   "(21)94455-1234"))
        itemList.add(ListItem("Gustavo",    "12/02/2023",   "(21)91234-8887"))
    }

    private fun iniciarEdit(){
        editName = findViewById<EditText>(R.id.editName)
        editBirth = findViewById<EditText>(R.id.editBirth)
        editPhonee = findViewById<EditText>(R.id.editPhonee)
    }
}