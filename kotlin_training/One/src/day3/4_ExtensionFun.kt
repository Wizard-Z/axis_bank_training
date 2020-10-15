package day3

class vehicle{
    fun run():String{
        return "Vehicle is running"
    }
}
fun vehicle.stop():String{
    return "Vehicle has stopped"
}
fun main() {
    val v = vehicle()
    println(v.run())
    println(v.stop())
}