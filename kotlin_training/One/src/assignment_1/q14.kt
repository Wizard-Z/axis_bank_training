package assignment_1

data class Student(val rollNo:Int,
                   val studentName:String,
                   val city:String)

fun main() {
    val s1 = Student(100,"John","Bangalore")
    val s2 = Student(101,"Peter","Chennai")
    val s3 = Student(102,"Marks","Mumbai")
    val s4 = Student(103,"Ravi","Bangalore")
    val s5 = Student(104,"Meera","Mumbai")
    val s6 = Student(105,"Usha","Chennai")
    val s7 = Student(106,"Rekha","Chennai")
    val s8 = Student(107,"Sunil","Bangalore")
    val s9 = Student(108,"Tara","Chennai")
    val s10 = Student(109,"Sun","Mumbai")
    val s11 = Student(110,"Ramu","Bangalore")
    var map:Map<Int,Student> = mapOf(100 to s1,101 to s2,103 to s3,104 to s4,
    105 to s5, 106 to s6, 107 to s7, 108 to s8, 109 to s9, 110 to s10, 111 to s11)
    println("Added students to map")
    //println("New Map:\n"+map.filter { (key, value)->value.city=="Bangalore" }+"\n")
    for (key in map.keys){
        if (map[key]?.city=="Bangalore")
            println(map[key])
    }




}