package com.example.ex2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    private lateinit var etInput: EditText
    private var lastNumeric = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.etInput)
    }

    // Called when a digit or dot button is clicked
    fun onDigitClick(view: View) {
        etInput.append((view as Button).text)
        lastNumeric = true
    }

    // Called when an operator button (+, -, *, /, ^) is clicked
    fun onOperatorClick(view: View) {
        if (lastNumeric) {
            etInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    // Called when a function button (sin, cos, tan, √, log, ln) is clicked
    fun onFunctionClick(view: View) {
        if (lastNumeric) {
            val input = etInput.text.toString()
            val num = input.toDouble()
            val result = when ((view as Button).text.toString()) {
                "sin" -> sin(Math.toRadians(num))
                "cos" -> cos(Math.toRadians(num))
                "tan" -> tan(Math.toRadians(num))
                "√"   -> sqrt(num)
                "log" -> log10(num)
                "ln"  -> ln(num)
                else -> num
            }
            etInput.setText(result.toString())
            lastNumeric = true
        }
    }

    // Called when the clear button is clicked
    fun onClearClick(view: View) {
        etInput.setText("")
        lastNumeric = false
        lastDot = false
    }

    // Called when the equal button is clicked; evaluates arithmetic expressions
    fun onEqualClick(view: View) {
        try {
            val input = etInput.text.toString()
            val result = evaluateExpression(input)
            etInput.setText(result.toString())
        } catch (e: Exception) {
            etInput.setText("Error")
        }
    }

    // A very basic expression evaluator (supports only two operands per operator)
    private fun evaluateExpression(expression: String): Double {
        return when {
            expression.contains("+") -> {
                val parts = expression.split("+")
                parts[0].toDouble() + parts[1].toDouble()
            }
            expression.contains("-") -> {
                val parts = expression.split("-")
                // This simple evaluator does not support negative numbers as the first operand
                parts[0].toDouble() - parts[1].toDouble()
            }
            expression.contains("*") -> {
                val parts = expression.split("*")
                parts[0].toDouble() * parts[1].toDouble()
            }
            expression.contains("/") -> {
                val parts = expression.split("/")
                parts[0].toDouble() / parts[1].toDouble()
            }
            expression.contains("^") -> {
                val parts = expression.split("^")
                parts[0].toDouble().pow(parts[1].toDouble())
            }
            else -> expression.toDouble()
        }
    }
}
