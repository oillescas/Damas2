package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import java.util.HashMap;
import java.util.Map;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class Logic {

    private Session session;
    private State state;
    private Game game;

    protected Map<StateValue, AcceptorController> acceptorControllers;

    public Logic() {
    	this.game = new Game();
    	this.state = new State();
    	this.session = new Session(game, state);
        this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
        
        this.acceptorControllers.put(StateValue.INITIAL, new StartController(this.session));
        this.acceptorControllers.put(StateValue.OPENED_GAME, new PlayController(this.session));
        this.acceptorControllers.put(StateValue.FINAL, new ResumeController(this.session));
        this.acceptorControllers.put(StateValue.EXIT, null);
        
    }

    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }
}

