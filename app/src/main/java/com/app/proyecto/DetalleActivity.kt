package com.app.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.proyecto.databinding.ActivityDetalleBinding
import com.app.proyecto.databinding.ItemContactoBinding

class DetalleActivity : AppCompatActivity() {

    // Variable Global
    private lateinit var binding : ActivityDetalleBinding
    //
    private val TAG = "PAC"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // adecuar la configuracion
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        if(extras != null){
            val nombre = extras.getString("nombre")
            val correo = extras.getString("correo")
            val numero = extras.getInt("numero")

            binding.lblNombre.text = "Nombre Recibido: $nombre"
            binding.lblEmail.text = "Correo Recibido: $correo"
            binding.lblNumero.text = "Numero Recibido: $numero"
            Toast.makeText(this, "Detalle del usuario $nombre", Toast.LENGTH_LONG).show();
        }
    }
}