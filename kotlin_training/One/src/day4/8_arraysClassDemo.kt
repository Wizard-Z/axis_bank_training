package day4

import java.util.*
import kotlin.collections.ArrayList

data class Emp1(val empId:Int,val empName:String,val empSal:Double)

fun main() {
    val read = Scanner(System.`in`)
    println("Enter No. of Emps.")
    var count = read.nextInt()
    var array:MutableList<Emp1> =  mutableListOf<Emp1>()
    var empId:Int
    var empName:String
    var empSal:Double
    while(count>0){
        println("ENTER details of employee")
        println("EMPID:")
        empId=read.nextInt()
        read.nextLine()
        println("EMPNAME:")
        empName = read.nextLine()
        println("EMPSAL:")
        empSal=read.nextDouble()
        read.nextLine()
        array.add(Emp1(empId,empName,empSal))
        count--
    }
    println("Showing emps\n $array")

}