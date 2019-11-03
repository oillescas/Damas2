package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;

public class View implements ControllerVisitor {

    public void interact(AcceptorController acceptorController) {
    	acceptorController.accept(this);
    };

	@Override
	public void visit(StartController startController) {
		new StartView(startController).start();
	}

	@Override
	public void visit(PlayController playController) {
		new PlayView(playController).play();
	}

	@Override
	public void visit(ResumeController resumeController) {
		new ResumeView(resumeController).resume();
	}

}