package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private var dice1Value = 0
    private var dice2Value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diceImage1.setImageResource(R.drawable.dice_0)
        binding.diceImage2.setImageResource(R.drawable.dice_0)

        savedInstanceState?.let {
            dice1Value = it.getInt("DICE1")
            dice2Value = it.getInt("DICE2")
            updateDiceImages()
        }

        binding.buttonRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice(){
        dice1Value = (1..6).random()
        dice2Value = (1..6).random()
        updateDiceImages()

        val message = if (dice1Value == dice2Value){
            "Selamat anda dapat dadu double!"
        } else{
            "Anda belum beruntung!"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun updateDiceImages(){
        binding.diceImage1.setImageResource(getDiceImage(dice1Value))
        binding.diceImage2.setImageResource(getDiceImage(dice2Value))
    }

    private fun getDiceImage(value: Int): Int{
        return when (value){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("DICE1", dice1Value)
        outState.putInt("DICE2", dice2Value)
    }
}