package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class BoardView {

	private Console console;
	private PlayController playController;
	private static final int BOARD_DIMENSION = 8;
	
	public BoardView(PlayController playController) {
		this.console = new Console();
		this.playController = playController;
	}
	
	
	public void writeBoard() {
		 String string = " ";
	        for (int j = 0; j < BOARD_DIMENSION; j++) {
	            string += j;
	        }
	        string += "\n";
	        for (int i = 0; i < BOARD_DIMENSION; i++) {
	            string += i;
	            for (int j = 0; j < BOARD_DIMENSION; j++) {
	                Piece piece = playController.getPiece(new Coordinate(i, j));
	                if (piece == null) {
	                    string += " ";
	                } else if (piece.isBlack()) {
	                    string += "n";
	                } else {
	                    string += "b";
	                }
	            }
	            string += i + "\n";
	        }
	        string += " ";
	        for (int j = 0; j < BOARD_DIMENSION; j++) {
	            string += j;
	        }
	        
	        
	        console.write(string);
	}
}
