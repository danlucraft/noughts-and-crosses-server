
class Board(val size: Int) {
	val board = Array.make(size, 0).map(_ => Array.make(size, 0))
}

object NoughtsAndCrosses {
	val board = new Board(3)
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
	
	def prettyRow(row:Array[Int]) = {
		row.map((x:Int) => symbolMap(x)).mkString(" ")
	}
	
	def pretty = {
		board.board.map(prettyRow(_)).mkString("\n")
	}
	
	def main(args: Array[String]) {
		println(pretty.toString)
	}
}

