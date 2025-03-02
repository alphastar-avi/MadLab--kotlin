package com.example.ex_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.FrameLayout
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout defined in activity_main.xml
        setContentView(R.layout.activity_main)

        // Find the container (FrameLayout) and add our custom view to it
        val frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        frameLayout.addView(DrawingView(this))
    }

    // Custom view class that handles drawing operations
    class DrawingView(context: Context) : View(context) {
        private val paint = Paint()

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            // Clear the canvas with a white background
            canvas.drawColor(Color.WHITE)

            // Draw a red circle at (150, 150) with a radius of 100 pixels
            paint.color = Color.RED
            canvas.drawCircle(550f, 300f, 100f, paint)

            // Draw a blue ellipse (oval) inside the rectangle defined by (300, 50) and (500, 200)
            paint.color = Color.BLUE
            canvas.drawOval(300f, 50f, 500f, 200f, paint)

            // Draw a green rectangle with the top-left corner at (100, 300) and bottom-right at (300, 500)
            paint.color = Color.GREEN
            canvas.drawRect(350f, 600f, 750f, 800f, paint)

            // Draw some black text at position (100, 600)
            paint.color = Color.BLACK
            paint.textSize = 60f
            canvas.drawText("Graphical Primitive", 350f, 900f, paint)

            paint.color = Color.RED
            paint.textSize = 50f
            canvas.drawText("DORITO", 490f, 1000f, paint)
        }
    }
}
