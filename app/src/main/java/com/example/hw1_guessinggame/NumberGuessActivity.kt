package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random


class NumberGuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)

    }
        var randomNumber: Int = Random.nextInt(1, 1000)
        var triesNumber: Int = 1
        var maxTries: Int = 0


    fun playGame(view: View) {

        val btnPlay = findViewById<Button>(R.id.btnPlay).setText("Play")
        val number = findViewById<EditText>(R.id.numberEdit).text.toString()
        if (number.equals("")) {
            Toast.makeText(this, "You did not enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        val guessedNumber = number.toInt()

        if(maxTries == 0){
        val tries = findViewById<EditText>(R.id.triesText).text.toString()
            if (tries.equals("")) {
                Toast.makeText(this, "You did not enter a number of attempts", Toast.LENGTH_SHORT).show();
                return;
            }
        maxTries = tries.toInt()
            if(maxTries ==0){
                Toast.makeText(this, "Not like that o.O, try somehitng above 0", Toast.LENGTH_SHORT).show();
                return;
            }
        }


            if (triesNumber < maxTries){
                if (guessedNumber > randomNumber) {
                    Toast.makeText(this, "Your number is too big", Toast.LENGTH_SHORT).show()
                } else if (guessedNumber < randomNumber) {
                    Toast.makeText(this, "Your number is too short", Toast.LENGTH_SHORT).show()
                } else if (guessedNumber == randomNumber) {
                    Toast.makeText(this, "You won! with "+triesNumber+" attempts", Toast.LENGTH_SHORT).show()
                    val btnPlay = findViewById<Button>(R.id.btnPlay).setText("Play Again")
                    randomNumber = Random.nextInt(1, 1000)
                    maxTries = 0
                    triesNumber=0
                    return
                }
                triesNumber++
            }else{
                Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT).show()
                val btnPlay = findViewById<Button>(R.id.btnPlay).setText("Play Again")
                randomNumber = Random.nextInt(1, 1000)
                maxTries = 0
                triesNumber=0
                return
            }

       //Toast.makeText(this, "number is " + randomNumber, Toast.LENGTH_SHORT).show()
        }



}



