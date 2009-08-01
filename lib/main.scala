
object NoughtsAndCrosses {
	val board = Array(0, 1, 2, 2, 0, 1, 1, 0, 0)
	
	def pretty = {
		board.map((x:Int) => x*2)
	}
	
	def main(args: Array[String]) {
		println(pretty.toString)
	}
}

