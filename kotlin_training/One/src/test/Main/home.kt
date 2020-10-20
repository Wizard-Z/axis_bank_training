package test.Main

//home.kt
import test.DaoServices.*
import test.DaoServices.connectionClose
import test.DaoServices.getConnection1
import test.DaoServices.insert
import java.sql.Connection
public var conn: Connection? = null
internal var username = "root" // provide the username
internal var password = "Wizard@123" // provide the corresponding password
fun main()
{

    getConnection1()
    var b:Boolean=insert("Raju","Raju","Raju","Raju@gmail.com")
    if(b)
    {
        println("Success!!")
    }
    connectionClose();


}