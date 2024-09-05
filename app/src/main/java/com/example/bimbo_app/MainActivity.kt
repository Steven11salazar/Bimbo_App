package com.example.bimbo_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bimbo_app.ui.RegisterActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // El sigiente metodo sirve para  navegar de la pantalla de Login a la pantalla de Principal

        var goPrincipal = findViewById<Button>(R.id.go_to_principal)
        goPrincipal.setOnClickListener { goToPrincipal() }

        // El sigiente metodo sirve para  navegar de la pantalla de Login a la pantalla de Registro

        var goRegister = findViewById<TextView>(R.id.go_to_register)
        goRegister.setOnClickListener { goToRegister() }

    }
    private fun goToPrincipal(){
        val i = Intent(this,PantallaPrincipalActivity::class.java)
        startActivity(i)
    }
    private fun goToRegister(){
        val i = Intent(this,RegisterActivity::class.java)
        startActivity(i)
    }


}