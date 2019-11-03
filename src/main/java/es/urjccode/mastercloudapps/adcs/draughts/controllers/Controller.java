package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

abstract class Controller {

    protected Session session;
    
    Controller(Session session){
    	this.session = session;
    }
}
