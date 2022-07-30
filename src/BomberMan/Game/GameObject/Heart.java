package BomberMan.Game.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import BomberMan.Game.Creature.Player;
import BomberMan.Game.ImageLoader.ImageLoader;

public class Heart {
	private Player player;
	private Rectangle bounds;
	private int x , y;
	public Heart(Player player , int x , int y) {
		this.player=player;
		this.x=x;
		this.y=y;
		bounds = new Rectangle(0, 0, 128, 32);

	}

	public void Draw(Graphics g) {
		g.drawImage(ImageLoader.heart, x, y, 32, 32, null);

	}
	// 
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 16);

	}
}
