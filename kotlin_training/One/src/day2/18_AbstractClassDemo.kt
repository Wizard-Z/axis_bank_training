package day2
abstract class RBI{
    abstract var rateOfInterest:Float
    abstract fun calInterest(p:Float,t:Float):Float
}
class HDFC:RBI(){
    override var rateOfInterest = 3.3f
    override fun calInterest(p:Float,t:Float):Float{
        return p*rateOfInterest*t/100
    }
}

fun main() {
    var h:RBI=HDFC()
    var sI=h.calInterest(1000F,15F)
    println("Interest from HDFC IS $sI")
}