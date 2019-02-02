package tests

import domain.GameImplementation
import domain.Move
import domain.RefereeImplementation
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class RefereeTest {
    private val game = GameImplementation()
    private lateinit var referee: RefereeImplementation

    @Before
    fun setUp() {
        referee = RefereeImplementation(game)
    }

    @Test
    fun rockWins() {
        game.move1 = Move.Rock
        game.move2 = Move.Scissors
        assertEquals(referee.declareGameResult(), Move.Rock)
        game.move1 = Move.Scissors
        game.move2 = Move.Rock
        assertEquals(referee.declareGameResult(), Move.Rock)
    }

    @Test
    fun paperWins() {
        game.move1 = Move.Rock
        game.move2 = Move.Paper
        assertEquals(referee.declareGameResult(), Move.Paper)
        game.move2 = Move.Paper
        game.move1 = Move.Rock
        assertEquals(referee.declareGameResult(), Move.Paper)
    }

    @Test
    fun scissorsWins() {
        game.move1 = Move.Paper
        game.move2 = Move.Scissors
        assertEquals(referee.declareGameResult(), Move.Scissors)
        game.move2 = Move.Scissors
        game.move1 = Move.Paper
        assertEquals(referee.declareGameResult(), Move.Scissors)
    }

    @Test
    fun drawRock() {
        game.move1 = Move.Rock
        game.move2 = Move.Rock
        assertEquals(referee.declareGameResult(), null)
    }

    @Test
    fun drawPaper() {
        game.move1 = Move.Paper
        game.move2 = Move.Paper
        assertEquals(referee.declareGameResult(), null)
    }

    @Test
    fun drawScissors() {
        game.move1 = Move.Scissors
        game.move2 = Move.Scissors
        assertEquals(referee.declareGameResult(), null)
    }
}