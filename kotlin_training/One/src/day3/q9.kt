package day3

/*
Create a class called Account with acctid,
Acct_type,name with primary constructor.
Create 5 instance to Account class to
display each ones details.
 */
data class Account(val acctid:Int,val Acct_type:String,
val name:String){}

fun main() {
    val obj1 = Account(1,"Savings","Sourabh")
    val obj2 = Account(2,"Current","Anorak")
    val obj3 = Account(3,"Awesome","myname")
    val obj4 = Account(4, "Super","noNmae")
    val obj5 = Account(5,"sdf","abckd")
    println(" $obj1\n $obj2\n $obj3\n $obj4\n $obj5")
}
