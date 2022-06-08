package ru.app.remake.core

import ru.app.remake.core.impl.TablePoint

interface PingPongTable {
    fun getAllTablePoints():Set<TablePoint>
    fun getPlayerOneTablePoints():Set<TablePoint>
    fun getPlayerTwoTablePoints():Set<TablePoint>
    fun getPlayerOneTablePointsForShouting():Set<TablePoint>
    fun getPlayerTwoTablePointsForShouting():Set<TablePoint>
}