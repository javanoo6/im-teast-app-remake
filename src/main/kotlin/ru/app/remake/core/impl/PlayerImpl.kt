package ru.app.remake.core.impl

import ru.app.remake.core.Player

class PlayerImpl :Player{
    private val playerTablePoints:Set<TablePoint>
    private val playerTableShouting:Set<TablePoint>

constructor(playerTablePoints:Set<TablePoint>,playerTableShouting:Set<TablePoint>){
    this.playerTablePoints=playerTablePoints
    this.playerTableShouting=playerTableShouting
}

    override fun hit(): TablePoint {
        val hitPoint:TablePoint = playerTableShouting.random()
        println("player hits $hitPoint")
        return hitPoint
    }
}