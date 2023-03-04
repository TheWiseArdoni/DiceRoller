package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollButton.setOnClickListener{generate()}
        binding.addDiceButton.setOnClickListener{addDice()}
    }
    private fun generate(){
        val wallsNum = binding.wallsNum.text.toString().toInt()
        val diceNum = binding.diceNum.text.toString().toInt()
        val random = List(diceNum){ Random.nextInt(1,wallsNum+1)}
        val randomToString = random.toString()
        binding.rollResult.text = randomToString
    }
    private fun addDice(){
        val wallsAmt = binding.wallsNum.text.toString()
        val diceAmt = binding.diceNum.text.toString()
        val diceNotation: String = (diceAmt + "D" + wallsAmt)
        binding.diceList.text = diceNotation
    }
}
