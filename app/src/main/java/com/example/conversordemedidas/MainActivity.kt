  package com.example.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

  class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComprimento = findViewById<ImageButton>(R.id.btnComprimento)
        btnComprimento.setOnClickListener {
            val intent = Intent(this, ActivityComprimento::class.java)
            startActivity(intent)
        }

        val btnDados = findViewById<ImageButton>(R.id.btnDados)
        btnDados.setOnClickListener {
            val intent = Intent(this, ActivityDados::class.java)
            startActivity(intent)
        }

        val btnTemperatura = findViewById<ImageButton>(R.id.btnTemperatura)
        btnTemperatura.setOnClickListener {
            val intent = Intent(this, ActivityTemperatura::class.java)
            startActivity(intent)
        }

        val btnPeso = findViewById<ImageButton>(R.id.btnPeso)
        btnPeso.setOnClickListener {
            val intent = Intent(this, ActivityPeso::class.java)
            startActivity(intent)
        }

    }
}
