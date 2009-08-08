
class Board(val size: Int) {
	val board = Array.make(size, 0).map(_ => Array.make(size, 0))
	val symbolMap = Map(0 -> ".", 1 -> "o", 2 -> "x")
		
	def prettyRow(row:Array[Int]) = row.map((x:Int) => symbolMap(x)).mkString(" ")
	def pretty                    = board.map(prettyRow(_)).mkString("\n")
	
	def set(x:Int, y:Int, v:Int) { board(x)(y) = v }
	def apply(x:Int, y:Int) = board(x)(y)
	
	def coords(i:Int): List[(Int, Int)] = {
		var a:List[(Int, Int)] = List()
		for(i <- 0 to size - 1; j <- 0 to size - 1)
		  if(apply(i, j) == i)
		    a = (i, j) :: a
		a
	}
	
	def blanks() = coords(0)
}

object Board {
	def fromString(str: String) = {
		val board = new Board(3)
		val ints = str.split("").subArray(1, 10).map(_.toInt)
		for (i <- 0 to 2; j <- 0 to 2) 
		  board.set(i, j, ints(i*3 + j))
        board
	}
}
