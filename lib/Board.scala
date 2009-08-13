
class Board(val size: Int) {
	val board:Array[Array[Option[Int]]] = Array.make(size, 0).map(_ => Array.make(size, None))
	val symbolMap = Map(None -> ".", Some(1) -> "o", Some(2) -> "x")

	def prettyRow(row:Array[Option[Int]]) = row.map((x:Option[Int]) => symbolMap(x)).mkString(" ")
	def pretty                            = board.map(prettyRow(_)).mkString("\n")
	
	def update(x:Int, y:Int, v:Option[Int]) { board(x)(y) = v }
	
	def apply(x:Int, y:Int) = board(x)(y)

	def coords(v:Option[Int]): List[(Int, Int)] = {
		var a:List[(Int, Int)] = List()
		for (i <- 0 to size - 1; j <- 0 to size - 1)
		  if (apply(i, j) == v)
		    a = (i, j) :: a
		a
	}
	
	def line(): String = 
	  board.map(_.map((x:Option[Int]) => symbolMap(x)).mkString("")).mkString("")
	
	def blanks() = coords(None)
}

object Board {
	val intMap    = Map("." -> None, "o" -> Some(1), "x" -> Some(2))

	def fromString(str: String) = {
		val board = new Board(3)
		val symbols = str.split("").subArray(1, 10)
		for (i <- 0 to 2; j <- 0 to 2) {
		  val symbol = symbols(i*3 + j)
		  board(i, j) = intMap(symbol)
		}
        board
	}
}
