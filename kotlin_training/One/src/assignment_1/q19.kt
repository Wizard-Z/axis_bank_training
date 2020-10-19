package assignment_1

fun main() {
    val list:ArrayList<Int> = arrayListOf(1,2,3,4)
    val list2: Array<Int> = list.toTypedArray()
    println("List1: $list\nList2:")
    for(i in list2)
        print("$i, ")
}