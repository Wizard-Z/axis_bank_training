package day2

class emp1(city:String){
    var ename:String=""
    var city:String=""
    var id:Int=-1
    constructor(id:Int,ename:String,city:String):this(city){
        this.ename=ename
        this.id = id
        this.city=city
        println("city is$city")
        println("name: $ename, city: $city, id: $id")

    }
    fun out(){
        println("In out::name: $ename, city: $city, id: $id")
    }
}

fun main() {
    val e = emp1(12,"hello","Delhi")
    e.out()
}