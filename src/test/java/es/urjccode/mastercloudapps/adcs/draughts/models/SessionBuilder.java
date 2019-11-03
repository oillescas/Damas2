package es.urjccode.mastercloudapps.adcs.draughts.models;

/**
 * SessionBuilder
 */
public class SessionBuilder {

    private Game game;
    private State state;

    public SessionBuilder(){
        this.game = new Game();
        this.state = new State();
    }

    public SessionBuilder setGame(Game game) {
        this.game = game;
        return this;
    }

    public SessionBuilder setState(State state) {
        this.state = state;
        return this;
    }

    public Session build(){
        return new Session(this.game, this.state);
    }
    
}