package com.cengek.cx.sprites;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class CXSprite extends Sprite{
	public CXSprite(Image arg0) {
		super(arg0);
	}

	public boolean isTouched(int x, int y){
		if (this.getX() <= x &&
			this.getX()+this.getWidth() >= x &&
			this.getY() <= y &&
			this.getY()+this.getHeight() >= y) {
			return true;
		}else{
			return false;
		}
	}
}
