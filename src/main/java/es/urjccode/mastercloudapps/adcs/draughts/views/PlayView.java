package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class PlayView {
	private PlayController playController;
	private CommandView comandView;
	private BoardView boardView;
	private Console console;
	
	
	public PlayView(PlayController playController) {
		this.playController = playController;
		this.comandView = new CommandView(playController);
		this.boardView = new BoardView(playController);
		this.console = new Console();
	}
	
	public void play() {
		this.boardView.writeBoard();
		if(playController.isFinish()) {
			this.console.writeln("Derrota!!! No puedes mover tus fichas!!!");
			this.playController.finish();
		}else {
			this.comandView.interact();			
		}
	}
}
