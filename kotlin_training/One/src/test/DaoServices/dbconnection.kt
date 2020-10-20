

//db connection.kt
package test.DaoServices

import java.sql.*
import java.util.*

var conn: Connection? = null
fun getConnection1() {

    val url = "jdbc:mysql://localhost:3306/sampledb"
    val uname = "root"
    val pwd = "Wizard@123"
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(url, uname, pwd)
        if (conn != null) {
            println("Connected successfully")
            var stmt: Statement? = null
            try {
                stmt = conn!!.createStatement()
                //resultset = stmt!!.execute("create database sampledb1;")
                //var b=stmt!!.execute("create database sampledb1")
                if (stmt.execute("use sampledb;")) {
                    println("Sampledb connected")
                }else {
                    println("Not connected")
                }
            }catch(e:Exception){
                println("Sampledb not connected")
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
    conn?.close()
}