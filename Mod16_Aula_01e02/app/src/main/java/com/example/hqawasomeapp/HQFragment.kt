package com.example.hqawasomeapp

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.navigation.navGraphViewModels
import com.example.hqawasomeapp.placeholder.PlaceholderContent
import com.google.android.material.snackbar.Snackbar

class HQFragment : Fragment(), HQItemListener {

    private var columnCount = 1
    private val viewModel by navGraphViewModels<HQViewModel>(R.id.hq_graph){defaultViewModelProviderFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        /** Configurando o adapter */
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyhqRecyclerViewAdapter(PlaceholderContent.ITEMS, this@HQFragment)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            HQFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onItemSelected(position: Int) {
        val selectedItem = PlaceholderContent.ITEMS[position] // Obtém o item selecionado
        val message = "Item selecionado: ${selectedItem.content}"

        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}