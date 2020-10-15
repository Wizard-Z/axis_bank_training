package day1

fun main() {
    var arr = arrayOf(1,2,3,99,"Hello",56)
    for(a in arr){
        print(a.toString()+",")

    }
    //Strings
    arr = arrayOf("Mango","sdf")
    val fruitArr:Array<String> = arrayOf("Fruits","MAngo","AAM","Kiwi")
    println("FRUITS")
    for(a in fruitArr)
        print("$a,")
    println("Another")
    for(a in arr)
        print("$a,")

    println("USing indices")
    for(a in fruitArr.indices)
        println("fruitArr[$a] = "+fruitArr[a])
    println("Printing ranges\n")
    for(i in 1..10)
        print("$i,")
    println()
    for(i in 10 downTo 2)
        print("$i,")
    println("\nSTEP FUNCTIONS\n")
    for(i in 1..11 step 2)
        print("$i,")


}