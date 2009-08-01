
object NoughtsAndCrosses {
	val board = Array(0, 1, 2, 2, 0, 1, 1, 0, 0)
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
	
	def pretty = {
		board.map((x:Int) => symbolMap(x))
	}
	
	def main(args: Array[String]) {
		println(pretty.toString)
	}
}

