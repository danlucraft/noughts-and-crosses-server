
object RandomPlayer extends Player {
	def move(board: Board, player: Int): Option[(Int, Int)] = {
		val blanks = board.blanks()
		if(blanks.length > 0)
			return Some(blanks((Math.random*blanks.length).toInt))
		else
			return None
	}
}
