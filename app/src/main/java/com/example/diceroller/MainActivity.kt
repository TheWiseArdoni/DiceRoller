package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollButton.setOnClickListener{generate()}
    }
    fun generate(){
        val wallsNum = binding.wallsNum.text.toString().toInt()
        val diceNum = binding.diceNum.text.toString().toInt()
        val random = List(diceNum){ Random.nextInt(1,wallsNum+1)}
        val randomToString = random.toString()
        binding.textView.text = getString(R.string.roll_result, randomToString)
    }



}
