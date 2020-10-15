package day1

fun main() {
    var number = 25
    var result = Math.sqrt(number.toDouble());
    println("$number root is $result")

    result = Sum(5.1,6.toDouble())
    println("Addition result: $result")
}
fun Sum(n1:Double, n2:Double):Double{
    //var s=n1+n2;
    return n1+n2
}