package ru.app.remake.core.impl

class TablePoint {
    var x:Int
    var y: Int
    constructor(x:Int, y:Int){
        this.x=x
        this.y=y
    }

    override fun toString(): String {
        return "TablePoint(x=$x, y=$y)"
    }


}