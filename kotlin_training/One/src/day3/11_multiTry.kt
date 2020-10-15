package day3

fun main() {
    var a1 = arrayOf(1,2,3,44,55,66,77)
    var a2 = arrayOf(1,0,2,0,13)
    try{
        for(i in a1.indices){
            try{
                println("${a1[i]}/${a2[i]} = "+a1[i]/a2[i])
            }catch (e:ArithmeticException){
                println(e.message)
            }
        }
    }catch (e:ArrayIndexOutOfBoundsException){
        println(e.message)
    }
    finally {
        println("In finally")
    }
    println("Rest of the code....")
}