package com.example.self_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textsignup = findViewById<TextView>(R.id.textsignup);
        val withoutlogin = findViewById<TextView>(R.id.withoutlogin);

        textsignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent);
        }
        withoutlogin.setOnClickListener{
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent);
        }
    }
}