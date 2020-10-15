package day3

fun main() {
    /* throws error
        var loc:Any?=null
    var unsafeString:String?=loc as String
    println("Unsafe cast: $unsafeString")
     */
    var loc:Any?=13
    //var unsafeString:String?=loc as String
    //println("Unsafe cast: $unsafeString")
    var safeString: String?=loc as? String
    println("Safe casted to String: $safeString")
    var safeInteger: Int? = loc as? Int
    println("Safe casted to Integer: $safeInteger")

}