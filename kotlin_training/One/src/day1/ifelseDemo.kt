package day1

fun main() {
    var x = 10
    var y=20
    var result:String = if(x>y) "$x is greater than $y"
    else "$x is smaller than $y"

    x=10
    y=20
    result = if(x>y) "$x is greater than $y"
    else if(x<y) "$x is smaller than $y"
    else "$x is equal to $y"
    println(result)

    // Nested if
    var n1=10;var n2=20;var n3=99;
    result=if(n1>n2)
    {

        val max=if(n1>n3){
            n1
        }
        else{
            n3
        }
        "Found $max from First IF"
    }
    else if(n2>n3){
        "from elseif $n2"
    }
    else{
        "from else $n3"
    }
    print("3 Numbers \n$result")




}