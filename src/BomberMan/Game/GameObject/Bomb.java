package BomberMan.Game.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import BomberMan.Game.ImageLoader.ImageLoader;
import BomberMan.Game.tiles.Tile;

public class Bomb {
	private int x, y;
	private Rectangle bounds;
	public static int ShoayeTrkidn = 1;
	private long LastTime;

	public Bomb(int x, int y) {

		this.x = x;
		this.y = y;
		LastTime = System.currentTimeMillis();
		bounds = new Rectangle(0, 0, Tile.TILEWIDTH * 4, Tile.TILEHEIGHT * 2);

	}

	public void Draw(Graphics g) {
		g.drawImage(ImageLoader.bomb, bounds.x + x, bounds.y + y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x - (int) (bounds.width / 2), y, bounds.width * ShoayeTrkidn,
				bounds.height * ShoayeTrkidn);

	}

	public long getTime() {
		return LastTime;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
