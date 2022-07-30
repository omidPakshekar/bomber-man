package BomberMan.Game.Creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import BomberMan.Game.Game;
import BomberMan.Game.GameManger.GameManager;
import BomberMan.Game.GameObject.Bomb;
import BomberMan.Game.ImageLoader.Animation;
import BomberMan.Game.ImageLoader.ImageLoader;
import BomberMan.Game.tiles.Tile;

public class Player extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	public int Health = 100;
	private static long Time;
	private Bomb bomb;
	private boolean BombBzr = true;

	public Player(Game game, int x, int y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = (int) (Tile.TILEWIDTH / 4);
		bounds.y = (int) (Tile.TILEHEIGHT / 2);
		bounds.width = (int) (Tile.TILEHEIGHT / 4 + Tile.TILEHEIGHT / 4);
		bounds.height = (int) (Tile.TILEHEIGHT / 2);

		Time = System.currentTimeMillis();
		// Animatons
		animDown = new Animation(500, ImageLoader.player_down);
		animUp = new Animation(500, ImageLoader.player_up);
		animLeft = new Animation(500, ImageLoader.player_left);
		animRight = new Animation(500, ImageLoader.player_right);
	}

	public void update() {
		// Animations
		animDown.upade();
		animUp.upade();
		animRight.upade();
		animLeft.upade();
		// Movement
		getInput();
		move();

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (game.getKeyManager().up) {
			yMove = -speed;
			BombBzr = true;
		}
		if (game.getKeyManager().down) {
			yMove = speed;
			BombBzr = true;
		}
		if (game.getKeyManager().left) {
			xMove = -speed;
			BombBzr = true;
		}
		if (game.getKeyManager().right) {
			xMove = speed;
			BombBzr = true;
		}
		if (game.getKeyManager().bomb) {
			// chon age ino nazarim ta vaghti ke dastemon roye x hast
			// bomb mizare
			if (BombBzr) {
				GameManager.bombObj.add(new Bomb(x, y));
				BombBzr = false;
				game.setTddBomb(game.getTddBomb()+1);
			}

		}
	}

	public void Draw(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
		
	}

	private BufferedImage getCurrentAnimationFrame() {
		// hr kodom az tasavir ro bar asas samti ke mire rsm mikone
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else {
			return animDown.getCurrentFrame();
		}
	}

	public boolean ImPlayer() {
		return true;
	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, bounds.width, bounds.height);

	}

	public boolean collisoin(Enemy enemy) {
		return enemy.getBounds().intersects(getBounds());
	}

	public long getTime() {
		return Time;
	}

	public void setTime(long Time) {
		this.Time = Time;
	}

}
