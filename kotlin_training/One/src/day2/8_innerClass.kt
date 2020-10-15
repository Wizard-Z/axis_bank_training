package day2



class outerC{
    var name = "Rami"
    inner class innerC{
        var n2 = "Malik"
        fun foo(){println("$n2 $name")}

    }
}
fun main(){
    outerC().innerC().foo();
    var g = outerC();
    println(g.name)
}