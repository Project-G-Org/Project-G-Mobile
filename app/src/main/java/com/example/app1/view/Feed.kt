package com.example.app1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1.R
import com.example.app1.databinding.ActivityMainBinding

class recover : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rec.setOnClickListener {

            val requestLogin = Intent(this,login::class.java)
            startActivity(requestLogin)
        }
    }
}