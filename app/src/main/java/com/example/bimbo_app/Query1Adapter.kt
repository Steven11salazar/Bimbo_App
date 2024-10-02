package com.example.bimbo_app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Query1Adapter(private val query1: List<Query1>): // Define la clase del adaptador y recibe una lista de Query1 como parámetro
    RecyclerView.Adapter<Query1Adapter.Query1ViewHolder>() { // Extiende RecyclerView.Adapter y especifica el tipo de ViewHolder

    // Clase interna que representa cada elemento de la lista en la vista
    class Query1ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // Define los campos del itemView
        private val txtColumna1 = itemView.findViewById<TextView>(R.id.column1)
        private val txtColumna2 = itemView.findViewById<TextView>(R.id.column2)

        // Función para vincular el valor con el campo del itemView
        @SuppressLint("DiscouragedApi")
        fun bind(query1: Query1){
            txtColumna1.text = query1.name // Asigna el valor de la columna1 al campo de columna1
            txtColumna2.text = query1.address // Asigna el valor de la columna2 al campo de columna2
        }
    }

    // Método llamado cuando se necesita crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Query1ViewHolder {
        // Define el diseño de los elementos de la vista
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_query1,parent,false)
        // Crea un nuevo objeto Query1ViewHolder con la vista inflada
        return Query1ViewHolder(view)
    }

    // Método que devuelve el número total de elementos en la lista
    override fun getItemCount(): Int {
        return query1.size
    }

    // Método llamado cuando RecyclerView necesita mostrar un elemento en una posición específica
    override fun onBindViewHolder(holder: Query1ViewHolder, position: Int) {
        val query1 = query1[position] // Obtiene el Query1 en la posición dada
        holder.bind(query1) // Llama a la función bind del ViewHolder para actualizar los campos de la vista con los datos del Query1
    }
}