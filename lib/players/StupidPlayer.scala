
object StupidPlayer extends Player {
	def move(board: Board, player: Int): Option[(Int, Int)] = {
		return Some((Math.random*board.size).toInt, (Math.random*board.size).toInt)
	}
}
