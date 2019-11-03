package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session) {
		super(session);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	public void resume(boolean resume) {
		if(resume) {
			this.session.reset();
		}else {
			this.session.next();
		}
	}

}
