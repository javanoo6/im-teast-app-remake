package ru.app.remake.core

import ru.app.remake.core.impl.PingPongTableImpl

interface Game {
    fun run(pingPongTable: PingPongTableImpl, playerOne: Player, playerTwo: Player)
}