package day2

fun main() {
   var s1 = "WelcOme all!"
   var s2 = "welcome all!"
    var check = if(s1.equals(s2,true))
        "They are same"
    else
        "They are not same"
    println(check)
    println("S1 in lowercase: "+s1.toLowerCase())
    println("substring::"+s2.substring(1,4).toUpperCase())
    var text="""
        #hello new line
        #another line goes here
        #fine my place
    """.trimMargin("#")
    println(text)
}