package day4

fun main() {
    val myMap1:MutableMap<Int,String> = mutableMapOf(1 to "Ravi", 2 to "Raju")
    val myMap2:MutableMap<Any,Any> = mutableMapOf(1 to "Ravi", "eId" to 100, 'c' to "Raju")
    println("Map1::$myMap1\nMAP2:$myMap2")
    val myMap3: MutableMap<Int,String> = myMap1
    //val myMap3=myMap1
    myMap3[1]="I have Changed!"
    println("\n Copied map1:\n$myMap3\nOriginal::\n$myMap1")
    // Both have changed
    val myMap4: MutableMap<Int,String> = mutableMapOf()
    //val myMap3=myMap1
    myMap4.putAll(myMap1)
    myMap4[1]="I have Changed second type!"
    println("\n Copied map1:\n$myMap4\nOriginal::\n$myMap1")
    // Both have not changed

}