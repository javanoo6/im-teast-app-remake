package ru.app.remake.core.impl

import ru.app.remake.core.Game
import ru.app.remake.core.Player

class GameImpl : Game {

    companion object {
        val MAXIMUM_GAME_POINT = 11
    }

    var firstPlayerScore = 0
    var secondPlayerScore = 0
    var isGameOver = false
    var turnCounter = 1

    override fun run(pingPongTable: PingPongTableImpl, playerOne: Player, playerTwo: Player) {
        println("PING PONG GAME BEGINS")
        while (firstPlayerScore < MAXIMUM_GAME_POINT || secondPlayerScore < MAXIMUM_GAME_POINT) {
            println("this is $turnCounter turn")
            playerOneMove(playerOne, pingPongTable)
            if(isGameOver) break
            playerTwoMove(playerTwo, pingPongTable)
            if(isGameOver) break
            turnCounter++
            println()
        }
        getWinner()
    }

    private fun playerOneMove(playerOne: Player, pingPongTable: PingPongTableImpl) {
        println("playerOne's turn: ")
        val playerOneHit = playerOne.hit()
        if (pingPongTable.getPlayerTwoTablePoints().contains(playerOneHit)) {
            println("playerOne hits opponent's table-> game continues")
        } else {
            println("playerOne missed the table, playerTwo gets plus point")
            secondPlayerScore++
            getPlayersScore()
            checkIfGameIsFinished()
        }


    }

    private fun playerTwoMove(playerTwo: Player, pingPongTable: PingPongTableImpl) {
        println("playerTwo's turn")
        val playerTwoHit = playerTwo.hit()
        if (pingPongTable.getPlayerOneTablePoints().contains(playerTwoHit)) {
            println("playerTwo hits opponent's table-> game continues")
        } else {
            println("playerTwo missed the table, playerOne gets plus point")
            firstPlayerScore++
            getPlayersScore()
            checkIfGameIsFinished()

        }
    }


    private fun checkIfGameIsFinished() {
        if (firstPlayerScore==MAXIMUM_GAME_POINT) isGameOver=true
        if (secondPlayerScore==MAXIMUM_GAME_POINT) isGameOver=true
    }

    private fun getPlayersScore() {
       println("current score is \n playerOne score: $firstPlayerScore \n playerTwo score : $secondPlayerScore")
    }

    private fun getWinner() {
        if(firstPlayerScore>secondPlayerScore){
            println("playerOne is the Winner")
        }else{
            println("playerTwo is the Winner")
        }
    }
}