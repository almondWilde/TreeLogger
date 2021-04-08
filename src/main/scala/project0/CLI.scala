package project0

import scala.io.StdIn
import scala.util.matching.Regex


class Cli{
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

        //var input = StdIn.readLine()

    }
    def printWelcome(): Unit = {
        println("~Welcome to the Tree Logger~\nLog your tree before it logs!\n\n")
    }

    def printLoggedTrees(): Unit = {}
    def loadCSVtoDB(filename:String): Unit = {}
    def addTree(): Unit = {}
    def delete(index:Int): Unit = {}
}