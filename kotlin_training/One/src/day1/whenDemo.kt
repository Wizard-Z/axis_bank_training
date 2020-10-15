package day1

import java.util.*
/*
WHEN SYNTAX
 */
fun main() {
    println("Number to days")
    val read = Scanner(System.`in`)
    println("Enter week day")
    var day = read.nextInt()
    var wDay=when(day){
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else ->"Invalid Input"
    }
    println("Day no: $day and dayname: $wDay")

}