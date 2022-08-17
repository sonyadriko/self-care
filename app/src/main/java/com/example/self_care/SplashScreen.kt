package com.example.self_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val buttonStarted = findViewById<Button>(R.id.buttonstarted);

        buttonStarted.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent);
        }
    }
}