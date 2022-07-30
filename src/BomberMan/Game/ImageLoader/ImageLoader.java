package BomberMan.Game.ImageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {


	public static BufferedImage dirt, grass, wall, tree, bomb, Enemy, Key, heart , star , stoneWall;
	public static BufferedImage[] player_down, player_up, player_left, player_right ;

	public static void init() {

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];

		player_down[0] = loadImage("/Image/Characters/Yellow_Front2.png");
		player_down[1] = loadImage("/Image/Characters/Yellow_Front3.png");
		player_up[0] = loadImage("/Image/Characters/Yellow_Back2.png");
		player_up[1] = loadImage("/Image/Characters/Yellow_Back3.png");
		player_right[0] = loadImage("/Image/Characters/Yellow_Right2.png");
		player_right[1] = loadImage("/Image/Characters/Yellow_Right3.png");
		player_left[0] = loadImage("/Image/Characters/Yellow_Left2.png");
		player_left[1] = loadImage("/Image/Characters/Yellow_Left3.png");

		Enemy = loadImage("/Image/Characters/Enemy/barnacle.png");
		bomb = loadImage("/Image/Item/bomb.png");
		Key = loadImage("/Image/Item/hud_keyYellow.png");
		grass = loadImage("/Image/Tile/grass.png");
		wall = loadImage("/Image/AroundGame/castle.png");
		heart = loadImage("/Image/Item/hud_heartFull.png");
		star = loadImage("/Image/Item/star.png");
		stoneWall = loadImage("/Image/AroundGame/sand.png");
	}

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {}
		return null;
	}

}
