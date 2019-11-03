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

public class GameTestMock {
	

	@InjectMocks
    private Game game;

	@Mock
    private Board board;
	
	@Mock
	private Turn turn;
    

    public GameTestMock() {
        game = new Game();
    }

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        Coordinate destiny = Mockito.mock(Coordinate.class);
        when(destiny.isValid()).thenReturn(false);
        Error error = game.move(new Coordinate(4, 7), destiny);
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void testGivenGameWhenNotEmptyTargeThenError() {
        Coordinate origin = new Coordinate(5, 6);
        Coordinate target = new Coordinate(4, 7);
        Piece mockPiece = Mockito.mock(Piece.class);
        
        when(mockPiece.isAdvanced(origin, target)).thenReturn(true);
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(turn.isColor(Color.WHITE)).thenReturn(true);
        when(board.getPiece(origin)).thenReturn(mockPiece);
        when(board.isEmpty(target)).thenReturn(false);
        
        Error error = game.move(origin, target);
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }


    @Test
    public void testGivenGameWhenMovementThenEatPiece() {
                
        Coordinate origin = Mockito.mock(Coordinate.class);
        Coordinate target = new Coordinate(5, 2);
        Piece betweenPiece = Mockito.mock(Piece.class);
        Coordinate betweenCoordinate = Mockito.mock(Coordinate.class);
        
        when(origin.isValid()).thenReturn(true);
        when(origin.isDiagonal(target)).thenReturn(true);
        when(origin.betweenDiagonal(target)).thenReturn(betweenCoordinate);
        when(betweenPiece.isAdvanced(origin, target)).thenReturn(true);
        when(board.getColor(origin)).thenReturn(Color.WHITE).thenReturn(null);
        when(turn.isColor(Color.WHITE)).thenReturn(true);
        when(board.getPiece(origin)).thenReturn(betweenPiece);
        when(board.getPiece(betweenCoordinate)).thenReturn(null);
        when(board.isEmpty(target)).thenReturn(true);
        when(board.getColor(target)).thenReturn(Color.BLACK);
        when(board.getColor(betweenCoordinate)).thenReturn(null);
      
        Error error = game.move(origin, target);
        assertNull(error);
        assertNull(game.getColor(origin));
        assertNull(game.getColor(betweenCoordinate));
        assertEquals(Color.BLACK, game.getColor(target));
    }


}