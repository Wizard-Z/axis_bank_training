package day3

data class Employee(val empId:Int, val empName: String ="Not Entered", val empEmail: String ="Not Provided")


fun main(args:Array<String>)
{
    val e1=Employee(100,"John","john@gmail.com")
    println("First Object $e1")
    val e2=Employee(100,"John","john@gmail.com")
    println("Second Object $e2")
    println(e1==e2)
    println(e1.equals(e2))
    val e3=e1.copy(empId=1000)
    println("Third Object (copy used) $e3")
    val e4=Employee(2000)
    println("Fourth Object $e4")
}