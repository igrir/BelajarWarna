package screens;
/*
 * 
 * YA AMPUUUN, jadi berantakan gini
 * seharusnya kalau tulisan ya tulisan aja diaturnya
 * terus kalau game isinya logic game aja
 * 
 * Harusnya dibikin juga kelas khusus untuk handling button
 * 
 * Nanti deh ya kedepannya kita perbaiki
 * 
 */


import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDlet;

import sprites.logo;
import sprites.tombol;

import com.cengek.cx.manager.GameManager;
import com.cengek.cx.screens.Screen;

public class ScreenGame extends Screen {


	public ScreenGame(Graphics g, MIDlet m, LayerManager lg, GameManager host) {
		// TODO Auto-generated constructor stub
		super(g, m, lg, host);


		init();

	}

	
	
	public void draw() {

		host.setLg(selflg);
		
		
	}
	

	public void run() {
		

		
	}



	public void init() {
		// TODO Auto-generated method stub
		tombol t = new tombol();
		logo l = new logo();
		l.setTransform(Sprite.TRANS_ROT90);
		t.setTransform(Sprite.TRANS_ROT90);
		
		selflg.append(t);
		selflg.append(l);
		
		l.setPosition(host.getHeight()/2-(l.getHeight()/2), host.getWidth()/2-(l.getWidth()/2));
		
		
	}



	public void pointerPressed(int x, int y) {
		// TODO Auto-generated method stub
		
		
		
	}



	public void pointerReleased(int x, int y) {
		// TODO Auto-generated method stub
		host.setCurrentScreen((Screen)host.getScreenVector().elementAt(1));
	}



	public void createImages() {
		// TODO Auto-generated method stub
		
	}



	public void removeSprites() {
		// TODO Auto-generated method stub
		
	}

	
	
}
