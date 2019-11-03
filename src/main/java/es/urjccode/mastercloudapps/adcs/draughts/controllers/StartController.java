package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

public class StartController extends AcceptorController {

	StartController(Session session) {
		super(session);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	
	public void start() {
		this.session.next();
	};

}
