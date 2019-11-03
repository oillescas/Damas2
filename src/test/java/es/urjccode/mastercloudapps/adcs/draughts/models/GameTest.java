package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GameTest {
	
    private Game game;


    public GameTest() {
        game = new Game();
    }



    @Test
    public void testGivenGameWhenMoveEmptySquaerThenEmptySquareError() {
        assertEquals(Error.EMPTY_ORIGIN, game.move(new Coordinate(4, 3), new Coordinate(3, 4)));
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
        Error error = game.move(new Coordinate(2, 1),new Coordinate(3, 0));
        assertEquals(Error.OPPOSITE_PIECE, error);
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        assertEquals(Error.NOT_DIAGONAL, this.game.move(new Coordinate(5, 2), new Coordinate(4, 2)));
    }


    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        assertEquals(Error.EATING_EMPTY, this.game.move(new Coordinate(5, 4), new Coordinate(3, 2)));
    }

    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        assertEquals(Error.BAD_DISTANCE, this.game.move(new Coordinate(5, 0), new Coordinate(2, 3)));
    }

}