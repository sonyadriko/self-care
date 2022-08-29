package com.example.self_care.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.self_care.R
import com.example.self_care.view.home.HomeActivity2

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
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent);
        }
    }
}