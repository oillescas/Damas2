package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoardEndTest {

	@InjectMocks
	private Board board;
	
	@Mock
	private Square[][] squares;
	
	public BoardEndTest() {
		this.board= new Board();
	}
	
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	
    @Test
    public void testGivenGameWhenThereAreMovementsThenGetFalse() {
        assertFalse(board.noMoreMoves(Color.BLACK));
        assertFalse(board.noMoreMoves(Color.WHITE));
    }

    @Test
    public void testGivenGameWhenThereArePiecesThenGetFalse() {
        assertFalse(board.noMorePieces(Color.BLACK));
        assertFalse(board.noMorePieces(Color.WHITE));
    }

}
