package day3

fun main() {
    var str:String?
    str="not null"
    println("value is:$str:")
    //
    var len: Int?=if (str!=null) str.length else 0
    println("length is: $len")
    //safe call
    len = str?.length
    println("Length using safe call: $len")
}