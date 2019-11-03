package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenTwoCoordinatesWhenBettweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 4)));
    }

    @Test
    public void testGivenTwoCoordinatesWhenDiagonalMoreOneSquareThenGetDistance() {
        assertEquals(4, new Coordinate(4, 4).diagonalDistance(new Coordinate(0, 0)));
        assertEquals(3,new Coordinate(0, 0).diagonalDistance(new Coordinate(3, 3)));
        assertEquals(7,new Coordinate(0, 0).diagonalDistance(new Coordinate(7, 7)));
    }

    @Test
    public void  testGivenTwoCoordinatesInSameDiagonalThenTrue(){
        assertTrue(new Coordinate(0,0).isDiagonal(new Coordinate(7, 7)));
        assertTrue(new Coordinate(4,2).isDiagonal(new Coordinate(2, 0)));
    }

    
    @Test
    public void  testGivenTwoCoordinatesNotInSameDiagonalThenFalse(){
        assertFalse(new Coordinate(0,0).isDiagonal(new Coordinate(0, 7)));
        assertFalse(new Coordinate(0,0).isDiagonal(new Coordinate(4, 6)));
    }

    @Test(expected = AssertionError.class)
    public void givenTwoCoordinateWhenOneIsOutOfBoardThenException(){
        new Coordinate(0,0).diagonalDistance(new Coordinate(2, 8));
    }
}