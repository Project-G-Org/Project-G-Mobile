package com.example.app1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app1.databinding.ActivityMainBinding
import com.example.app1.view.Feed
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonF.setOnClickListener{

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            when{
                email.isEmpty() -> {
                    mensagem(it,"coloque o seu email")
                }
                password.isEmpty() -> {
                    mensagem(it,"coloque sua senha")
                }
                password.length <=5 -> {
                    mensagem(it,"senha muito fraca")
                }

                else -> {
                    navegarF(email)
                }

            }

        }

    }

    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000)"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))

    }

    private fun navegarF(email: String){
        val intent = Intent(this, Feed::class.java)
        intent.putExtra("email",email)
        startActivity(intent)
    }

}