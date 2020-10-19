package day4

fun main() {
    val myMap1:HashMap<Int,String> = hashMapOf<Int,String>(1 to "Ravi", 2 to "Raju")
    val myMap2:HashMap<Any,Any> = hashMapOf<Any,Any>(1 to "Ravi", "eId" to 100, 'c' to "Raju")
    for (i in myMap1.keys)
        print("$i-->${myMap1[i]}, ")
    println()
    for (i in myMap2.keys)
        print("$i-->${myMap2[i]}, ")
    println("\nOR\n")
    println("$myMap1,\n$myMap2")

}