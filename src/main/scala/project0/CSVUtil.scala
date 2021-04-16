package project0

import scala.io.BufferedSource
import scala.io.Source
import scala.List

class CSVUtil(var filename: String){
    var bufferedSource: BufferedSource = Source.fromFile(this.filename)

    def getAllLines(): String = {
        var lines: String = new String()
        for(line <- bufferedSource.getLines()){
            lines += s"$line\n"
        }
        lines.toString
    }
}