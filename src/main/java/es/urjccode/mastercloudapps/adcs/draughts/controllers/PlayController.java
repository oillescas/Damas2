package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayController extends AcceptorController{

	private Session session;

    public PlayController(Session session) {
    	super(session);
		this.session = session;
	}

	public Error move(Coordinate origin, Coordinate target){
		return this.session.move(origin, target);
    }

	public Piece getPiece(Coordinate origin) {
		return this.session.getPiece(origin);
	}

	public Color getTurnColor() {
		return session.getTurn();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
		
	}

	public boolean isFinish() {
		return this.session.isFinish();
	}

	public void finish() {
		this.session.next();
	}
}