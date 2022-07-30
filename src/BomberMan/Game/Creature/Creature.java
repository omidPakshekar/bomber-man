package BomberMan.Game.Creature;

import java.awt.Rectangle;

import BomberMan.Game.Game;
import BomberMan.Game.tiles.Tile;

public abstract class Creature  {
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = Tile.TILEWIDTH
							,DEFAULT_CREATURE_HEIGHT = Tile.TILEHEIGHT;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;


	protected Game game;
	protected int x, y;
	protected int width, height;
	protected Rectangle bounds;
	
		
		
	public Creature(Game game, int x, int y, int width, int height) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);

		
		health = 100;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		moveX();
		moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;

			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){

				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;

			}
			
		}
	}
	
	public void moveY(){
		/**
		 * dr inja ma miyam hr chizi ro be shkl mostatil mibim 
		 * va hr bar mas tabe collisionWithTile ro seda mizanim chon
		 * oon meghdr x , y ra mikhad bra hamin ma bayad meghdr pixel ro
		 * tbdil konim be mokhtasat x , y
		 */
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
//				if(x + bounds.x)
				y += yMove;
				
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	public Rectangle getBounds() {

		return new Rectangle(x, y, bounds.width, bounds.height);

	}


	protected boolean collisionWithTile(int x, int y){
		// inn ba mokhtasati ke dre mire bebin ke oon jesm dr hal harkat hst ya na
		return game.getWorld().getTile(x, y).isSolid();
	}
	
	public boolean isSolid() {
		return true;
	}
	//GETTERS SETTERS

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	

}
