package com.example.self_care.feature.artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.self_care.databinding.ActivityArtikelBinding
import com.example.self_care.domain.Artikel
import java.lang.Exception

class ArtikelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtikelBinding
    private var artikelData: Artikel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtikelBinding.inflate(layoutInflater)

        initBundle()
        initView()
        setContentView(binding.root)
    }

    private fun initBundle() {
        if (intent.hasExtra("heading")) artikelData = intent.extras?.get("heading") as Artikel
    }

    private fun initView() = binding.apply {
        try {
            imageArtikel.setImageResource(artikelData!!.titleImage)
            headingArtikel.setText(artikelData!!.heading)
            newsArtikel.setText(artikelData!!.content)
        } catch (e: Exception) {
            Toast.makeText(this@ArtikelActivity, "terjadi kesalahan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}