
class Game(val a:Player, val b:Player) {
	val board = new Board(3)
	var loserByDefault:Option[Player] = None
	
	override def toString() = a + ":" + b
	
	def treequel(x:Option[Int], y:Option[Int], z:Option[Int]) = (x == y) && (y == z)
	
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
	    if (winnerByDefault() != None)
	        winnerByDefault
	    else if (winnerByPlay() != None)
	        winnerByPlay()
	    else
	        None
	}
	
	def winnerByDefault(): Option[Player] = {
	    if (loserByDefault != None) {
	        if (loserByDefault.get == a)
	            Some(b);
	        else
	            Some(a);
	    }
	    else {
	        None
        }
    }
    
    def winnerByPlay(): Option[Player]= {
		for (i <- 0 to 2)
		  if (treequel(board(0, i), board(1, i), board(2, i)) && board(0, i) != None)
		    return intToPlayer(board(0, i))
		
		for (i <- 0 to 2)
		  if (treequel(board(i, 0), board(i, 1), board(i, 2)) && board(i, 0) != None)
		    return intToPlayer(board(i, 0))
		
		if (treequel(board(0, 0), board(1, 1), board(2, 2)) && board(0, 0) != None)
		    return intToPlayer(board(1, 1))
		
		if (treequel(board(2, 0), board(1, 1), board(0, 2)) && board(1, 1) != None)
		    return intToPlayer(board(1, 1))
		    
		return None
	}
	
	def play(): Option[Player] = {
	    winnerByDefault() match {
    		case Some(p) => { println("by default"); return Some(p) }
    		case None    => None
    	}
	    winnerByPlay() match {
    		case Some(p) => { println("by play"); return Some(p) }
    		case None    => None
    	}
	    if (board.blanks().length == 0)
	        return None
	    return move()
	}
    	
	def move(): Option[Player] = { 
		val toMovePlayer = toMove()
		val move = toMovePlayer.move(board, playerInt(toMovePlayer))
		println(toMovePlayer + " " + move)
		if (move == None) {
		    loserByDefault = Some(toMovePlayer)
		}
		else {
		    val (x, y) = move.get
		    if (x > board.size - 1 || x < 0 || y > board.size - 1 || y < 0) {
		        loserByDefault = Some(toMovePlayer)
		    }
		    if (board(x, y) != None)
		        loserByDefault = Some(toMovePlayer)
		    else
		        board(x, y) = Some(playerInt(toMovePlayer))
		}
		
		println(board.pretty.toString)
		return play()
	}
}


