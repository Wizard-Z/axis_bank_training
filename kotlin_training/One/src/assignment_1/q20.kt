package assignment_1

import java.time.LocalDate
import java.time.Period

fun main() {
    var date1 = LocalDate.parse("2018-12-12")
    val period = Period.of(2019,1,1)
    val newDate = date1.plus(period)
    println("Old Date: $date1\nNew Date: $newDate")

}


