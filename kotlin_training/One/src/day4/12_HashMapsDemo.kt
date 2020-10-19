package day4

fun main()
{
    val myMap1:HashMap<Int,String> = HashMap<Int,String>()
    myMap1.put(1,"Ravi")
    myMap1.put(4,"Ravi")
    myMap1.put(2,"Raju")
    myMap1.put(3,"Ramu")
    myMap1.put(6,"Ramu")
    myMap1.put(5,"Ramu")
    myMap1.put(100,"Ramu")
    myMap1.put(50,"Ramu")
    for(k in myMap1.keys)
        print("Key=$k = ${myMap1[k]} ")
    println()
    //String type of a key
    val myMap2:HashMap<String,String> = HashMap<String,String>()
    myMap2.put("eId","100")
    myMap2.put("eName","Ravi")
    myMap2.put("eCity","Bangalore")
    myMap2.put("eSal", "10000")
    for(k in myMap2.keys)
        print("Key=$k = ${myMap2[k]}")
    println()
    myMap2.replace("eId","200")
    for(k in myMap2.keys)
        print("Key=$k = ${myMap2[k]}")
    println()
    myMap2.remove("eSal")
    for(k in myMap2.keys)
        print("Key=$k = ${myMap2[k]}")

}