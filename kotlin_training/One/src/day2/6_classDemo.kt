package day2

class Student{
    var name=""
    var city=""
    var id=0
    fun input(n:String, c:String,i:Int){
        name = n;
        city = c;
        id = i;
    }
    fun output(){
        println("name: $name,city: $city, id: $id")
    }
}

fun main() {
    var s = Student();
    s.input("name","delhi",56)
    s.output()
}

