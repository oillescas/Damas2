package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

import java.util.regex.Pattern;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView {

    private Console console;

    private PlayController playController;

    private static final String[] COLORS = {"blancas", "negras"};

    public CommandView(PlayController playController){
        this.playController = playController;
        this.console = new Console();
    }

    public void interact() {
        String color = CommandView.COLORS[playController.getTurnColor().ordinal()];
        Error error = null;
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            if(!Pattern.matches("\\d\\d\\.\\d\\d\\\n", command)) {
            	error = Error.FORMAT_ERROR;
            }else {
				int origin = Integer.parseInt(command.substring(0, 2));
				int target = Integer.parseInt(command.substring(3, 5));
				error = playController.move(new Coordinate(origin/10, origin%10), new Coordinate(target/10, target%10));
            }
            if (error != null){
                console.write("Error!!!" + error.name());
            }
        } while (error != null);  
    }

}