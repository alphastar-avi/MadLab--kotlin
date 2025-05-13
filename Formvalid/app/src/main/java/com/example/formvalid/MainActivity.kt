package com.example.formvalid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var IT = findViewById<EditText>(R.id.inputname)
        var PA = findViewById<EditText>(R.id.pass)
        var login = findViewById<Button>(R.id.login)
        var clear = findViewById<Button>(R.id.clear)

        login.setOnClickListener {
            var username = IT.text.toString()
            var pin = PA.text.toString()
            
            if (username.matches(Regex("^[a-zA-Z]+$")) && pin.matches(Regex("^[0-9]+$"))) {
                var intent = Intent(this, pg2::class.java)
                startActivity(intent)
            }
        }

        clear.setOnClickListener{
            PA.text.clear()
            IT.text.clear()
        }


    }
}