package assignment_1

fun<T> dispList(list:List<T>){
    for (item in list)
        print("$item, ")
    println("----")
}
fun main() {
    println("Enter size of Lists")
    val count= readLine()!!.toInt()
    val strList:MutableList<String> = mutableListOf()
    val mixedList:MutableList<Any?> = mutableListOf()
    val intList:MutableList<Int> = mutableListOf()
    for (i in 0 until count){
        println("==${i+1}==")
        println("String List:")
        strList.add(readLine()!!.toString())
        println("Any List:")
        mixedList.add(readLine())
        println("Int List:")
        intList.add(readLine()!!.toInt())
    }
    dispList(strList)
    dispList(intList)
    dispList(mixedList)


}