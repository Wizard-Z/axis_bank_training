package day1
/*
1
12
123
1234
12345
 */

fun main() {
    println("FOr loop")
    for(i in 1..5){
        for(j in 1..i)
            print(j)
        println()
    }
    println("WHILE LOOP")
    var row = 1;
    var col = 1;
    while(row<=5){
        col=1
        while(col<=row)
            print(col++)
        row++;
        println()
    }

    println("DO WHILE")
    row=1
    col=1
    do {
        col=1
        while(col<=row)
            print(col++)
        row++
        println()
    }while (row<=5)
}