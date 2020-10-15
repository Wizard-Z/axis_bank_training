package day2


class Emp{
    var eName:String=""
    var eId:Int=0

    constructor(id:Int,name:String)
    {
        eId=id
        eName=name
        println("Emp id is $eId")
        println("EmpName  is $eName")
    }

}
fun main()
{
    val e=Emp(1000,"John")
}