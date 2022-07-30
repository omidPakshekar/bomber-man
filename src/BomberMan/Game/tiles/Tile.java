package BomberMan.Game.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import BomberMan.Game.Game;

public class Tile {
	
	//hr chizi ye id dre bar asas oon id ono be tiles add mikonim
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneWall = new stoneWall(1);
	public static Tile Wall = new WallTile(2);
	
	
	
	// chon 15 * 15 hst map vase hamin width va height ro taghsim bar 15 mikoinm
	
	public static final int TILEWIDTH = (int) (Game.width / 15 ), TILEHEIGHT = (int) (Game.height / 15);
	
	protected BufferedImage image;
	protected final int id;
	
	public Tile(BufferedImage image, int id){
		this.image = image;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void Draw(Graphics g, int x, int y){
		g.drawImage(image, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	public boolean isExplodable() {
		return false;
	}
}
