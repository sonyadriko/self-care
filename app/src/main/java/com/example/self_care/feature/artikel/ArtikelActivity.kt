package com.example.self_care.feature.artikel

import android.R
import android.app.ActionBar
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.self_care.databinding.ActivityArtikelBinding
import com.example.self_care.domain.Artikel

class ArtikelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtikelBinding
    private var artikelData: Artikel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtikelBinding.inflate(layoutInflater)

//        val actionbar = supportActionBar
//        //set actionbar title
//        actionbar!!.title = "New Activity"
//        //set back button
//        actionbar.setDisplayHomeAsUpEnabled(true)
//        actionbar.setDisplayHomeAsUpEnabled(true)

//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        initBundle()
        initView()
        setContentView(binding.root)
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> {
//                finish()
//                return true
//            }
//        }
//        return super.onContextItemSelected(item)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            R.id.home -> onBackPressed()
//        }
//        return super.onOptionsItemSelected(item)
//    }

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