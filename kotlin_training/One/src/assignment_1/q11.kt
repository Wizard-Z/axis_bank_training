package assignment_1

import java.util.*

sealed class Cars{
    class Maruti:Cars()
    class Hyundai:Cars()
    class Honda:Cars()
}

fun main() {
    println("Enter type of car..Maruti/Hyundai/Honda")
    val read = Scanner(System.`in`)
    val inp=read.nextLine()
    when(inp.toLowerCase()){
        "maruti" -> println("Indian Make")
        "hyundai" -> println("Korean Make")
        "honda" -> println("Japan Make")
        else -> println("Wrong choice")
    }
}