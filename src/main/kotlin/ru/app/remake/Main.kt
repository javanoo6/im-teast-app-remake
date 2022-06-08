package ru.app.remake

import ru.app.remake.core.impl.GameImpl
import ru.app.remake.core.impl.PingPongTableImpl
import ru.app.remake.core.impl.PlayerImpl

fun main() {
    val pingPongTable = PingPongTableImpl()
    val game = GameImpl()
    val playerOne = PlayerImpl(
            pingPongTable.getPlayerOneTablePoints(),
            pingPongTable.getPlayerOneTablePointsForShouting()
    )
    val playerTwo = PlayerImpl(
        pingPongTable.getPlayerTwoTablePoints(),
        pingPongTable.getPlayerTwoTablePointsForShouting()
    )
    game.run (pingPongTable,playerOne,playerTwo )
}