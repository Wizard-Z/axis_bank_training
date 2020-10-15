package day3

class person<T>(age:T){
    var age:T
    init{
        this.age=age
        println(age)
    }
}
fun main(args:Array<String>)
{
    var ageInt=person(23)
    var ageString=person("twenty three") //conmpile error
}