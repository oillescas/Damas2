package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Session {
	
	private Game game;
	private State state;
	
	
	public Session(Game game, State state) {
		this.game = game;
		this.state = state;
	}


	public StateValue getValueState() {
		return state.getValueState();
	}


	public Error move(Coordinate origin, Coordinate target) {
		return game.move(origin, target);
	}


	public void next() {
		this.state.next();
		
	}

	public void reset() {
		this.game.reset();
		this.state.reset();
	}


	public Color getTurn() {
		return this.game.getTurn();
	}


	public Piece getPiece(Coordinate origin) {
		return this.game.getPiece(origin);
	}


	public boolean isFinish() {
		return this.game.isFinish();
	}
}


