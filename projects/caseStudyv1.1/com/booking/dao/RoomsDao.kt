package com.booking.dao

import com.booking.model.Rooms

class RoomsDao {
    fun getDetails(type:String): Rooms? {
        val query = "SELECT * FROM rooms where type='$type'"
        val st = conn?.createStatement()
        var rs = st?.executeQuery(query)
        rs?.next()//TODO manage nulls here. check CustomerDao
        if (rs != null){// && rs.getInt(3)>0) {
            return Rooms(rs.getString(1),rs.getFloat(2),rs.getInt(3))
        }
        else
            return null
    }
    fun showAvailable(){
        println("Showing available rooms\n>>>")
        println("Format:\n| room-type| avail-rooms| price|")
        val st = conn?.createStatement()
        var rs = st?.executeQuery("SELECT * from rooms")
        if (rs != null) {
            while (rs.next()) {
                if (rs.getInt(3)>0) println(rs.getString(1) + " : " + rs.getInt(3) + " : " + rs.getFloat(2))
            }
        }
        println("----End of table----")
    }
    fun showAll(){
        println("Showing table\n>>>")
        println("Format:\n| room-type| avail-rooms| price|")
        val st = conn?.createStatement()
        var rs = st?.executeQuery("SELECT * from rooms")
        if (rs != null) {
            while (rs.next())
                println(rs.getString(1) + " : " + rs.getInt(3) + " : " + rs.getFloat(2))
        }
        println("----End of table----")

    }
    fun decrementAvailable(type:String, c:Int=1){
        val st = conn?.createStatement()
        var count = getDetails(type)?.qty?.minus(c)
        val rs = st?.executeUpdate("UPDATE rooms SET qty=$count WHERE type='$type'")
        if (rs != null) {
            if (rs>0)
                println("..Update(-) made to ROOMS table..")
        }
    }
    fun incrementAvailable(type:String, c:Int=1){
        val st = conn?.createStatement()
        var count = getDetails(type)?.qty?.plus(c)
        val rs = st?.executeUpdate("UPDATE rooms SET qty=$count WHERE type='$type'")
        if (rs != null) {
            if (rs>0)
                println("..Update(+) made to ROOMS table..")
        }
    }
    fun describeTable(){
        val st = conn?.createStatement()
        val rs = st?.executeQuery("SELECT * FROM rooms")
        val metaData = rs?.metaData
        println("Number of columns: " + metaData?.columnCount)
        println("Table description...!")
        if (metaData != null) {
            for (i in 1..metaData.columnCount) {
                println(metaData.getColumnName(i).toString() + "\t" + metaData.getColumnTypeName(i))
            }
        }
        println("---END OF TABLE---")
    }
    fun insertRow(room: Rooms){
        var query:String = "INSERT INTO rooms values(?,?,?)"
        var st = conn?.prepareStatement(query)
        println("Inserting Room obj: $room\n>>>")
        st?.setString(1, room.type)
        st?.setFloat(2,room.price)
        st?.setInt(3,room.qty)
        val count = st?.executeUpdate() // not required to pass query here.
        println("$count row/s updated!")
    }

}



