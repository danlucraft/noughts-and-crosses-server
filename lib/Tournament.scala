
class Tournament(val players: Array[Player]) {
    var games:List[Game] = List()
    
    for (a <- players; b <- players if a != b) {
        games = new Game(a, b) :: games
    }

/*    def printResults() {
        games
    }
*/    
	def run() = {
	    for (game <- games) {
	        println("## Starting game: " + game)
    		val winner = game.play()
    		winner match {
    		    case Some(p) => println("WINNER: " + p)
    		    case None    => println("DRAW")
    		}
		}
//		printResults()
		1
	}
}




