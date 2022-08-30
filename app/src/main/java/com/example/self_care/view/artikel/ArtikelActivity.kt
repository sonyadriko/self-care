package com.example.self_care.view.artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.self_care.R
import com.example.self_care.domain.Artikel
import org.w3c.dom.Text
import java.lang.Exception

class ArtikelActivity : AppCompatActivity() {
    private lateinit var artikelData : Artikel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBundle()
        initView()

        setContentView(R.layout.activity_artikel)


    }

    private fun initView() {
        try {
            val image = findViewById<ImageView>(R.id.image_artikel)
            val heading = findViewById<TextView>(R.id.heading_artikel)
            val content = findViewById<TextView>(R.id.news_artikel)

            image.setImageResource(artikelData.titleImage)
            heading.setText(artikelData.heading)
            content.setText(artikelData.content)

        }catch (e:Exception){
            e.message?.let { Log.d("kosong", artikelData.titleImage.toString()) }
            Toast.makeText(this, "terjadi kesalahan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun initBundle() {
        if (intent.hasExtra("heading")) {
            val extra = intent.extras?.get("heading")
            artikelData = extra as Artikel
//            Toast.makeText(this, extra.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}