package com.example.self_care.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.self_care.R
import com.example.self_care.databinding.ActivityHome2Binding
import com.example.self_care.view.artikel.ArtikelFragment
import com.example.self_care.view.profile.ProfileFragment

class HomeActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.artikel -> replaceFragment(ArtikelFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else -> {

                }
            }
            true
        }
        // do your works here
        // binding.bottomNavigationView
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}