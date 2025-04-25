package com.example.tipcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.tipcalc.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val inputText = binding.costOfService.text.toString()
        val cost = inputText.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            binding.costOfService.error = "Masukkan angka yang valid"
            Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
            binding.tipResult.text = ""
            return
        }

        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPersen = when (selectedId) {
            R.id.option_ten_percent -> 0.2
            R.id.option_seven_percent -> 0.18
            else -> 0.15
        }

        var tip = cost * tipPersen
        if (binding.roundTip.isChecked) {
            tip = ceil(tip)
        }

        val currency = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, currency)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tip_result", binding.tipResult.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredTip = savedInstanceState.getString("tip_result")
        binding.tipResult.text = restoredTip
    }
}