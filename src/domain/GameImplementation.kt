package domain

class GameImplementation: Game {

    override lateinit var move1: Move
    override lateinit var move2: Move

    override fun setupMoves() {
        move1 = randomMove()
        move2 = randomMove()
    }

    private fun randomMove() = listOf(Move.Rock, Move.Paper, Move.Scissors).shuffled()[0]
}