package day3

fun main() {
    var x=12
    var y=0
    try {
        println("Division Result, "+x/y)
    }catch (e:ArithmeticException){
        println("Some Error /0 ${e.message}")
    }
    println("Rest of the code......")
}