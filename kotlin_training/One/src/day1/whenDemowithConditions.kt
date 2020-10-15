package day1

import java.util.*

/*
Accept day  no and if 1,3,5 allowed to buy movie ticket else not.
Use when to solve it
 */
fun main() {
    val read = Scanner(System.`in`)
    println("Enter week day to buy ticket")
    var dnum = read.nextInt()
    var result=when(dnum){
        1,3,5 -> "Ticket can be bought mon/wed/fri"
        2,4,6,7 -> "Ticket cannot be bought on tue/thu/sat/sat"
        else -> "No ticket.. Invalid Date"
    }
    println(result)

}