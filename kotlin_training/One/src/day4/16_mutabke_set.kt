package day4

fun main()
{
    var mySet=setOf(2,6,6,2,6.5,6.3,"Ravi","Raju","Ravi")
    println(mySet)
    println()
    val x=mySet.drop(4)
    println(x)

    println("After Drop:$mySet")
    //  for(items in mySet)
    //    println(items)
    println(mySet.isEmpty())
    println(mySet.elementAt(3))
}