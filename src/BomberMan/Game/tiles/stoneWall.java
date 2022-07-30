package BomberMan.Game.tiles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import BomberMan.Game.GameManger.GameManager;
import BomberMan.Game.ImageLoader.ImageLoader;
import BomberMan.Game.Map.Map;

public class stoneWall extends Tile {

	public stoneWall( int id) {
		super(ImageLoader.stoneWall , id);
	}
	public boolean isSolid() {
		return true;
	}

	

	
}
