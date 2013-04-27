package com.cengek.cx.util;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

public class SpriteText {

	Vector v = new Vector();
	LayerManager lg;
	
	int x, y;
	boolean landscape;
	
	boolean isAppended;
	
	private Timer timer;
	private TTShowEachTick ttse;
	
	private int width = 0;
	
	public SpriteText(String fontName, LayerManager lg, int x, int y, boolean landscape, int width) {
		// TODO Auto-generated constructor stub
		
		//buat karakter
		try {
			CharFonts.initialise(fontName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.lg = lg;
		
		this.x = x;
		this.y = y;
		
		this.landscape = landscape;
		this.isAppended = false;

		this.width = width;
		
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void removeText(){
		
		//cek apakah ada di layer manager
		//agar tahu bisa dihapus
		if (isAppended == true) {
			
			//hapus text di layer manager
			for (int i = 0; i < v.size(); i++) {
				Sprite cc = (Sprite)v.elementAt(i);
				
				lg.remove(cc);
			}
			
			//hapus text di vector
			v.removeAllElements();
			v.setSize(0);
			
			isAppended = false;
		}

	}
	
	public void setText(String s){
		
		removeText();
		
		v = CharFonts.getVectorStringSprite(lg, s, x, y, landscape, width);
	}
	
	
	//mengganti isi teks
	public void resetText(String s){
		removeText();
		
		setText(s);
	}
	
	//menaruh text di layer manager
	public void show(){
		
		
		//cek dulu apakah sudah ditaruh agar tidak berulang kali
		if (!isAppended) {
			for (int i = 0; i < v.size(); i++) {
				Sprite cc = (Sprite)v.elementAt(i);
				lg.append(cc);
			}
			
			isAppended = true;	
		}
		
	}
	
	public void setVisible(boolean visible){
		
		if (isAppended) {
			for (int i = 0; i < v.size(); i++) {
				Sprite cc = (Sprite)v.elementAt(i);
				cc.setVisible(visible);
			}
			
		}
	}
	
	public void showEachTick(int tick){
		
		if (timer != null) {
			timer.cancel();
		}
		
		
		//cek dulu apakah sudah ditaruh agar tidak berulang kali
		if (!isAppended) {
			for (int i = 0; i < v.size(); i++) {
				Sprite cc = (Sprite)v.elementAt(i);
				
				cc.setVisible(false);
				lg.append(cc);
			}
			
			isAppended = true;	
		}
		
		ttse = new TTShowEachTick();
		timer = new Timer();
		timer.schedule(ttse, 0, tick);
		
		
	}
	
	
	private class TTShowEachTick extends TimerTask{
		int index = 0;
		
		public void run() {
			// TODO Auto-generated method stub
			if (index < v.size()) {
				Sprite cc = (Sprite)v.elementAt(index);
				cc.setVisible(true);
				index++;
			}else{
				timer.cancel();
			}
			
		}
	}
	
}
