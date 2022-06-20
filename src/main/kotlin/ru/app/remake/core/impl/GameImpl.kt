package ru.app.remake.core.impl

import ru.app.remake.core.Game

class GameImpl : Game {

    companion object {
        const val MAXIMUM_GAME_POINT = 11
    }

    private var isGameOver = false

    override fun run(playerOne: PlayerImpl, playerTwo: PlayerImpl) {
        println("ИГРА ПИНГ-ПОНГ")
        while (playerOne.score < MAXIMUM_GAME_POINT || playerTwo.score < MAXIMUM_GAME_POINT) {
            playerMove(playerOne, playerTwo)
            if (isGameOver) break
            playerMove(playerTwo, playerOne)
            if (isGameOver) break
        }
        getWinner(playerOne, playerTwo)
    }

    private fun playerMove(playerFirst: PlayerImpl, playerSecond: PlayerImpl) {

        val hit = playerFirst.hit()
        println("\nсейчас ходит ${playerFirst.name} и попадает по $hit")
        if (playerSecond.playerTablePoints.contains(hit)) {
            println("${playerFirst.name} попадает по столу соперника -> игра продолжается")
        } else {
            println("${playerFirst.name} промахнулся, ${playerSecond.name} получает + 1 балл")
            playerSecond.score++
            getOverAllGameInfo(playerFirst, playerSecond)
        }
    }

    private fun getOverAllGameInfo(playerFirst: PlayerImpl, playerSecond: PlayerImpl) {
        println(
            "предварительный счет:" +
                    "\nсчет участника: ${playerFirst.name} - ${playerFirst.score}" +
                    "\nсчет участника: ${playerSecond.name} - ${playerSecond.score}"
        )
        if (playerFirst.score == MAXIMUM_GAME_POINT || playerSecond.score == MAXIMUM_GAME_POINT) isGameOver = true


    }


    private fun getWinner(playerOne: PlayerImpl, playerTwo: PlayerImpl) {
        if (playerOne.score > playerTwo.score) {
            println("\n${playerOne.name} победил")
        } else {
            println("\n${playerTwo.name} победил")
        }
    }
}

