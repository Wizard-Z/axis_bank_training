package jdbcDemoO

import java.sql.DriverManager
import java.util.*

object DemoClass {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        Class.forName("com.mysql.cj.jdbc.Driver") //step 2 load the driver
        val url = "jdbc:mysql://localhost:3306/demo"
        val uname = "root"
        val pwd = "Wizard@123"
        //String query="SELECT first_name from actor_info where actor_id =2";
        val con = DriverManager.getConnection(url, uname, pwd) //connection Establish
        var query = "SELECT * FROM students"
        val st = con.createStatement() //step 4 create Statement
        var rs = st.executeQuery(query) // step 5 execute query
        // fetch single record
        /*
		rs.next();
		System.out.println(":"+rs.getString(1));*/

        // fetch whole table
        while (rs.next()) println(rs.getInt(1).toString() + ":" + rs.getString(2))
        //DML execute update
        query = "INSERT INTO students values(4,'hellome')"
        var count = st.executeUpdate(query)
        println("$count row/s updated!")
        //Prepared statement for dynamic entries
        val scnr = Scanner(System.`in`)
        println("Enter id and name ")
        val name: String
        val id: Int
        query = "INSERT INTO students values(?,?)"
        val st1 = con.prepareStatement(query)
        id = scnr.nextLine().toInt()
        name = scnr.nextLine()
        println("Entered: $id:$name\n\n")
        st1.setInt(1, id)
        st1.setString(2, name)
        count = st1.executeUpdate() // not required to pass query here.
        println("$count row/s updated!")

        // check status
        rs = st.executeQuery("Select * from students")
        while (rs.next()) println(rs.getInt(1).toString() + ":" + rs.getString(2))


        //scnr.close();
        st1.close();
        con.close()
    }
}