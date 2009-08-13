
class ExternalPlayer(val name:String, val dir:String, val exec:String) extends Player {
    val ResponseFormatRE = """\((\d),(\d)\)""".r
    
    def move(board:Board, player:Int): Option[(Int, Int)] = {
        print("# Calling " + name)
        val response = getOutput(board, player)
        println(response)
        response match {
            case ResponseFormatRE(x, y) => return Some((x.toInt, y.toInt))
            case nonMatch               => return None
        }
        None
    }
    
    def getOutput(board:Board, player:Int): String = {
        val process = new SubProcess
        val shell = exec + " " + board.line() + " " + board.symbolMap(Some(player))
        println("    \"" + shell + "\"")
        process.run(shell, new java.io.File(dir), (s:String) => return s)
        return ""
    }
    
    override def toString() = name
}

