package main;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.cengek.cx.manager.GameManager;
import com.cengek.cx.util.RMS;

import com.nokia.mid.ui.VirtualKeyboard;

public class GameMidlet extends MIDlet {

	GameManager gm;
	private RMS rms = new RMS();
	Display display;
	
	public GameMidlet() {
		// TODO Auto-generated constructor stub
		gm = new GameManager(this);
		VirtualKeyboard.hideOpenKeypadCommand(true);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		display = Display.getDisplay(this);
		display.setCurrent(gm);
		
		gm.start();
		
	}
	
	public RMS getRMS(){
		return rms;
	}

}
