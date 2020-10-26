package com.booking.dao
import java.sql.*


var conn: Connection? = null
fun getConnection(dbName:String) {

    val url = "jdbc:mysql://localhost:3306/hbook"
    val uname = "root"
    val pwd = "Wizard@123"
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        conn = DriverManager.getConnection(url, uname, pwd)
        if (conn != null)
            println("Connected successfully!")

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
