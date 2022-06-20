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
        "игрокНомерОдин", 0
    )
    val playerTwo = PlayerImpl(
        pingPongTable.playerTwoTablePoints,
        pingPongTable.playerTwoTablePointsForShouting,
        "ИгрокНомерДва", 0
    )
    game.run(playerOne, playerTwo)
}