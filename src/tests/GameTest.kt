package tests

import domain.GameImplementation
import domain.Move
import org.junit.Assert.*
import org.junit.Before

class GameTest {

    val game = GameImplementation()

    @Before
    fun setUp() {
        game.move1 = Move.Paper
        game.move2 = Move.Paper
    }

    @org.junit.Test
    fun move1() {
        game.move1 = Move.Rock
        assertEquals(game.move1, Move.Rock)
    }


    @org.junit.Test
    fun move2() {
        game.move2 = Move.Rock
        assertEquals(game.move2, Move.Rock)
    }


    @org.junit.Test
    fun getMoves() {
        game.setupMoves()
        assertNotNull(game.move1)
        assertNotNull(game.move2)
    }
}