
class Tournament(val players: Array[Player]) {
	def run() = {
		val game = new Game(players(0), players(1))
		game.play()
		1
	}
}




