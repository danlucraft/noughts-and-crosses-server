
class Board(val size: Int) {
	val board = Array.make(size, 0).map(_ => Array.make(size, 0))
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
	
	def prettyRow(row:Array[Int]) = {
		row.map((x:Int) => symbolMap(x)).mkString(" ")
	}
	
	def pretty = {
		board.map(prettyRow(_)).mkString("\n")
	}
}

object NoughtsAndCrosses {
	def main(args: Array[String]) {
		val board = new Board(args.first.toInt)
		println(board.pretty.toString)
	}
}

