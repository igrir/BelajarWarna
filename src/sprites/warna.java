package sprites;

import com.cengek.cx.sprites.CXSprite;
import com.cengek.cx.util.ImageUtil;

public class warna extends CXSprite {

	public String warna = "";
	
	public warna(String res) {
		super(ImageUtil.getInstance().createImage(res));
		// TODO Auto-generated constructor stub
	}

}
