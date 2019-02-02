package domain

interface Game {
    var move1: Move
    var move2: Move

    fun setupMoves()
}