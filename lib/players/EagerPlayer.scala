
object EagerPlayer extends Player {
	def move(board: Board, player: Int): Option[(Int, Int)] = {
		for(i <- 0 to board.size - 1; j <- 0 to board.size - 1)
		  if(board(i, j) == None)
		    return Some((i, j))
		return None
	}
}

