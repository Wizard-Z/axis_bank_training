package caseStudy.DAO

import caseStudy.model.Customers


class custDAO{
    fun showAll(){
        println("Format: \n| cid| name| room-type| days| total_amount| fullpay?| method| book_date|")
        val st = conn?.createStatement()
        var rs = st?.executeQuery("SELECT * from cust")
        if (rs != null) {
            while (rs.next()) {
                println(rs.getInt(1).toString()
                        + " : " + rs.getString(2)
                        + " : " + rs.getString(3)
                        + " : " + rs.getInt(4)
                        + " : " + rs.getFloat(5)
                        + " : " + rs.getString(6)
                        + " : " + rs.getString(7)
                        + " : " + rs.getDate(8))
            }
        }
        println("---END OF CUST. TABLE---")
    }

    fun insertCust(cust: Customers){
        var query:String = "INSERT INTO cust(cid,name,type,days,total_amount,fullpay,method,book_date) " +
                "values(?,?,?,?,?,?,?,?)"
        var st = conn?.prepareStatement(query)
        st?.setInt(1, cust.cid)
        st?.setString(2, cust.name)
        st?.setString(3, cust.type)
        st?.setInt(4, cust.days)
        st?.setFloat(5, cust.total_fair)
        st?.setString(6, cust.full_pay)
        st?.setString(7, cust.pay_method)
        st?.setDate(8, cust.bookDate)
        val count = st?.executeUpdate() // not required to pass query here.
        println("$count row/s updated!")


    }
    fun removeCust(cid: Int){
        val cust: Customers = getCustDetails(cid) ?: return
        println("Your Details are.\n>>>$cust")
        val query="DELETE FROM cust WHERE cid=$cid"
        val st=conn?.createStatement()
        val rs = st?.executeUpdate(query)
        println("$cid removed.\n1 row deleted. ")

    }
    fun getCustDetails(cid: Int):Customers? {
        val query = "SELECT * FROM cust where cid=$cid"
        val st = conn?.createStatement()
        var rs = st?.executeQuery(query)
        if (!rs!!.next()) {
            println("NO details for the given ID")
            return null
        } else
            println("Data available\n>>>")
            return Customers(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getFloat(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getDate(8))
    }

        /*//rs?.next()//TODO manage nulls here.
        /*
        cid,name,type,days,total_fair,full_pay,pay_method,bookdate
        1-int,2-string,3-string,4-int,5-float,6-string,7-string,8-date
         */
       /* if (rs != null) {
            return Customers(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getFloat(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getDate(8))
        }
        else
            return null

    }*/*/
    fun descTable(){
        val st = conn?.createStatement()
        val rs = st?.executeQuery("SELECT * FROM cust")
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
    fun groupBy(coln:String,msg:String){
        val st = conn?.createStatement()
        val rs = st?.executeQuery("SELECT COUNT(cid), $coln FROM cust GROUP BY $coln")
        if (!rs!!.next()) {
            println("Empty Hotel")
            return}

        else {
            println(">>>\n$msg")
            do {
                println("${rs.getInt(1)} : ${rs.getString(2)}")

            } while (rs.next());
        }
    }
    fun groupBy2(coln:String,msg:String){
        val st = conn?.createStatement()
        val rs = st?.executeQuery("SELECT COUNT(cid), $coln FROM cust GROUP BY $coln")
        if (!rs!!.next()) {
            println("Empty Hotel")
            return}

        else {
            println(">>>\n$msg")
            do {
                println("${rs.getInt(1)} : ${rs.getDate(2)} : ${rs.getString(3)}")
            } while (rs.next());
        }
    }

}