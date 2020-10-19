package day4

fun main() {
    var list1:List<Int> = listOf(1,2,3)
    var list2:List<String> = listOf<String>("One","Two","Three","Three")
    var list3:List<Any> = listOf('a',"AA","Hello mortals",true,"SoTrue")
    dispElements(list1)
    dispElements(list2)
    dispElements(list3)
    println(list3)
    // Methods
    println(list2.contains("Three"))
    println(list2[1])
    println(list2.isEmpty())
    println(list2.drop(2))
    dispElements(list2)
}
fun dispElements(list:List<Any>){
    for (item in list)
        print("$item, ")
    println()
}