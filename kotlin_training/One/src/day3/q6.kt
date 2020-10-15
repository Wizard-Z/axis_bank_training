package day3

import java.util.*

/*
 Using TailRec compute factorial of the given number.
 Keep the number as < 50
 */
fun main() {
    println("Factorials!!\n Enter <50")
    val read = Scanner(System.`in`)
    val num = read.nextInt()
    println(if(num<50) cal_fact(num) else "Invalid Input")
}fun cal_fact(num:Int):Long{
    return if(num==1) 1 else num* cal_fact(num-1)

}