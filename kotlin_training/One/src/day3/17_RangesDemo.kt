package day3
fun main()
{
    println("Reverse 1")
    var range1=1..10
    for(x in range1.reversed())
    {
        print(x)
    }
    println()
    println("Reverse 2")


    var range2:IntRange=IntRange(1,10)
    for(x in range2.reversed())
    {
        print(x)
    }
    println()
    println("Reverse 3")

    var range3=IntProgression.fromClosedRange(10,1,-1)
    for(x in range3.reversed())
    {
        print(x)
    }
    println()
    println("Reverse 4")


    var range4=IntProgression.fromClosedRange(10,1,-2)
    for(x in range4.reversed())
    {
        print(x)
    }

    var cc= 'a'..'z' step 2
    for (i in cc.reversed())
        print("$i,")
}
