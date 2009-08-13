
class Tournament(val players: Array[Player]) {
    var games:List[Game] = List()
    
    for (a <- players; b <- players if a != b) {
        games = new Game(a, b) :: new Game(a, b) :: games
    }

    def printResults() {
        println("### Game Results")
        for (game <- games) 
            if (game.winnerByDefault() != None)
                println(game + " .... " + game.winnerByDefault().get + " (by default)")
            else
                println(game + " .... " + game.winner().getOrElse("Draw"))
                
        println()
        println("### Leaderboard")
        println("Player             Score       Losses")
        for (player <- players) { 
            var score = 0
            var losses = 0
            for (game <- games if game.a == player || game.b == player) {
                if (game.winner() == None)
                    score += 1
                else if (game.winner().get == player)
                    score += 2
                else 
                    losses += 1
            }
            println(player + "    " + score + "       " + losses)
        }
    }
    
	def run() = {
	    for (game <- games) {
	        println("## Starting game: " + game)
    		val winner = game.play()
    		winner match {
    		    case Some(p) => println("WINNER: " + p)
    		    case None    => println("DRAW")
    		}
    		println()
		}
		println()
		printResults()
		1
	}
}




