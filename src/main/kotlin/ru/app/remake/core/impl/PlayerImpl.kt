package ru.app.remake.core.impl

import ru.app.remake.core.Player

class PlayerImpl(
    private val playerTablePoints: Set<TablePoint>,
    private val playerTableShouting: Set<TablePoint>,
    override val name: String
) : Player {
    override fun hit(): TablePoint {
        val hitPoint: TablePoint = playerTableShouting.random()
        println("player hits $hitPoint")
        return hitPoint
    }
}