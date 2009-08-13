
class Game(val a:Player, val b:Player) {
	val board = new Board(3)
	
	def treequel(x:Any, y:Any, z:Any) = (x == y) && (y == z)
	
	def intToPlayer(i:Option[Int]): Option[Player] = i match {
		case None    => None
		case Some(0) => None
		case Some(1) => Some(a)
		case Some(2) => Some(b)
	}

    def playerInt(p:Player): Int = if (p == a) 1 else 2
	
	def moveCount(p:Player): Int = {
		board.coords(Some(playerInt(p))).length
	}
	
	def toMove() = if(moveCount(a) > moveCount(b)) b else a
	
	def winner(): Option[Player] = {
		for(i <- 0 to 2)
		  if(treequel(board(0, i), board(1, i), board(2, i)) && board(0, i) != 0)
		    return intToPlayer(board(0, i))
		
		for(i <- 0 to 2)
		  if(treequel(board(i, 0), board(i, 1), board(i, 2)) && board(i, 0) != 0)
		    return intToPlayer(board(i, 0))
		
		if(treequel(board(0, 0), board(1, 1), board(2, 2)) && board(0, 0) != 0)
		    return intToPlayer(board(0, 0))
		
		if(treequel(board(2, 0), board(1, 1), board(0, 2)) && board(1, 1) != 0)
		    return intToPlayer(board(0, 0))
		None
	}
	
	def play() = winner() match {
		case Some(p) => println("Winner: ", p)
		case None    => move()
	}
	
	def move() { 
		val toMovePlayer = toMove()
		val move = toMovePlayer.move(board, playerInt(toMovePlayer))
		println(toMovePlayer)
		println(move)
		move match {
			case Some((x, y)) => board(x, y) = Some(playerInt(toMovePlayer))
			case None         => println(".")
		}
		println(board.pretty.toString)
		play()
	}
}
