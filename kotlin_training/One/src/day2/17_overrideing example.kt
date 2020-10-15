package day2

open class Animal(){
    open var color=""

    open fun eat(){
        println("Animal is eating")
    }
}

open class Dog():Animal(){
    override var color="Brown"
    override fun eat(){
        println("I am a $color dog and I like to munch!!")
    }
}
class puppy():Dog(){
    override var color="White"
    override fun eat(){
        println("I am a $color puppy and I like to drink")
    }
}
class cat():Animal(){
    override var color="Black"
    override fun eat() {
        println("I am a $color cat and I like milk")
        super.eat()
    }
    fun afraid(){
        println("DOgs despises me!")

    }
}

fun main() {
   var d = Dog()
    d.eat()
    var c = cat()
    c.eat()
    c.afraid()
    var p = puppy()
    p.eat()

}