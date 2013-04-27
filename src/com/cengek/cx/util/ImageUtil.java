package com.cengek.cx.util;

import java.io.IOException;

import javax.microedition.lcdui.Image;

public class ImageUtil {

	public static ImageUtil iu = new ImageUtil();
	
	public ImageUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static ImageUtil getInstance(){
		return iu;
	}
	
	public Image createImage(String str){
		Image i = null;
		
		try {
			i = Image.createImage(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
}
