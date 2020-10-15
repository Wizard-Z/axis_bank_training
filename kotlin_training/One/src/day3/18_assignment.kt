package day3

import java.util.*

/*
. Count Vowels in the String using functions

 2. Search for the given element in the Array using functions
 . Reverse the range and display the output for every alternate number

  Accept the age and weight of a person from console input,
  check whether the person is eligible to donate blood.
  If his age>18 and weight>55 he is eligible to donate blood
  5. Accept the business sales revenue of the employee as console input.

If the revenue is in  below range provide bonus as follows

10000-2000 bonus=1500
21000-40000 bonus=2500
41000-60000 bonus=3500
Any other number “Not eligible for now”

 Use when operator to do this code

 Using TailRec compute factorial of the given number.
 Keep the number as < 50

7. Using Lambda function calculate the Simple Interest(p*t*r/100)

8. Declare a dynamic array it contains ANY type of data and iterate the array values using for loop.

9. Create a class called Account with acctid,
Acct_type,name with primary constructor.
Create 5 instance to Account class to display each ones details.

10. Convert the program 9 using secondary constructors.
  */
fun main() {
    println("Input")
    val read = Scanner(System.`in`)
    val strI= read.nextLine()
    var count=0
    for (c:Char in strI.toLowerCase()){
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            count+=1
    }
        //+= if(c.toLong() in arrayOf('a',"e",'i','o','u')) 1 else 0
    println(count)
    var arr:Array<Any> = arrayOf(1,2,3,"Hello",'c')
    println("ARRAY IS $arr")
    println("Searching..3: "+arr.contains(3))
    reverseDisp()
    println("\nINPUT AGE AND WEIGHT space ")
    val age=read.nextInt()
    val weight=read.nextDouble()
    ques4(age,weight)
    println("Enter Revenue!Integers")
    ques5(read.nextInt())


}

fun reverseDisp(){
    var r=1..50
    println("Range..")
    for(i in r)
        print("$i, ")
    println("\nReversed alternate...\n\n")
    for(i in r.reversed() step 2)
        print("$i, ")
}
fun ques4(age:Int,weight:Double){
    println("age:$age weight:$weight")
    if (age>18 && weight>55.0)
        println("Eligible")
    else
        println("Not Eligible")

}
fun ques5(revenue:Int){
    var bonus:Any
    when(revenue){
        in 10000..20000 -> bonus=1500
        in 21000..40000 -> bonus=2500
        in 41000..60000 -> bonus=3500
        else -> bonus="Not eligible for now"
    }
    println("Bonus: $bonus")
}