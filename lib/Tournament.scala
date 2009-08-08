
class Game(val a:Player, val b:Player) {
	def board = new Board(3)
	
	def treequel(x:Int, y:Int, z:Int) = (x == y) && (y == z)
	
	def intToPlayer(i:Int): Option[Player] = i match {
		case 0 => None
		case 1 => Some(a)
		case 2 => Some(b)
	}
	
	def moveCount(i:Int): Int = {
		board.coords(i).length
	}
	
	def toMove() = {
		if(moveCount(1) > moveCount(2))
		  2
		else
		  1
	}
	
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
		if(toMove() == 1) {
	      println(a)
		  println(a.move(board, 1))
		}
		else {
	      println(a)
		  println(b.move(board, 2))
		}
	}
}

class Tournament(val players: Array[Player]) {
	def run() = {
		val game = new Game(players(0), players(1))
		game.play()
		1
	}
}




