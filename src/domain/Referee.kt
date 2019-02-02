package domain

interface Referee {

    fun declareGameMoves()
    fun declareGameResult(): Move?
}