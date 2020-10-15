package day2

fun welcome(name:String, job:String,fns:(String,String)->String){
    val result=fns(name,job)
    println(result)
}
fun main() {
    val fn:(String,String)->String={name,job->"$name is doing $job nicely!"}
    welcome("Sourabh","Study",fn)
}

