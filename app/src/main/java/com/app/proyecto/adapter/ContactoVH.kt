package com.app.proyecto.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.proyecto.databinding.ItemContactoBinding
import com.app.proyecto.entity.Contacto

class ContactoVH (private val binding : ItemContactoBinding) : ViewHolder(binding.root) {

    fun completarInformacion(contacto: Contacto){
        binding.lblNombre.text = contacto.nombre
        binding.lblCorreo.text = contacto.correo
        binding.lblCelular.text = contacto.numero.toString()
    }
}