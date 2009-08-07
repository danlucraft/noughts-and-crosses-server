
class Board(val size: Int) {
	val board = Array.make(size, 0).map(_ => Array.make(size, 0))
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
		
	def prettyRow(row:Array[Int]) = {
		row.map((x:Int) => symbolMap(x)).mkString(" ")
	}
	
	def pretty = {
		board.map(prettyRow(_)).mkString("\n")
	}
	
	def set(x:Int, y:Int, v:Int) = {
		board(x)(y) = v
	}

	def apply(x:Int, y:Int) = board(x)(y)
	
	def blanks() = {
		var a:List[(Int, Int)] = List()
		for(i <- 0 to size - 1; j <- 0 to size - 1)
		  if(apply(i, j) == 0)
		    a = (i, j) :: a
		a
	}
}

object Board {
	def fromString(str: String) = {
		val board = new Board(3)
		val ints = str.split("").subArray(1, 10).map(_.toInt)
		for (i <- 0 to 2; j <- 0 to 2) 
		  board.set(i, j, ints(i*3 + j))
        board
	}
}

object EagerPlayer {
	def move(board: Board, player: Int): Option[(Int, Int)] = {
		for(i <- 0 to board.size - 1; j <- 0 to board.size - 1)
		  if(board(i, j) == 0)
		    return Some((i, j))
		return None
	}
}

object RandomPlayer {
	def move(board: Board, player: Int): Option[(Int, Int)] = {
		val blanks = board.blanks()
		if(blanks.length > 0)
			return Some(blanks((Math.random*blanks.length).toInt))
		else
			return None
	}
}

object NoughtsAndCrosses {
	def printMove(move: Option[(Int, Int)]) = move match {
		case Some(x) => println(x)
		case None    => println("No valid move")
	}
	
	def main(args: Array[String]) {
		println("Current board: ")
		val board = Board.fromString(args(1))
		println(board.pretty.toString)
		args(0) match {
			case "EagerPlayer" => printMove(EagerPlayer.move(board, 1))
			case "RandomPlayer" => printMove(RandomPlayer.move(board, 1))
		}
	}
}

