package day1


import java.util.*

/* Accept the student % and display the class
>60% firstclass
>50-59 second class
>35-49 third class
<35 fail
 use when expression to do this
 */

fun main() {
    val read = Scanner(System.`in`)
    println("Enter marks")
    var marks = read.nextInt()
    var fclass = 60..100
    var result = when (marks) {
        in 1..34 -> "Fail"
        in 35..49 -> "Third class"
        in 50..59 -> "Second class"
        in fclass -> "First class"
        else -> "Invalid input!"
    }
    println("Grade is: $result")
}