package com.example.sd_card

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

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
        var reg = findViewById<EditText>(R.id.reg)
        var name = findViewById<EditText>(R.id.name)
        var cgpa=  findViewById<EditText>(R.id.cgpa)
        var save = findViewById<Button>(R.id.save)
        var load = findViewById<Button>(R.id.load)



        save.setOnClickListener{
            var regester = reg.text.toString()
            var username = name.text.toString()
            var cgpaa =  cgpa.text.toString()
            var file = File(getExternalFilesDir(null),"tt.txt")
            var outstream = FileOutputStream(file, false)
            outstream.write("$regester, $username, $cgpaa".toByteArray())
            outstream.close()
            reg.text.clear()
            name.text.clear()
            cgpa.text.clear()
        }
        load.setOnClickListener{
            var file = File( getExternalFilesDir(null), "tt.txt")
            var inputStream = FileInputStream(file)
            var inputStreamReader = InputStreamReader(inputStream)
            var bufferedReader =  BufferedReader(inputStreamReader)
            var line: String = bufferedReader.readLine()
            var parts = line.split(",")
            reg.setText(parts[0])
            name.setText(parts[1])
            cgpa.setText((parts[2]))


        }


    }
}