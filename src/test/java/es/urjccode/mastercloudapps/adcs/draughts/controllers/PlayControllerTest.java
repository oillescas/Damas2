package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 6);
        Coordinate target = new Coordinate(4, 7);
        PlayController playController = new PlayControllerBuilder().build();
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereOpositThenErrorOpositePiece() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayControllerBuilder().build();
        assertEquals(playController.move(origin, target), Error.OPPOSITE_PIECE);
        assertNull(playController.getPiece(target));
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereNotDiagonalThenErrorNotDiagonal() {
        Coordinate origin = new Coordinate(5, 6);
        Coordinate target = new Coordinate(5, 5);
        PlayController playController = new PlayControllerBuilder().build();
        assertEquals(playController.move(origin, target), Error.NOT_DIAGONAL);
        assertNull(playController.getPiece(target));
    }

    // public void data(){
    //     Coordinate[][] coordinates = new Coordinate[][] {
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //     };

        // peon mueve una
        // peon come una
    //}


}