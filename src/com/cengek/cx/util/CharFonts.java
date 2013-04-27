//Dikembangkan dari http://budsus.wordpress.com/2009/02/12/431/

package com.cengek.cx.util;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

import com.cengek.cx.sprites.Char;

public class CharFonts {

	private static String sequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+1234567890-={}|[]\\:\";\'<>?,./";
	private static Hashtable fontChars;
	
	public static void initialise(String fontName) throws IOException{
		fontChars = new Hashtable();
		for (int i = 0; i < sequence.length(); i++) {
			char c = sequence.charAt(i);
			int code = c;
			fontChars.put(new Integer(code),
					Image.createImage("/"+fontName+"/"+code+".png"));
		}
	}
	
	public static Image drawCharImage(char ch){
		if (ch != ' ') {
			int i = sequence.indexOf(ch);
			if (i == -1) {
				throw new IllegalArgumentException("unsupported character");
			}
		}else{
			Image img = null; 
			try {
				img = Image.createImage("/euphemia/space.png");
				
				return img;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int code = ch;
		Integer key = new Integer(code);
		Image img = (Image)fontChars.get(key);
		//int wChar = img.getWidth();
		
		return img;
	}
	
	public static int drawChar(Graphics g, char ch, int x, int y){
		if (ch != ' ') {
			int i = sequence.indexOf(ch);
			if (i == -1) {
				throw new IllegalArgumentException("unsupported character");
			}
		}else{
			return 5;	//untuk spasi
		}
		
		int code = ch;
		Integer key = new Integer(code);
		Image img = (Image)fontChars.get(key);
		int wChar = img.getWidth();
		g.drawImage(img, x, y, Graphics.TOP | Graphics.LEFT);
		return wChar;
	}
	
	public static int drawCharSprite(LayerManager lg, char ch, int x, int y, boolean landscape){
		if (ch != ' ') {
			int i = sequence.indexOf(ch);
			if (i == -1) {
				throw new IllegalArgumentException("unsupported character");
			}
		}else{
			return 5;//spasi
		}
		
		
		int code = ch;
		Integer key = new Integer(code);
		Image img = (Image)fontChars.get(key);
		int wChar = img.getWidth();
		
		if (landscape == true) {
			//buat sprite nya
			Char c = new Char(img);
			lg.append(c);
			c.setTransform(Sprite.TRANS_ROT90);
			c.setPosition(x, y);
		}else{
			//buat sprite nya
			Char c = new Char(img);
			lg.append(c);
			c.setPosition(x, y);
		}
		return wChar;
		
	}
	
	public static Sprite charSprite(char ch, int x, int y, boolean landscape){
		if (ch != ' ') {
			int i = sequence.indexOf(ch);
			if (i == -1) {
				throw new IllegalArgumentException("unsupported character");
			}
		}else{
			Image img = null; 
			try {
				img = Image.createImage("/euphemia/space.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Char c = new Char(img);
			
			if (landscape == true){
				c.setTransform(Sprite.TRANS_ROT90);
			}
			
			c.setPosition(x, y);
			
			return (Sprite)c;
		}
		
		
		int code = ch;
		Integer key = new Integer(code);
		Image img = (Image)fontChars.get(key);
		//int wChar = img.getWidth();
		
		if (landscape == true) {
			//buat sprite nya
			Char c = new Char(img);
			c.setTransform(Sprite.TRANS_ROT90);
			c.setPosition(x, y);
			
			return (Sprite)c;
			
		}else{
			//buat sprite nya
			Char c = new Char(img);
			
			c.setPosition(x, y);
			return (Sprite)c;
		}
		
	}
	
	public static void drawString(Graphics g, String s, int x, int y){
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++){
			x += drawChar(g, chs[i], x, y);
		}
	}
	
	public static void drawStringSprite(LayerManager lg, String s, int x, int y, boolean landscape){
		
		if (landscape == true) {
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++){
				y += drawCharSprite(lg, chs[i], x, y, true);
			}
		}else{
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++){
				x += drawCharSprite(lg, chs[i], x, y, false);
			}
		}
	}
	
	public static Vector getVectorStringSprite(LayerManager lg, String s, int x, int y, boolean landscape, int width){
		
		Vector sprites = new Vector();
		
		int maxHeight = 0;
		int maxWidth = 0;
		
		int initY = y;
		int initX = x;
		
		int spacing = 5;
		
		if (landscape == true) {
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++){
				Sprite sprChar = charSprite(chs[i], x, y, true);
				
				int charHeight = sprChar.getHeight();
				
				y += charHeight;
				
				if (maxHeight < charHeight) {
					maxHeight = charHeight;
				}
				
				//untuk wrapping text
				if (width > 0) {
					if (y > width) {
						x -= maxHeight+spacing;
						y = initY;
					}
				}
						
				sprites.addElement(sprChar);
			}
		}else{
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++){
				Sprite sprChar = charSprite(chs[i], x, y, false);
				int charWidth = sprChar.getWidth();
				
				x += charWidth;
				
				if (maxWidth < charWidth) {
					maxWidth = charWidth;
				}
				
				//untuk wrapping text
				if (width > 0) {
					if (x > width) {
						y += maxWidth+spacing;
						x = initX;
					}
				}
				sprites.addElement(sprChar);
			}
		}
		
		return sprites;
	}
	
	
}
