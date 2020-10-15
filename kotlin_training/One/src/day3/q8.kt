package day3

/*
Declare a dynamic array it contains ANY type of data and iterate
 the array values using for loop.
 */
fun main() {
    val arr = arrayOf(1,2,3,"A String",'a',21.2,1L)
    for(item in arr)
        print("$item, ")
}