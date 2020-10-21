package caseStudy.DAO
import java.sql.*
import java.util.*

var conn: Connection? = null
fun getConnection(dbName:String) {

    val url = "jdbc:mysql://localhost:3306/hbook"
    val uname = "root"
    val pwd = "Wizard@123"
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        conn = DriverManager.getConnection(url, uname, pwd)
        if (conn != null) {
            println("Connected successfully")
            var stmt: Statement? = null
            try {
                stmt = conn!!.createStatement()
                //resultset = stmt!!.execute("create database sampledb1;")
                //var b=stmt!!.execute("create database sampledb1")
                if (stmt.execute("use $dbName")) {
                    println("$dbName connected")
                }else {
                    println("---")
                }
            }catch(e:Exception){
                println("$dbName not connected")
            }
        }

    }catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    }catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}




fun connectionClose()
{
    println("Connection closed!")
    conn?.close()
}
