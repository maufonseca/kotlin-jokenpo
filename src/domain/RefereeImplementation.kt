package domain

class RefereeImplementation(private val game: Game): Referee {

    private fun declareDraw() = println("Draw! Playing again...\n")

    private fun declareWinner(move: Move) = println("${move.name} wins!")

    override fun declareGameMoves() {
        println("${game.move1.name} thrown!")
        println("${game.move2.name} thrown!")
    }

    private fun compareRockTo(move: Move): Move? {
        return when(move) {
            Move.Rock -> { declareDraw(); null }
            Move.Paper -> { declareWinner(Move.Paper); Move.Paper }
            Move.Scissors -> { declareWinner(Move.Rock); Move.Rock }
        }
    }

    private fun comparePaperTo(move: Move): Move? {
        return when(move) {
            Move.Rock -> { declareWinner(Move.Paper); Move.Paper }
            Move.Paper -> { declareDraw(); null }
            Move.Scissors -> { declareWinner(Move.Scissors); Move.Scissors}
        }
    }

    private fun compareScissorsTo(move: Move): Move? {
        return when(move) {
            Move.Rock -> { declareWinner(Move.Rock); Move.Rock }
            Move.Paper -> { declareWinner(Move.Scissors); Move.Scissors }
            Move.Scissors -> { declareDraw(); null }
        }
    }

    override fun declareGameResult(): Move? {
        with(game) {
            return when(move1) {
                Move.Rock -> compareRockTo(move2)
                Move.Paper -> comparePaperTo(move2)
                else -> compareScissorsTo(move2)
            }
        }
    }
}