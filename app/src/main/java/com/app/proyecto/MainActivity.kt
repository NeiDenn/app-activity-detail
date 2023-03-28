package com.app.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.proyecto.adapter.ContactoAdapter
import com.app.proyecto.databinding.ActivityMainBinding
import com.app.proyecto.entity.Contacto
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    // Binding Global
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvContacto.adapter = ContactoAdapter(listaContactos()){contact ->

            // Mensaje De Confirmacion Para Continuar La Accion
            MaterialAlertDialogBuilder(this)
                .setTitle("confirmacion")
                .setMessage("Desea enviar el dato seleccionado?")
                .setPositiveButton("Aceptar") { _, _ ->

                    // Mensaje Recibido En La Consola
                    Log.i("ACT", "CLICK EN CONTACTO: ${contact.nombre}")
                    // Segun la accion te envia a otra activity
                    val next = Intent(this, DetalleActivity::class.java)
                    // enviar datos
                    next.putExtra("nombre", contact.nombre)
                    next.putExtra("correo", contact.correo)
                    next.putExtra("numero", contact.numero)
                    startActivity(next)}

                .setNeutralButton("Cancelar", null)
                .show()
        }
    }

    private fun listaContactos(): List<Contacto> {
        return listOf(
            Contacto("Lionel Messi", "Lionel@gmail.com", 934344854),
            Contacto("Erling Haaland", "Erling@gmail.com", 934344854),
            Contacto("Luis Mahrez", "Mahrez@gmail.com", 934344854),
            Contacto("Rose Ventura", "Rose@gmail.com", 934344854),
            Contacto("Darwin Nuñez", "Darwin@gmail.com", 934344854)
        )
    }
}