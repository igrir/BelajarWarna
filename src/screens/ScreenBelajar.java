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


import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDlet;

import sprites.logo;
import sprites.tombol;
import sprites.warna;

import com.cengek.cx.manager.GameManager;
import com.cengek.cx.screens.Screen;
import com.cengek.cx.util.CharFonts;
import com.cengek.cx.util.SpriteText;

public class ScreenBelajar extends Screen {


	warna warnaMerah;
	warna warnaBiru;
	warna warnaKuning; 
	
	SpriteText st = new SpriteText("euphemia", selflg, 30, 10, true, 100);
	
	int menu = 0;	//1 merah, 2 biru, 3 kuning
	
	public ScreenBelajar(Graphics g, MIDlet m, LayerManager lg, GameManager host) {
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
		
		Vector v_sprites = new Vector();
		
		warnaMerah = new warna("/images/merah.png");
		warnaBiru = new warna("/images/biru.png");
		warnaKuning = new warna("/images/kuning.png");
		
		
//		warnaMerah.setTransform(Sprite.TRANS_ROT90);
//		warnaMerah.setPosition(host.getWidth()/2, 40);
//		selflg.append(warnaMerah);
//		
		v_sprites.addElement(warnaMerah);
		v_sprites.addElement(warnaBiru);
		v_sprites.addElement(warnaKuning);
		
		
		for (int i  = 0; i < v_sprites.size(); i++) {
			Sprite ww = (Sprite)v_sprites.elementAt(i);
			
			ww.setTransform(Sprite.TRANS_ROT90);
			
			ww.setPosition(host.getWidth()/2, i*(ww.getWidth()+40));
			
			selflg.append(ww);
		}
		
		
		
		st.setText("Pilih satu warna");
		st.show();	
	}



	public void pointerPressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}



	public void pointerReleased(int x, int y) {
		// TODO Auto-generated method stub
	
		if (warnaMerah.isTouched(x, y)) {
			
			if (menu != 1) {
				st.setText("itu warna merah, seperti warna mawar");
				//st.show();
				st.showEachTick(80);
				menu = 1;
			}
			
			
		}
		
		if (warnaBiru.isTouched(x, y)) {
			
			if (menu != 2) {
				st.setText("Ini warna biru, seperti warna langit");
				//st.show();
				st.showEachTick(50);
				menu = 2;			
			}
		}
		
		if (warnaKuning.isTouched(x, y)) {
			
			if (menu != 3) {
				st.setText("itu warna kuning, seperti warna bunga matahari");
				//st.show();
				st.showEachTick(100);
				menu = 3;
				
			}
		}
		
	}



	public void createImages() {
		// TODO Auto-generated method stub
		
	}



	public void removeSprites() {
		// TODO Auto-generated method stub
		
	}

	
	
}
