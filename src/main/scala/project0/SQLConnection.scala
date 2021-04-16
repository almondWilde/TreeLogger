package project0

import java.sql.{Connection, DriverManager, ResultSet}

object SQLConnection {

    def run(): Unit = {
        println("Postgres connector")

            classOf[org.postgresql.Driver].newInstance()
            val con_str = "jdbc:postgresql://localhost:5026/chinook?user=postgres"
            val conn = DriverManager.getConnection(con_str, "postgres", "**************")   //c4c
            try {   
                val stm = conn.prepareStatement("SELECT name from artist;")
                stm.execute()
                val rs = stm.getResultSet()
                
                println(rs)
                while(rs.next) {
                    println(rs.getString("name"))
                }
            } 
            // catch{

            // }
            finally {
                conn.close()
            }
        }
    }
