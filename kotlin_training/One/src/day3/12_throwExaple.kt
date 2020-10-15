package day3

fun main() {
    try{
    checkAge(155)}
    catch (e:Exception){
        println(e.message)
    }
}
fun checkAge(age:Int){
    if(age>18)
        println("Valid to vote.. 👍")
    else
        throw Exception("Wait till you are 18 🤣")
}