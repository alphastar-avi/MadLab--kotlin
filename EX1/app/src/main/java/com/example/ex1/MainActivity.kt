package com.example.ex1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Arrays to loop through
    private val fonts = arrayOf(Typeface.DEFAULT, Typeface.MONOSPACE, Typeface.SERIF, Typeface.SANS_SERIF)
    private val fontColors = arrayOf(Color.BLACK, Color.RED, Color.BLUE, Color.GREEN)
    private val bgColors = arrayOf(Color.WHITE, Color.YELLOW, Color.CYAN, Color.LTGRAY)

    // Indexes to keep track of the current selection
    private var fontIndex = 0
    private var fontColorIndex = 0
    private var bgColorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val changeFontButton = findViewById<Button>(R.id.changeFontButton)
        val changeFontColorButton = findViewById<Button>(R.id.changeFontColorButton)
        val changeBgColorButton = findViewById<Button>(R.id.changeBgColorButton)

        // Loop through fonts
        changeFontButton.setOnClickListener {
            fontIndex = (fontIndex + 1) % fonts.size
            textView.typeface = fonts[fontIndex]
        }

        // Loop through font colors
        changeFontColorButton.setOnClickListener {
            fontColorIndex = (fontColorIndex + 1) % fontColors.size
            textView.setTextColor(fontColors[fontColorIndex])
        }

        // Loop through background colors
        changeBgColorButton.setOnClickListener {
            bgColorIndex = (bgColorIndex + 1) % bgColors.size
            textView.setBackgroundColor(bgColors[bgColorIndex])
        }
    }
}
