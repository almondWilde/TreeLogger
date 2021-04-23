package project0

import scala.io.StdIn
import scala.util.matching.Regex
import scala.Exception



class Cli{
    private var db = SQLConnection
    def Cli(){
        db.run
    }
    def menu(): Unit = {
        printWelcome()
        List(
            "Manu Options:",
            "print: Print logged trees",
            "load [filename]: loads new trees via csv to the database",
            "add: manually add a tree in the database",
            "delete [index]: remove a tree from database logs",
            "exit: close application"
        ).foreach(println)
        println("\n")

        var continueMenuLoop:Boolean = true
        var input = StdIn.readLine()
        val pattern:Regex = "(\\w+)(.*)".r
        //try/catch/finally
        try{
            //menu functions
            input match {
                case pattern(cmd, arg) if cmd == "print" => {
                    db.printTrees()
                }
                case pattern(cmd, arg) if cmd == "load" => {
                    input = StdIn.readLine("Specify the file to load")
                    input.stripLineEnd
                    load(input)
                }
                case pattern(cmd, args) if cmd == "add" =>{
                }
                case pattern(cmd, args) if cmd == "delete" =>{
                }
                case pattern(cmd,arg) if cmd == "exit" =>{
                    continueMenuLoop = false
                }
                case pattern(cmd,arg) =>{
                    println(s"parsed command $cmd does not match with argument $arg")
                }
                
                case _ => {
                    //default case if no other cases are matched
                    println(s"failed to parse command: $input")
                }
            }
        }
        catch{
            case e:Exception => throw e
        }
        finally{
            db.close
        }
    }
    def printWelcome(): Unit = {
        println("\n\n\n\n~Welcome to the Tree Logger~\nLog your tree before it logs!\n\n")
    }

    def printLoggedTrees(): Unit = {
        try{
            db.printTrees()
        }
        catch{
            case e:Exception => throw e
        }

        
    }
    def load(filename:String): Unit = {
        println("Loading file: $filename ...")
        var csv = new CSVUtil(filename)

        db.loadCSVtoDB(csv)

        //print completed message
    }
    def addTree(): Unit = {
        //connect to database
        //prompt user for tree data (consider a tree class)
        //insert tree data
        //let the user know that the tree was added, include the serial
    }
    def delete(index:Int): Unit = {
        //prompt the user for the tree id they want to delete
        //delete tree from database
        //let the user know which tree was deleted
    }
}