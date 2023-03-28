package com.app.proyecto.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.app.proyecto.databinding.ItemContactoBinding
import com.app.proyecto.entity.Contacto

class ContactoAdapter(val lista: List<Contacto>, val click : (Contacto) -> Unit) : Adapter<ContactoVH>() {

    // for create a object que hace referenia al layout (VH)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoVH {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactoVH(binding)
    }

    // Devuelve un object y una posicion
    override fun onBindViewHolder(holder: ContactoVH, position: Int) {
        val unContacto = lista[position]

        // listContacto
        holder.completarInformacion(unContacto)
        // other
        holder.itemView.setOnClickListener{
            Log.i("ADA", "CLICK EN: ${unContacto.nombre}")
            // invocar funcion
            click(unContacto)
        }
    }

    // retornar un valor entero
    override fun getItemCount(): Int {
        return lista.size
    }

}