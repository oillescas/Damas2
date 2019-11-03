package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.SessionBuilder;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

/**
 * PlayControllerBuilder
 */
public class PlayControllerBuilder {

    private SessionBuilder sessionBuilder;

    public PlayControllerBuilder(){
        this.sessionBuilder = new SessionBuilder();
    }

    public PlayControllerBuilder setGame(Game game){
        this.sessionBuilder.setGame(game);
        return this;
    }

    public PlayControllerBuilder setState(State state){
        this.sessionBuilder.setState(state);
        return this;
    }

    public PlayController build(){
        return new PlayController(this.sessionBuilder.build());
    }
    
    
}