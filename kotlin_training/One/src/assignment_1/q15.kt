package assignment_1

class operation{
    companion object calculator {
        fun add(op1: Int, op2: Int) = op1 + op2
        fun substract(op1: Int, op2: Int) = op1 - op2
        fun multiply(op1: Int, op2: Int) = op1 * op2
        fun divide(op1: Int, op2: Int) = op1 / op2
    }
}

fun main() {
    println("Companion Object\n Enter 2 numbers")
    val op1:Int= readLine()!!.toInt()
    val op2:Int= readLine()!!.toInt()
    println("$op1+$op2: "+operation.add(op1,op2))
    println("$op1-$op2: "+operation.substract(op1,op2))
    println("$op1*$op2: "+operation.multiply(op1,op2))
    println("$op1/$op2: "+operation.divide(op1,op2))

}