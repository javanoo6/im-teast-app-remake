package ru.app.remake.core.impl

import ru.app.remake.core.PingPongTable

class PingPongTableImpl : PingPongTable {
    private val tablePoints: Set<TablePoint>
    private val playerOneTablePoints: Set<TablePoint>
    private val playerTwoTablePoints: Set<TablePoint>
    private val playerOneTablePointsForShouting: Set<TablePoint>
    private val playerTwoTablePointsForShouting: Set<TablePoint>
    companion object{
        private val TABLE_SIZE_IN_POINTS = 10
        private val LEFT_TOP_POINT = TablePoint(1, 1)
    }


    init {
        tablePoints = buildTablePoints(LEFT_TOP_POINT, TABLE_SIZE_IN_POINTS, TABLE_SIZE_IN_POINTS)
        playerOneTablePoints = buildTablePoints(TablePoint(3, 2), 6, 4)
        playerTwoTablePoints = buildTablePoints(TablePoint(3, 6), 6, 4)
        playerOneTablePointsForShouting = getPointsForShouting(tablePoints, playerOneTablePoints)
        playerTwoTablePointsForShouting = getPointsForShouting(tablePoints, playerTwoTablePoints)
    }

    private fun getPointsForShouting(
        tablePoints: Set<TablePoint>,
        tablePointsToExclude: Set<TablePoint>
    ): Set<TablePoint> {
        val pointsForShouting: MutableSet<TablePoint> = HashSet(tablePoints)
        pointsForShouting.removeAll(tablePointsToExclude)
        println("Player points for Shouting $pointsForShouting")
        return pointsForShouting
    }

    private fun buildTablePoints(
        leftTopPoint: TablePoint,
        tableSizeInPointsByX: Int,
        tableSizeInPointsByY: Int
    ): Set<TablePoint> {
        val tablePoints: MutableSet<TablePoint> = HashSet()
        for (i in leftTopPoint.x until leftTopPoint.x + tableSizeInPointsByX) {
            for (j in leftTopPoint.y until leftTopPoint.y + tableSizeInPointsByY) {
                tablePoints.add(TablePoint(i, j))
            }
        }
        println("Created tablePoints $tablePoints")
        return tablePoints
    }

    override fun getAllTablePoints(): Set<TablePoint> {
        return tablePoints
    }

    override fun getPlayerOneTablePoints(): Set<TablePoint> {
        return playerOneTablePoints
    }

    override fun getPlayerTwoTablePoints(): Set<TablePoint> {
        return playerTwoTablePoints
    }

    override fun getPlayerOneTablePointsForShouting(): Set<TablePoint> {
        return playerOneTablePointsForShouting
    }

    override fun getPlayerTwoTablePointsForShouting(): Set<TablePoint> {
        return playerTwoTablePointsForShouting

    }

}