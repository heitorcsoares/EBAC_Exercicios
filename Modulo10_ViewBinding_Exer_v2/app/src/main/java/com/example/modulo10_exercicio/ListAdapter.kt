package com.example.modulo10_exercicio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modulo10_exercicio.databinding.ItemBinding

class ListAdapter(
    val listItems: MutableList<ListItem>,
    val listener: ListAdapterListener
): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = listItems[position]
        holder.posicao.text = position.toString()
        holder.name.text = item.name
        holder.birth.text = item.birth
        holder.phone.text = item.phone

        holder.root.setOnClickListener{
            listener.onItemClicked(item.name)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size                                                       //retorna tamanho da Lista
    }

    class ListItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        var root = binding.root
        var posicao = binding.posicao
        var name = binding.name
        var birth = binding.birth
        var phone = binding.phone
    }

    interface ListAdapterListener {
        fun onItemClicked(content: String)                                          //Função de Click na linha da lista
    }
}