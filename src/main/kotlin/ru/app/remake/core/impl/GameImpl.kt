package ru.app.remake.core.impl

import ru.app.remake.core.Game
import ru.app.remake.core.Player

class GameImpl : Game {

    companion object {
       const val MAXIMUM_GAME_POINT = 11
    }

    var firstPlayerScore = 0
    var secondPlayerScore = 0
    var isGameOver = false
    var turnCounter = 1

    override fun run(pingPongTable: PingPongTableImpl, playerOne: Player, playerTwo: Player) {
        println("PING PONG GAME BEGINS")
        println("this is $turnCounter turn")
        while (firstPlayerScore < MAXIMUM_GAME_POINT || secondPlayerScore < MAXIMUM_GAME_POINT) {
            playerMove(playerOne, pingPongTable)
            playerMove(playerTwo, pingPongTable)
            if (isGameOver) break
            println()
        }
        getWinner()
    }

    private fun playerMove(player: Player, pingPongTable: PingPongTableImpl) {
        println("сейчас ходит ${player.name}")
        val hit = player.hit()
        if (player.name.contains("One")) {
            if (pingPongTable.playerTwoTablePoints.contains(hit)) {
                println("playerOne hits opponent's table-> game continues")
                return
            } else {
                println("${player.name} missed the table, playerTwo gets plus point")
                turnCounter++
                secondPlayerScore++
                getPlayersScore()
                checkIfGameIsFinished()
                println("this is $turnCounter turn")
            }
        }
        if (player.name.contains("Two")) {
            if (pingPongTable.playerOneTablePoints.contains(hit)) {
                println("playerTwo hits opponent's table-> game continues")
                return
            } else {
                println("${player.name} missed the table, playerOne gets plus point")
                turnCounter++
                firstPlayerScore++
                getPlayersScore()
                checkIfGameIsFinished()
                println("this is $turnCounter turn")
            }
        }
    }

    private fun checkIfGameIsFinished() {
        if (firstPlayerScore == MAXIMUM_GAME_POINT) isGameOver = true
        if (secondPlayerScore == MAXIMUM_GAME_POINT) isGameOver = true
    }

    private fun getPlayersScore() {
        println("current score is \n playerOne score: $firstPlayerScore \n playerTwo score : $secondPlayerScore")
    }

    private fun getWinner() {
        if (firstPlayerScore > secondPlayerScore) {
            println("playerOne is the Winner")
        } else {
            println("playerTwo is the Winner")
        }
    }
}

