package day4

fun main() {
    val myMap:HashMap<Int,String> = HashMap<Int,String>()
    myMap[1] = "FirstEntry"
    myMap[2] = "SecondEntry"
    myMap[3]= "ThirdEntry"
    myMap[1]="ChangedOne"

    println(myMap)
    for (key in myMap.keys)
        print("$key is ${myMap[key]} ")
    println("\nRemoving 2")
    myMap.remove(2)
    println(myMap)

    val map2: MutableMap<Int, String> = mutableMapOf()
    map2[1]="Hellonew"
    map2[2]="AnotherHello"
    map2[1]="HelloAgain"
    map2[3]="ThirdEnty"
    println(map2)
    println("removing 2")
    map2.remove(2)
    println(map2)


}