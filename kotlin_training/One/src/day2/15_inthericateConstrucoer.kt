package day2


open class Emp5
{
    constructor(name:String, age:Int, salary:Float){
        println("EmpName ${name}")
        println("EmpAge ${age}")
        println("EmpSalary ${salary}")
    }
}
open class Developer2 :Emp5
{

    constructor(name:String,age:Int,salary:Float,project:String):super(name,age,salary){
        println("Emp Project ${project}")
    }
}

class SalesPerson1:Developer2
{
    constructor(name:String,age:Int,salary:Float,project:String,bonus:Float):super(name,age,salary,project){
        println("EMp Bonus is ${bonus}")
    }
}

fun main(args:Array<String>)
{
    val d=SalesPerson1("John",25,4000f,"Website", bonus=10000f)

}
