package ru.app.remake.core

import ru.app.remake.core.impl.TablePoint

interface Player {
    val name: String
    val score: Int
    fun hit():TablePoint
}