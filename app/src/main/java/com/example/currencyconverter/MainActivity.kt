package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.text.NumberFormat
import kotlin.math.round


class MainActivity : AppCompatActivity() {

    fun convertCurrency(view : View) {
        val nf = NumberFormat.getInstance()
        Log.i("Info" , "Button Pressed")
        val amountInGBP = findViewById<EditText>(R.id.editText)
        val amountInINR = nf.parse(amountInGBP.text.toString()).toDouble() * 92.43
        //amountInINR = round(92.43);
        Log.i("Info" , "ConvertedAmount${amountInGBP.text}")
        Toast.makeText(this, "£${amountInGBP.text}"+" is ₹"+amountInINR, Toast.LENGTH_LONG).show()

    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 1000 }
        return round(this * multiplier) / multiplier
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
