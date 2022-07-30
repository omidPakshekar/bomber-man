package BomberMan.Game.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import BomberMan.Game.ImageLoader.ImageLoader;

public class Star {
	private int x, y;
	private Rectangle bounds;
	public static long LastTime ;
	
	public Star(int x , int y) {
		this.x = x;
		this.y = y;
		LastTime =System.currentTimeMillis();
		bounds = new Rectangle(0, 0, 32, 32);

	}

	public void Draw(Graphics g) {
		g.drawImage(ImageLoader.star, x, y, 32, 32, null);
	
	}

	public void update() {

	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, bounds.width, bounds.height);

	}
	
	public long getTime() {
		return LastTime;
	}

}
