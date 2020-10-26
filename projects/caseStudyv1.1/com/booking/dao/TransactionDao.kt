package com.booking.dao

import com.booking.model.Customers
import com.booking.model.Rooms
import com.booking.model.Transactions

class TransactionDao{
    fun insertRow(customer: Customers, amount:Float){
        var query = "INSERT INTO trans values(?,?,?,?)"
        var st = conn?.prepareStatement(query)
        st?.setInt(1, customer.cid)
        st?.setString(2, customer.name)
        st?.setFloat(3, amount)
        st?.setDate(4, customer.bookDate)
        val count = st?.executeUpdate()
        println("$count row/s updated -transactions")
    }
    fun showTransactions(){
        println("Showing transaction table...\n>>>")
        println("Format:\n| C.id| Name| Amount| Booking-Date")
        val st = conn?.createStatement()
        var rs = st?.executeQuery("SELECT * from trans")
        if (rs != null) {
            while (rs.next()) {
                println("${rs.getInt(1)} : ${rs.getString(2)} : ${rs.getFloat(3)} : ${rs.getDate(4)}")
            }
        }
        println("----End of table----")

    }
    fun update(cid:Int,amount:Float) {
        val query = "UPDATE trans SET amount=$amount WHERE cid=$cid"
        val st = conn?.createStatement()
        st?.executeUpdate(query)
        println("Update made to trans table")
    }
    fun getRow(cid:Int):Transactions?{
        val query = "SELECT * from trans where cid=$cid"
        val st = conn?.createStatement()
        val rs = st?.executeQuery(query)
        rs?.next()
        return if (rs != null){
            println("Data Available.")
            Transactions(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4))
        }
        else {
            println("No record found.")
            null
        }

    }


}