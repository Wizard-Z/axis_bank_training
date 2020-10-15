package day3

/*
 Convert the program 9 using secondary constructors.
 */

data class Account1(var acctid: Int){
    var Acct_type:String=""
    var name:String=""
    constructor(acctid: Int,Acct_type:String,name:String):this(acctid){
        this.Acct_type=Acct_type
        this.name = name
    }

    override fun toString(): String {
        return "Account:[id: $acctid name:$name type: $Acct_type]"
    }
}

fun main() {
    val obj1 = Account1(1,"Savings","Sourabh")
    val obj2 = Account1(2,"Current","Anorak")
    val obj3 = Account1(3,"Awesome","myname")
    val obj4 = Account1(4, "Super","noNmae")
    val obj5 = Account1(5,"sdf","abckd")
    println(" $obj1\n $obj2\n $obj3\n $obj4\n $obj5")
}
