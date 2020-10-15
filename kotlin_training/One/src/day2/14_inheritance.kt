package day2

open class Emp3(val name:String,val  age:Int,val  salary:Float)
{
    init{
        println("IN emp3")
        println("EmpName $name")
        println("EmpAge $age")
        println("EmpSalary $salary")
    }
}
open class Developer(name:String,age:Int,salary:Float,val project:String):Emp3(name,age,salary)
{
    init {
        println("In developer")
        println("My project is: $project")
    }
    fun out(){
        print("name: $name,age: $age, salary: $salary, project: $project")
    }

}
class salesPerson(name:String,age:Int,salary:Float,project:String,val bonus:Int):Developer(name,age, salary, project){
init {
    println("In salesPerson")
}
    fun outp(){
        print("Name: $name, Bonus: $bonus")
    }
}

fun main()
{
    val d=Developer("John",25,4000f,"Atrek")
    d.out()
    println()
    val dd = salesPerson("jony",33,5000f,"boug",20002)
    dd.outp()
}
