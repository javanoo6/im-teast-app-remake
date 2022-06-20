package ru.app.remake.core

import ru.app.remake.core.impl.PlayerImpl

interface Game {
    fun run(playerOne: PlayerImpl, playerTwo: PlayerImpl)
}