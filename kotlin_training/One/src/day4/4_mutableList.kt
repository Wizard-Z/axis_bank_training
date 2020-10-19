package day4

fun main() {
    var list1= mutableListOf(1,2,3,"Helloall",'a',true)
    var list2 = mutableListOf<String>("One","Two","Three")
    var list3 = mutableListOf<Int>(1,2,3,4,5,3,1419)
    println("lists are:\n$list1\n$list2\n$list3")
    list1[1]="Two"
    list3[2]=1
    list2[1]="AnotherOne"
    println("lists are:\n$list1\n$list2\n$list3")


}