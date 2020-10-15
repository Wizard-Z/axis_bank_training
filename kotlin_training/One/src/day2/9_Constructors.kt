package day2
class employee(id:Int, name:String){
    private var eid=0
    private var ename=""
    init{
        eid =id
        ename = name
        println("Emp id is $eid")
        println("EmpName  is $ename")
    }
    fun output(){
        println("The values are:")
        println("ID: $eid, name: $ename")
    }
}

fun main() {
    val e = employee(123,"HelloEmp")
    e.output()

}
