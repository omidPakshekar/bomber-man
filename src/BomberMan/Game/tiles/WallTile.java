package BomberMan.Game.tiles;

import BomberMan.Game.ImageLoader.ImageLoader;

public class WallTile extends Tile {

	public WallTile(int id) {
		super(ImageLoader.wall, id);
	}
	/// yani age be in bokhore nemitone rd beshe
	@Override
	public boolean isSolid(){
		return true;
	}

}
