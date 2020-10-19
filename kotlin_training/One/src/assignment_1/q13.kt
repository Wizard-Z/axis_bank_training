package assignment_1

fun main() {
    val str:String?="I like to study Kotlin"
    when(str){
        is String -> println(str.reversed())
        null -> println("Something happened!!")
    }

}