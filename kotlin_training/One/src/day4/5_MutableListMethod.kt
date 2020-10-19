package day4

fun main(){
    var list2:MutableList<String> = mutableListOf<String>("Delhi","Mumbai","Bangalore","Chennai")
    var list3:MutableList<String> = mutableListOf<String>("Hyderabad","Calcutta")
    println(list2)
    println(list3)
    list2.addAll(list3)
    println(list2)
    list2.removeAt(0)
    list2.remove("Delhi")
    println(list2)
    list2.set(2,"Chandigarh")
    println(list2)
    list2.retainAll(list3)
    println(list2)
    list2.clear()
    println(list2)
    list2.addAll(list3)
    println(list2)
    list2.subList(0,1)
    println(list2)
}


