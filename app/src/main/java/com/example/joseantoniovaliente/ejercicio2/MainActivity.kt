package com.example.joseantoniovaliente.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.joseantoniovaliente.ejercicio2.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = ElementAdapter(elements) { element ->
                val gmmIntentUri = Uri.parse("geo:" + element.latitud + "," + element.longitud)
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                mapIntent.resolveActivity(packageManager)?.let {
                    startActivity(mapIntent)
                }

            }

        }

    }

    private val elements =
        listOf(
            Element("Osaka", "34.69374", "135.50218", "https://loremflickr.com/320/240/osaka"),
            Element(
                "Islas Maldivas",
                "3.202778",
                "73.22068",
                "https://loremflickr.com/320/240/maldives"
            ),
            Element("Petra", "30.32096", "35.47895", "https://loremflickr.com/320/240/petra"),
            Element(
                "Bahía de Kotor",
                "42.42067",
                "18.76825",
                "https://loremflickr.com/320/240/kotor"
            ),
            Element("París", "48.85341", "2.3488", "https://loremflickr.com/320/240/paris"),
            Element("Venecia", "45.43713", "12.33265", "https://loremflickr.com/320/240/venice")
        )


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

    }
}