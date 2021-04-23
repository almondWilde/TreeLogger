package project0

import javax.swing.ImageIcon
import java.awt.Label



object Main{

  def main(args:Array[String]): Unit ={
    var cli = new Cli()

    //parse data from a csv
    var csv = new CSVUtil("res/trees.csv") 

    //displays the app menu and connects to the database
    cli.menu()
  
    //personal functionality

    //requirements
    //perform basic CRUD (Create, read, update and delete)
    //read Json or csv and store data into a database
    //----database must have multiple tables
    //----json/csv must have similar properties to the database tables/properties
    //----functionality of the app must depend upon data in the database -- use of the app with a database should be impossible
    
    //interactive CLI
  }
}