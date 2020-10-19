package assignment_1

fun main() {
    val map:HashMap<Int,String> = hashMapOf(1 to "hello", 2 to "hello again")
    val lst = map.toList()
    println("MAP::$map\nLIST::$lst")
}