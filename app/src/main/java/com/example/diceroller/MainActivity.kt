package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val diceList: MutableList<String> = mutableListOf()
    private val wallsList: MutableList<Int> = mutableListOf()
    private val diceAmountList: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollButton.setOnClickListener{generate()}
        binding.addDiceButton.setOnClickListener{addDice()}
        binding.clearButton.setOnClickListener{clearList()}
    }
    private fun generate(){
        val rollResultList: MutableList<String> = mutableListOf()
        for (item in diceAmountList.indices) {
            val random = List(diceAmountList[item]){Random.nextInt(1, wallsList[item]+1)}
            rollResultList.add(random.joinToString(prefix = "", separator = " ", postfix = ""))
        }
        if (rollResultList.size != 0){
            binding.rollResult.text = rollResultList.joinToString(prefix = "", separator = " ", postfix = "")
        }else
            Toast.makeText(applicationContext, getString(R.string.noDiceToast), Toast.LENGTH_SHORT).show()
    }
    private fun addDice(){
        val wallsAmt = binding.wallsNum.text.toString()
        val diceAmt = binding.diceNum.text.toString()
        val diceNotation: String = (diceAmt + "D" + wallsAmt)
        diceList.add(diceNotation)
        wallsList.add(wallsAmt.toInt())
        diceAmountList.add(diceAmt.toInt())
        binding.diceList.text = diceList.joinToString(prefix = "", separator = "\n", postfix = "")
    }
    private fun clearList(){
        if(diceList.size and wallsList.size and diceAmountList.size != 0) {
            diceList.removeLast()
            wallsList.removeLast()
            diceAmountList.removeLast()
        }else{
            Toast.makeText(applicationContext, getString(R.string.noDiceToast), Toast.LENGTH_SHORT).show()
        }
        binding.diceList.text = diceList.joinToString(prefix = "", separator = "\n", postfix = "")
    }
}
