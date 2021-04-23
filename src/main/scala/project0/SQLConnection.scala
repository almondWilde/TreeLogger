package project0

import java.sql.{Connection, DriverManager, ResultSet}

object SQLConnection {
    val con_str = "jdbc:postgresql://localhost:5432/postgres?user=postgres"
    val conn = DriverManager.getConnection(con_str, "postgres", "asdf!@#4")   //getenv for environment variables file

    def run(): Unit = {
        println("Initialize postgres connector...")
        classOf[org.postgresql.Driver].newInstance()
        
        //test connection
        try {
            conn.getCatalog()
            println("connection established!")
        } 
        catch{
            case e:Exception => throw e
        }
    }
    def printTrees(): Unit = {
        val stm = conn.prepareStatement("select * from trees")
        val rs = stm.getResultSet()

        new Iterator[String] {
                def hasNext = rs.next()
                def next() = rs.getString(1)
            }.toStream
    }
    def loadCSVtoDB(csv:CSVUtil): Unit = {
        //traverse rows
        for(line <- csv.bufferedSource.getLines()){
            //extract data from the line
            
            //data import format
            //index girth height volume
            var data = line.split(' ')
            println(data)
            //parse the data into an sql statement
            //insert the values to the database
        }
    }
    def close():Unit = {
        conn.close
    }
}
