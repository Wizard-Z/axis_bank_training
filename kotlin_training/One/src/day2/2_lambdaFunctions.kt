package day2
/*
fun main() {
    val myLambda :(Int)->Unit={addResult:Int-> println("The result is $addResult")}
    addition(2,6,myLambda)
}
fun addition(n1:Int, n2:Int,myLambda :(Int)->Unit){
    var addResult = n1+n2
    myLambda(addResult)

}*/
fun main() {
    val myLambda:(Int)->Unit = {x:Int -> println("The result is $x")}
    addition(2,6,myLambda)
}
fun addition(n1:Int, n2:Int,myLambda:(Int)->Unit){
    myLambda(n1+n2)
}

