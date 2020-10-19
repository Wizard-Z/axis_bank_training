package day4

class Emp(var eId:Int, var eName:String, var eCity:String, var eSlary:Float)
fun main()
{
    var list1:ArrayList<Int> = arrayListOf<Int>(23,56,78,90,34)
    var list2:ArrayList<String> = arrayListOf<String>("Delhi","Mumbai","Bangalore","Chennai")
    var list3:ArrayList<Any> = arrayListOf<Any>(12,34,56.6 ,"Delhi","Mumbai","Bangalore","Chennai",false,'a')
    var list4:ArrayList<Emp> = arrayListOf<Emp>()
    printArrayList(list1)
    println()
    printArrayList(list2)
    println()
    printArrayList(list3)
    println()
    val e1=Emp(101,"John","Bangalore", 10034f)
    val e2=Emp(102,"Ravi","Chennai", 20034f)
    val e3=Emp(103,"Ramu","Delhi", 30034f)
    val e4=Emp(104,"Raju","Bangalore", 40034f)
    list4.add(e1);
    list4.add(e2);
    list4.add(e3);
    list4.add(e4);
    println()

    for(e in list4)
    {
        println("${e.eId}, ${e.eName}, ${e.eCity}, ${e.eSlary}")
    }



}