
object NoughtsAndCrosses {
	val board = Array(Array(0, 1, 2), 
	                  Array(2, 0, 1), 
	                  Array(1, 0, 0))
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
	
	def prettyRow(row:Array[Int]) = {
		row.map((x:Int) => symbolMap(x))
	}
	
	def pretty = {
		board.map(prettyRow(_).toString)
	}
	
	def main(args: Array[String]) {
		println(pretty.toString)
	}
}

