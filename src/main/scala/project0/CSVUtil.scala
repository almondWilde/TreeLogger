package project0

import scala.io.BufferedSource
import scala.io.Source
import scala.List

class CSVUtil(var filename: String){
    var bufferedSource: BufferedSource = Source.fromFile(this.filename)
    var lines: String = new String()

    def getAllLines(): String = {
        //traverse rows
        for(line <- bufferedSource.getLines()){
            //add rows to string lines with a new line
            lines += s"$line\n"
        }
        //print the lines
        lines.toString
    }
}