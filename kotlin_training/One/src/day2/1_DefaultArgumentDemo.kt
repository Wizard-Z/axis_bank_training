package day2

fun main() {
    run()
    println("Passing arguments")
    run(name="Sourabh");
    run(location="Delhi")
    run(24)
    run(24,"Hellome")// in orders
    run(24, location="Myhome")


}

fun run(num:Int=50, name:String="MyName", location:String="Virtual"){
    println("arguments values:num: $num, name: $name, location: $location")
}