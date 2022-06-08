package ru.app.remake.core.impl

class TablePoint {
    val x:Int
    val y: Int
    constructor(x:Int, y:Int){
        this.x=x
        this.y=y
    }


    override fun toString(): String {
        return "TablePoint(x=$x, y=$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TablePoint) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }


}