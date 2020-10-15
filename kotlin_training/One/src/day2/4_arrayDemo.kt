package day2

import kotlin.reflect.typeOf

fun main() {
    var arr = arrayOf(54,"sdf",321,'x')
    arr[0] = 1
    for(items in arr)
        println(items)
    var arr1 = arrayOf(1,2,3,4,5)
    var arr2 = arrayOf("Banana","hellome","okay there Oranges")
    for (index:Int in 0..arr1.size-1)
        println("arr1[$index] : "+arr1[index])

    for (index:Int in 0..arr2.lastIndex)
        println("arr2[$index] : "+arr2[index])


}