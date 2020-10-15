package day1

fun main(){
    var x=10;
    var y:Double=x.toDouble()
    println("The integer is $x\nThe long value is $y")
    y =20.2
    println("y=%.4f".format(y))
    x=y.toInt();
    println("The converted\nX=$x\nY=$y")
}