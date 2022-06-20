package ru.app.remake.core.impl

import ru.app.remake.core.Player

class PlayerImpl(
    val playerTablePoints: Set<TablePoint>,
    private val playerTableShouting: Set<TablePoint>,
    override val name: String,
    override var score: Int
) : Player {
    override fun hit(): TablePoint {
        return playerTableShouting.random()
    }
}