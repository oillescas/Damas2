package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

public abstract class AcceptorController extends Controller {

    AcceptorController(Session session) {
        super(session);
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

}

