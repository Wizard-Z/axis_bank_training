package assignment_1

fun MutableMap<String,Double?>.simpleInterst(rate:Int,time:Int)
        :Double?=(this["Principle"]?.times(rate)?.times(time))?.div(100)

fun main() {
    var p: MutableMap<String, Double?> = mutableMapOf()
    println("Enter principle")
    p["Principle"] = readLine()?.toDouble()
    println("Interest is: "+p.simpleInterst(5,12))

}
