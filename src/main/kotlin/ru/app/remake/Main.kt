package ru.app.remake

import ru.app.remake.core.impl.GameImpl
import ru.app.remake.core.impl.PingPongTableImpl
import ru.app.remake.core.impl.PlayerImpl

fun main() {
    val pingPongTable = PingPongTableImpl()
    val game = GameImpl()
    val playerOne = PlayerImpl(
        pingPongTable.playerOneTablePoints,
        pingPongTable.playerOneTablePointsForShouting,
        "playerNumberOne"
    )
    val playerTwo = PlayerImpl(
        pingPongTable.playerTwoTablePoints,
        pingPongTable.playerTwoTablePointsForShouting,
        "playerNumberTwo"
    )
    game.run(pingPongTable, playerOne, playerTwo)
}