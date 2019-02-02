import domain.Game
import domain.GameImplementation
import domain.Referee
import domain.RefereeImplementation

fun main(args: Array<String>) {

    val game: Game = GameImplementation()
    val referee: Referee = RefereeImplementation(game)

    //play until we have a winner
    while(true) {
        game.setupMoves()
        referee.declareGameMoves()
        if(referee.declareGameResult() != null) break
    }
}