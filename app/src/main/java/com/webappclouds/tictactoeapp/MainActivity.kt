package com.webappclouds.tictactoeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClick(view: View){

        val butSelected = view as Button

        var cellId = 0;
        when(butSelected.id){
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9
        }
//        Toast.makeText(this, "Button Pressed: $cellId", Toast.LENGTH_LONG).show()

        playGame(cellId,butSelected)
    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, butSelect:Button){

        if (activePlayer == 1) {
            butSelect.text = "X"
            butSelect.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
        } else {
            butSelect.text = "O"
            butSelect.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1
        }

        butSelect.isEnabled = false

        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        // Player 1 Rows
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        // Player 1 Columns
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        // Player 1 X's
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }


        // Player 2 Rows
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        // Player 2 Columns
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }
        // Player 2 X's
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        if(winner == 1){

            Toast.makeText(this,"Player 1 is the winner", Toast.LENGTH_LONG).show()

        } else if (winner == 2){

            Toast.makeText(this,"Player 2 is the winner", Toast.LENGTH_LONG).show()

        }
    }
}
