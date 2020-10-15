package day1
/*
Labelled for loop
 */
fun main() {
    println("---")
    myloop@ for(i in 1..3){
        if(i==2)
            break@myloop
        for(j in 1..4){
            println("$i,$j")
        }
    }
    print("CONTINUE!")
    for (i in 12..40){
        if(i<22){
            print("$i,")
            continue
        }
        println("Limit done")
        break;
    }


}