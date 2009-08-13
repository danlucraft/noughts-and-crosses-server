
abstract class Player {
	def move(board:Board, player:Int): Option[(Int, Int)]
	
	def main(args: Array[String]) {
		println("Current board: ")
		val board = Board.fromString(args(0))
		println(board.pretty.toString)
        NoughtsAndCrosses.printMove(move(board, 1))
	}
}