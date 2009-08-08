
object NoughtsAndCrosses {
	def printMove(move: Option[(Int, Int)]) = move match {
		case Some(x) => println(x)
		case None    => println("No valid move")
	}
	
	def main(args: Array[String]) {
/*			println("Current board: ")
			val board = Board.fromString(args(1))
			println(board.pretty.toString)
			args(0) match {
				case "EagerPlayer" => printMove(EagerPlayer.move(board, 1))
				case "RandomPlayer" => printMove(RandomPlayer.move(board, 1))
			}*/
		new Tournament(Array(EagerPlayer, RandomPlayer)).run()
	}
}

