package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Double1

class ActivityComprimento : AppCompatActivity() {


    var unidades = arrayOf("Milimetro (mm)", "Centimetro (cm)", "Metro (m)", "quilometro (km)")
    var selecao : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprimento)

        // carregar os elementos da minha tela
        val spinner = findViewById<Spinner>(R.id.select)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,  id: Long) {
                selecao = position
            }
        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()

            if (valor != "") {
                if (selecao == 0) {
                    var texto = "Centimetro"
                    texto += Double.parseDouble(valor) / 10f
                    texto += "cm \nMetro = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "m \nQuilometro = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "km"

                    txtResultado.text = texto
                } else if (selecao == 1) {
                    var texto = "Milimetro"
                    texto += Double.parseDouble(valor) * 10f
                    texto += "mm \nMetro = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "m \nQuilometro = "
                    texto += Double.parseDouble(valor) / 100000f
                    texto += "km"

                    txtResultado.text = texto
                } else if (selecao == 2) {
                    var texto = "Milimetro"
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "mm \nCentimetro = "
                    texto += Double.parseDouble(valor) * 100f
                    texto += "cm \nQuilometro = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "km"

                    txtResultado.text = texto
                } else if (selecao == 3) {
                    var texto = "Milimetro"
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += "mm \nCentimetro = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "cm \nQuilometro = "
                    texto += Double.parseDouble(valor) / 100000f
                    texto += "km"

                    txtResultado.text = texto
                } else {
                    txtResultado.text = "Unidade selecionada não existe em nosso banco."
                }
            } else {
                txtResultado.text = "Adicione um valor para ser convertido"
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?) : Boolean {

        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
