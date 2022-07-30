package BomberMan.Game.GameManger;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import BomberMan.Game.Game;
import BomberMan.Game.Creature.Enemy;
import BomberMan.Game.Creature.Player;
import BomberMan.Game.GameObject.Bomb;
import BomberMan.Game.GameObject.Heart;
import BomberMan.Game.GameObject.Star;
import BomberMan.Game.Map.Map;
import BomberMan.Game.ObjectManager.ObjectManger;
import BomberMan.Game.tiles.Tile;

public class GameManager {

	private Player player;
	private Enemy enemy;
	private Heart heart;
	private Star star;
	private Map world;
	private Game game;
	public static ArrayList<Enemy> enemyObj = new ArrayList<>();
	public static ArrayList<Bomb> bombObj = new ArrayList<>();
	public static ArrayList<String> Hrkt = new ArrayList<>();
	public static ArrayList<Heart> heartObj = new ArrayList<>();
	public static ArrayList<Star> StarObj = new ArrayList<>();

	public GameManager(Game game) {
		world = new Map(game, "res/worlds/world1.txt");
		this.game = game;
		game.setWorld(world);
		player = new Player(game, 100, 100);
		// be tdd enemy object misaze add mikone
		for (int i = 0; i < game.getTddEnemy(); i++) {
			String[] g = RndomHrkt().split(" ");

			enemy = new Enemy(game, Integer.parseInt(g[0]), Integer.parseInt(g[1]), Tile.TILEWIDTH, Tile.TILEHEIGHT,
					Integer.parseInt(g[2]));
			enemyObj.add(enemy);

		}

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						// hr bar 40 saniye sbr mikon
						Thread.sleep(40 * 1000);
						// bad 40 saniye ghbl haye ghbli ro hzf mikonim
						for (int i = 0; i < heartObj.size(); i++) {
							heartObj.remove(i);
						}
						String[] Hold = RndomHrkt().split(" ");
						heart = new Heart(player, Integer.parseInt(Hold[0]), Integer.parseInt(Hold[1]));

						heartObj.add(heart);
					} catch (InterruptedException e) {
					}

				} // end while --->true
			}
		});
		t.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Random rndm = new Random();
						// beyn 10 ta 90 saniye dr safhe hst
						Thread.sleep((rndm.nextInt(80) + 10) * 1000);
						for (int i = 0; i < StarObj.size(); i++) {
							StarObj.remove(i);
						}
						String[] Hold = RndomHrkt().split(" ");
						star = new Star(Integer.parseInt(Hold[0]), Integer.parseInt(Hold[1]));

						StarObj.add(star);
					} catch (InterruptedException e) {
					}

				} // end while --->true
			}
		});
		t2.start();

	}

	public void update() {
		world.update();
		player.update();
		for (int i = 0; i < enemyObj.size(); i++) {
			enemyObj.get(i).update();
		}
		// etelatat ro be object manager mifrstim
		new ObjectManger(player, game);

	}

	public void render(Graphics g) {
		world.Draw(g);
		player.Draw(g);

		for (int i = 0; i < enemyObj.size(); i++) {
			enemyObj.get(i).Draw(g);
		}
		for (int i = 0; i < bombObj.size(); i++) {
			bombObj.get(i).Draw(g);
		}
		for (int i = 0; i < heartObj.size(); i++) {
			heartObj.get(i).Draw(g);
		}
		for (int i = 0; i < StarObj.size(); i++) {
			StarObj.get(i).Draw(g);
		}

	}

	public String RndomHrkt() {
		Random rndm = new Random();
		int XX, YY;
		int rndX, rndY;
		String Hold = "";
		Label: while (true) {

			while (true) {

				rndX = rndm.nextInt(13);
				rndY = rndm.nextInt(13);

				int[][] HoldTile = world.getTiles();

				if (HoldTile[rndX][rndY] == 2 || HoldTile[rndX][rndY] == 1) {
					continue;
				}
				// age rndx frd bood hrkt

				XX = Tile.TILEWIDTH * rndX;
				YY = Tile.TILEHEIGHT * rndY;

				Hold = String.valueOf(XX);
				Hold += " ";
				Hold += String.valueOf(YY);
				Hold += " ";
				// age rndX frd bashe hrkt amodi hst
				// age rndX zoj bashe hrkt ofoghi hst

				if (rndX % 2 != 0) {
					Hold += "2";
				} else if (rndX % 2 == 0) {
					Hold += "1";
				}

				boolean f = false;
				
				// hrkt ro dr araye zkhire mikonim hr bar cheack mikonim  ke hrkt jdid 
				// to hrkt ghbli hst ya na
				for (int j = 0; j < Hrkt.size(); j++) {
					String HoldStr = Hrkt.get(j);
					if (HoldStr.equals(Hold)) {
						f = true;
					}
				}

				if (!f) {
					world.setTiles(HoldTile);
					Hrkt.add(Hold);
					break Label;

				}

			}

		} // while--->true
		return Hold;
	}// Rndm Hrkt Method
}
