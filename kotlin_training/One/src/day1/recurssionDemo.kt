package day1
var count=0
fun rec(){
    if(count<=5){
        println("The count is "+ count++)
        rec()
        }
}
fun factorial(n:Int):Long{
    return if(n==1)
        1
    else
        n*factorial(n-1)
}
fun main() {
    rec();
    var number = 120
    var x = factorial(number);
    println("$number factorial is $x")

}