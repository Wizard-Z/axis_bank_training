package day3

fun main() {
    var s1:String?=null
    var s2:String?="Welcome Operator"
    var len1=s1?.length?:0
    var len2=s2?.length?:0
    var len3 = s1?.length
    println("$s1 length $len1\n$s2 length is $len2\n $len3")
}