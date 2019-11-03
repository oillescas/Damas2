package es.urjccode.mastercloudapps.adcs.draughts;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.draughts.views.View;

public class Draughts {
	
	private Logic logic;
    private View view;

    protected Draughts() {
        this.logic = new Logic();
        this.view = new View();
    }
    
    protected void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null) {
                this.view.interact(acceptorController);
            }
        } while (acceptorController != null);
    }
    

    public static void main(String[] args) {
        new Draughts().play();
    }

}
