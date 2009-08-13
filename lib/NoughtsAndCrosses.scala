
object NoughtsAndCrosses {
	def printMove(move: Option[(Int, Int)]) = move match {
		case Some(x) => println(x)
		case None    => println("No valid move")
	}
	
	def main(args: Array[String]) {
		new Tournament(Array(
		    RandomPlayer,
//		    StupidPlayer,
//		    EagerPlayer
            new ExternalPlayer("Random1", "/Users/danlucraft/projects/noughts-and-crosses/bin", "scala RandomPlayer"), 
            new ExternalPlayer("Random2", "/Users/danlucraft/projects/noughts-and-crosses/bin", "scala RandomPlayer"), 
 //   		new ExternalPlayer("Stupid", "/Users/danlucraft/projects/noughts-and-crosses/bin", "scala StupidPlayer"))
    	    )).run()
	}
}

