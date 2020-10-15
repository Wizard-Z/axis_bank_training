package day2

class emp33(val eid:Int,val name:String,val city:String){
    constructor(eid:Int,name:String):this(eid,name,"default")
    {
        println("const1:::Eid: $eid,  name: $name")
    }

    constructor(eid:Int):this(eid,"DefaultN","defaultC")
    {
        println("const2:::Eid: $eid")
    }

    fun out(){
        println("Eid: $eid, city: $city, name: $name")
    }


}

fun main() {
    var e = emp33(12)
    e.out()
    var e1 = emp33(city = "mycity",name="myName",eid = 32)
    e1.out()
    var e3 = emp33(1,"2314","mycity")
    e3.out()


}