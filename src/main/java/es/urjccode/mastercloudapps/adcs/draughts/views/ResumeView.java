package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

public class ResumeView {
	
	private ResumeController resumeController;
	private YesNoDialog yesNoDialog;

	ResumeView(ResumeController resumeController){
		this.resumeController = resumeController;
		this.yesNoDialog = new YesNoDialog();
	}
	
	void resume() {
		resumeController.resume(this.yesNoDialog.read("¿Queréis jugar otra? (s/n):"));
	}
}

