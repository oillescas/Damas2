package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    YesNoDialog yesNoDialog;

    @InjectMocks
    ResumeView resumeView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenResumeViewWhenNewGameRequiereCorrectThenNotError() {
        when(yesNoDialog.read("¿Queréis jugar otra? (s/n):")).thenReturn(true);
        resumeView.resume();
        verify(resumeController).resume(true);
    }

    @Test
    public void givenResumeViewWhenEndGameRequiereCorrectThenNotError() {
        when(yesNoDialog.read("¿Queréis jugar otra? (s/n):")).thenReturn(false);
        resumeView.resume();
        verify(resumeController).resume(false);
    }

}