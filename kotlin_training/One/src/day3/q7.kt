package day3

import java.util.*
import javax.print.attribute.IntegerSyntax

//Using Lambda function calculate the Simple Interest(p*t*r/100)
fun main() {
    val read = Scanner(System.`in`)
    println("Enter..")
    println("Principal..")
    val p = Integer.parseInt(read.nextLine())
    println("Rate..")
    val r = Integer.parseInt(read.nextLine())
    println("time..")
    val t = Integer.parseInt(read.nextLine())
    println("Interest ${p*r*t/100}")

}