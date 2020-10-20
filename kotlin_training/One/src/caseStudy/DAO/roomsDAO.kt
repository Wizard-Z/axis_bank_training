package caseStudy.DAO

import caseStudy.model.Rooms

class roomsDAO{
    fun getRoomsDetails(type:String): Rooms? {
        val query = "SELECT * FROM rooms where type='$type'"
        val st = conn?.createStatement()
        var rs = st?.executeQuery(query)
        rs?.next()//TODO manage nulls here. check custDAO
        if (rs != null){// && rs.getInt(3)>0) {
            return Rooms(rs.getString(1),rs.getInt(2),rs.getInt(3))
        }
        else
            return null
    }
    fun showAll(){
        println("Format:\n| room-type| avail-rooms| price|")
        val st = conn?.createStatement()
        var rs = st?.executeQuery("SELECT * from rooms")
        if (rs != null) {
            while (rs.next()) {
                if (rs.getInt(3)>0) println(rs.getString(1) + " : " + rs.getInt(3) + " : " + rs.getInt(2))
            }
        }
    }
    fun decRoom(type:String,c:Int=1){
        val st = conn?.createStatement()
        var count = getRoomsDetails(type)?.qty?.minus(c)
        val rs = st?.executeUpdate("UPDATE rooms SET qty=$count WHERE type='$type'")
        if (rs != null) {
            if (rs>0)
                println("..Update(-) made to ROOMS table..")
        }
    }
    fun incRoom(type:String,c:Int=1){
        val st = conn?.createStatement()
        var count = getRoomsDetails(type)?.qty?.plus(c)
        val rs = st?.executeUpdate("UPDATE rooms SET qty=$count WHERE type='$type'")
        if (rs != null) {
            if (rs>0)
                println("..Update(+) made to ROOMS table..")
        }
    }
    fun descTable(){
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
    fun insertRoom(room:Rooms){
        var query:String = "INSERT INTO rooms values(?,?,?)"
        var st = conn?.prepareStatement(query)
        println("Inserting Room obj: $room\n>>>")
        st?.setString(1, room.type)
        st?.setInt(2,room.price)
        st?.setInt(3,room.qty)
        val count = st?.executeUpdate() // not required to pass query here.
        println("$count row/s updated!")
    }
}