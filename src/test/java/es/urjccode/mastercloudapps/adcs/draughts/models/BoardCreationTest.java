package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BoardCreationTest {

    private Board board;
    @Parameter(0) public Coordinate coordinate;
    @Parameter(1) public Color color;
    @Parameter(2) public String text;

    public BoardCreationTest() {
         this.board = new Board();
    }


    @Parameters(name = "{2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
            { new Coordinate(0, 0), null, "Corner 0,0 whithout piece"},
            { new Coordinate(0, 7), Color.BLACK, "Corner 0,7 whith black piece"},
            { new Coordinate(7, 0), Color.WHITE, "Corner 7,0 whith white piece"},
            { new Coordinate(7, 7), null, "Corner 0,0 whithout piece"},
            { new Coordinate(5, 0), Color.WHITE, "Board middle 5,0 whith white piece"},
            { new Coordinate(2, 3), Color.BLACK, "board middle 2,3 whith black piece"},
		});
    }
    
    @Test
    public void testGivenNewBoardThenGoodLocations() {
        assertEquals(this.color, this.board.getColor(this.coordinate));
    }
    

    
}