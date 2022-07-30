package BomberMan.Game.Creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import BomberMan.Game.Game;
import BomberMan.Game.ImageLoader.ImageLoader;
import BomberMan.Game.tiles.Tile;

public class Enemy {

	private int MotaghayrX = 1, KodomHrkt, MotaghayrY = 1;

	private float xMove, yMove;

	protected Game game;
	private int x, y;
	private int width, height;
	private Rectangle bounds;

	public Enemy(Game game, int x, int y, int width, int height, int KodomHrkt) {

		this.KodomHrkt = KodomHrkt;
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0, 0, width, height);

		xMove = 0;

		bounds.x = (int) (Tile.TILEWIDTH / 4);
		bounds.y = (int) (Tile.TILEHEIGHT / 2);
		bounds.width = (int) (Tile.TILEWIDTH - Tile.TILEWIDTH / 3);
		bounds.height = (int) (Tile.TILEHEIGHT / 2 - 5);

		xMove = 1;
	}

	boolean f2 = true;

	public void update() {


		if (KodomHrkt == 1) {
			xMove = 1;
			xMove = 1 * MotaghayrX;
			Hrkt();
			//
		}
		if (KodomHrkt == 2) {
			yMove = 1;
			yMove = 1 * MotaghayrY;
			moveY();
		}

	}

	public void Hrkt() {
		if (xMove > 0) {// Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

				x += xMove;
			} else {
				MotaghayrX *= -1;
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}

		} else if (xMove < 0) {// Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				MotaghayrX *= -1;
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;

			}

		}

	}

	public void moveY() {
		/**
		 * dr inja ma miyam hr chizi ro be shkl mostatil mibim va hr bar mas tabe
		 * collisionWithTile ro seda mizanim chon oon meghdr x , y ra mikhad bra hamin
		 * ma bayad meghdr pixel ro tbdil konim be mokhtasat x , y
		 */
		if (yMove < 0) {// Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				// if(x + bounds.x)
				y += yMove;

			} else {
				MotaghayrY *= -1;
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}

		} else if (yMove > 0) {// Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				MotaghayrY *= -1;

				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}

		}
	}

	public void Draw(Graphics g) {
		g.drawImage(ImageLoader.Enemy, (int) (x), (int) (y), width, height, null);
	
	}

	public boolean collisionWithTile(int x, int y) {
		// inn ba mokhtasati ke dre mire bebin ke oon jesm dr hal harkat hst ya na
		return game.getWorld().getTile(x, y).isSolid();
	}

	public boolean ImEnemy(int x, int y) {
		return true;
	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, bounds.width, bounds.height);

	}

}
