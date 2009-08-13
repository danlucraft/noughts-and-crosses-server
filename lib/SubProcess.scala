
import java.io._
 
class SubProcess() {

    def run(cmd : String, dir : File, withline:String=>Unit) : Int = {
       val environ : Array[String] = new Array[String](0)
       val proc = Runtime.getRuntime.exec(cmd, environ, dir)
       val reader = new BufferedReader(new InputStreamReader(proc.getInputStream))
       var line : String = null
       do {
           withline(reader.readLine)
       } while (line != null)
       proc.waitFor
       reader.close
       proc.exitValue
    }
}