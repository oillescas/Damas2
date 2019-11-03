package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

class StartView {
	
	private Console console;
	private StartController startController;
	
	StartView(StartController startController){
		this.startController = startController;
		this.console = new Console();
	}
	
	
	void start(){
		this.console.writeln("Las Damas!!!");
		this.startController.start();
	}

}
 